package com.kristinamat.spring.introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Dog implements Pet {
    //private String name;
    public Dog() {
        System.out.println("Dog bean is created");
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
    @PostConstruct
    public void init(){
        System.out.println("Class dog: init metod");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog : destroy metod");
    }

    @Override
    public  void say(){
        System.out.println("gav-gav");
    }
}
