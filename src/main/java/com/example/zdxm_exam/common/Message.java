package com.example.zdxm_exam.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Message<T> {
    private int code = 1;
    private String message;
    private T data;
}
