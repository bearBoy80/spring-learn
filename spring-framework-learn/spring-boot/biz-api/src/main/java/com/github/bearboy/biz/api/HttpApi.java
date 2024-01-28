package com.github.bearboy.biz.api;

import jakarta.validation.Valid;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public abstract class HttpApi<T> {

    @Deprecated
    private Map<String, String> headers;

    @Deprecated
    private MultiValueMap<String, String> metadata;

    @Valid
    private T body;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public MultiValueMap<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(MultiValueMap<String, String> metadata) {
        this.metadata = metadata;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}