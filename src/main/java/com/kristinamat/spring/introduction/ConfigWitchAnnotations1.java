package com.kristinamat.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWitchAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person=context.getBean("personBean", Person.class);
        person.collYourPet();

        System.out.println(person.getAge());
        System.out.println(person.getSurname());

//        Cat myCat=context.getBean("catBean", Cat.class);
//        myCat.say();

        context.close();
    }
}
