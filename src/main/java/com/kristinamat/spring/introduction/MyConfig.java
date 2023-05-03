package com.kristinamat.spring.introduction;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("com.kristinamat.spring.introduction")
public class MyConfig {
    @Bean
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }
    @Bean
    public Person personBean(){
        return  new Person(catBean());
    }


}
