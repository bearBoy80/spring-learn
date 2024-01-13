package com.github.bearboy.spring.type.converter;

import org.springframework.core.convert.converter.Converter;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 自定义converter实现，实现字符串转properties
 */
public class StringToPropertiesConverter implements Converter<String, Properties> {
    @Override
    public Properties convert(String source) {
        try {
            Properties props = new Properties();
            // Must use the UTF-8 encoding because Properties.load(stream) expects it.
            props.load(new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)));
            return props;
        } catch (Exception ex) {
            // Should never happen.
            throw new IllegalArgumentException("Failed to parse [" + source + "] into Properties", ex);
        }
    }
}
