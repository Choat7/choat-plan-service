package com.choat.plan.controller;

import com.google.common.base.Joiner;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        String a = null;
        Optional<String> ao = Optional.ofNullable(a);
        System.out.println(ao.isPresent());
        Joiner joiner = Joiner.on(";").skipNulls();
        String aa = joiner.join("24",null,"532","234");
        System.out.println(aa);
    }
}
