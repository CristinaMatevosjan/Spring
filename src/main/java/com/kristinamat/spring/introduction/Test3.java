package com.kristinamat.spring.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new
                ClassPathXmlApplicationContext("applicationcontext.xml");
        //Pet pet=context.getBean("myPet", Pet.class);

        Person person=context.getBean("myPerson", Person.class);  //new Person(pet);
        person.collYourPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
