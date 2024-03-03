````# Spring Event
Spring事件（Spring events）是Spring框架中的一种机制，用于在应用程序中实现基于发布-订阅模式的事件通知机制。我们可以基于Spring event来实现简单的业务解耦。本文将基于SpringFramework5.3.32版本介绍Spring Event使用方式和相关示例。
## Spring Event核心组件
在Spring中，事件是通过以下几个核心组件来实现的：

1. 事件（Event）：
    - 事件是应用程序中某个状态或操作的表示。
    - 在Spring中，事件通常是一个Java对象，可以是预定义的Spring事件类型（如`ApplicationEvent`的子类），也可以是自定义的事件类型。

2. 事件发布器（Event Publisher）：
    - 事件发布器负责发布事件。
    - 在Spring中，可以使用`ApplicationEventPublisher`接口来发布事件。
    - 通常，事件发布器由Spring容器中的组件实现，可以是Spring Bean或其他组件。

3. 事件监听器（Event Listener）：
    - 事件监听器负责订阅和处理事件。
    - 在Spring中，可以使用`ApplicationListener`接口或通过注解（如`@EventListener`）来定义事件监听器。
    - 监听器可以注册到事件发布器上，以接收特定类型的事件通知。

## Spring Event相关事件介绍
| 事件                         | 描述                                                                                                                                                                                                                            |
|----------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ContextRefreshedEvent      | 当ApplicationContext被初始化或刷新时发布。这个事件表示ApplicationContext已经加载完所有的Bean，激活了后置处理器Bean，实例化了所有的单例Bean，准备好被使用。只要上下文没有关闭，可以多次触发刷新，前提是所选择的ApplicationContext实际上支持这种“热”刷新。例如，XmlWebApplicationContext支持热刷新，但GenericApplicationContext不支持。 |
| ContextStartedEvent        | 当ApplicationContext通过ConfigurableApplicationContext接口的start()方法启动时发布。这里的“启动”意味着所有的Lifecycle Bean接收到了显式的启动信号。通常，这个信号用于在显式停止后重新启动Bean，但也可以用于启动未配置为自动启动的组件（例如，在初始化时尚未启动的组件）。                                                     |
| ContextStoppedEvent        | 当ApplicationContext通过ConfigurableApplicationContext接口的stop()方法停止时发布。这里的“停止”意味着所有的Lifecycle Bean接收到了显式的停止信号。停止的上下文可以通过调用start()方法重新启动。                                                                                         |
| ContextClosedEvent         | 当ApplicationContext通过ConfigurableApplicationContext接口的close()方法或JVM的关闭钩子进行关闭时发布。这里的“关闭”意味着所有的单例Bean都将被销毁。一旦上下文关闭，它就达到了生命周期的终点，无法进行刷新或重新启动。                                                                                    |
| RequestHandledEvent        | 一个特定于Web的事件，通知所有的Bean一个HTTP请求已经被处理。该事件在请求完成后发布。此事件仅适用于使用Spring的DispatcherServlet的Web应用程序。                                                                                                                                     |
| ServletRequestHandledEvent | RequestHandledEvent的子类，提供了Servlet特定的上下文信息。它包含与Servlet请求处理相关的附加详细信息。                                                                                                                                                           |

## Spring Event 使用步骤
### 自定义Event
继承ApplicationEvent类，并覆盖构造器。

示例如下：
```java
/**
 * 根据实际情况实现对应的构造器
 */
import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
    private String message;

    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

```
### 实现自定义Event监听
实现自定义事件监听有两种方式：
 - 实现ApplicationListener接口并指定泛型类型
 - 通过注解@EventListener来实现
```java
import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received custom event with message: " + event.getMessage());
    }
}
```

### 注册监听器到Spring容器
如果是通过非注解实现的监听器注册方式：
- ApplicationContext.addApplicationListener来实现监听器的注册。
```java
  public class SpringEventDemo {
  public static void main(String[] args) {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
  ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) context;
  applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
  @Override
  public void onApplicationEvent(ApplicationEvent event) {
  println("收到事件：" + event);
  }
  });
  context.register(SpringEventDemo.class);
  context.register(MyListener.class);
  //启动容器并refresh
  context.refresh();
  //发布start事件
  context.start();
  //关闭容器
  context.close();
  }
}
```
- 作为一个Spring Bean的方式来实现注册
```java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(EventPublisher.class);
        context.registerBean(CustomEventListener.class);
        context.refresh();

        EventPublisher eventPublisher = context.getBean(EventPublisher.class);
        eventPublisher.publishEvent("Hello, Spring Event!");

        context.close();
    }
}
```

### 发布自定义事件
发布事件的方式有两种：
 - ApplicationEventPublisher类来实现
 - ApplicationEventMulticaster来实现

两种方式本质上还是通过ApplicationEventMulticaster来实现事件发布
示例代码如下：
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public class EventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public EventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(String message) {
        CustomEvent event = new CustomEvent(this, message);
        eventPublisher.publishEvent(event);
    }
}
```

## 总结
通过Spring容器提供的event事件机制，发布一个事件时，所有注册了对应事件类型的监听器都会收到通知，并执行相应的操作。这种机制使得应用程序中的不同模块可以松散耦合地进行通信和交互，从而提高代码的可维护性和可扩展性。
Spring事件的典型应用场景包括：
- 在应用程序中触发某个操作后，通知其他模块执行相应的任务。
- 在应用程序中的某个状态发生变化时，通知其他模块进行相应的处理。
- 在应用程序中进行日志记录、监控或度量等操作时，触发相应的事件。

总结的来说，Spring事件机制提供了一种灵活的、松散耦合的组件通信方式，通过事件的发布和监听，不同模块可以有效地进行解耦，实现更高效的应用程序设计和开发。
相关代码见[github](https://github.com/bearBoy80/spring-learn/tree/main/spring-framework-learn/spring-ioc/src/main/java/com/github/bearboy/spring/event)````