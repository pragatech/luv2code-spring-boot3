package com.praga.demo.entity;


import lombok.Data;

@Data
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
