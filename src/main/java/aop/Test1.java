package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new
                AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary=context.getBean("uniLibrary", UniLibrary.class);
        Book book=context.getBean("book", Book.class);
        uniLibrary.getBook();
//        SchoolLibrary schoolLibrary=context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
//        uniLibrary.returnBook();
//        uniLibrary.returnMagazine();
        uniLibrary.addBook("kris", book);
        uniLibrary.addMagazine();


        context.close();
    }
}
