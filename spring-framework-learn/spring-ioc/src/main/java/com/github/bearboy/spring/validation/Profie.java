package com.github.bearboy.spring.validation;

import javax.validation.constraints.NotBlank;

public class Profie {
    @NotBlank
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
