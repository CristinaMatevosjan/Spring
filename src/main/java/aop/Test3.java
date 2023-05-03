package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(" method main starts");
        AnnotationConfigApplicationContext context=new
                AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary=context.getBean("uniLibrary", UniLibrary.class);
        String bookName=uniLibrary.returnBook();
        System.out.println( "в библиотеку вернули книгу "+bookName);
        System.out.println(" method main ends");


        context.close();
    }
}
