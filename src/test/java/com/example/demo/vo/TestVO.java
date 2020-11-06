package com.example.demo.vo;

import java.util.List;

import lombok.Builder;
import lombok.Singular;


@Builder
public class TestVO {
    private final int userSeq;
    private String userName;
    private String email;
    @Builder.Default private int age = 20;
    @Singular private List<String> values;
}