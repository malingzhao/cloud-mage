package com.mlz.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    //只有编码和message的编码
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
