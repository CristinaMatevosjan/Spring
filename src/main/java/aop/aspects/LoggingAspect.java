package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private  void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private  void allMethodsExceptReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodExceptReturnMagazineAdvice: log #10");
//    }

//@Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary(){}
//
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing log #3");
//    }
//


    @Before("aop.aspects.MyPointcuts.allAddMethods()") // в скобках поинт кат
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

       MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature + "=methodSignature");
        System.out.println(methodSignature.getMethod() + "=methodSignature.getMethod()");
        System.out.println(methodSignature.getReturnType() + "=methodSignature.getReturnType()");
        System.out.println(methodSignature.getName() + "=methodSignature.getName()");

        if(methodSignature.getName().equals("addBook")){
            Object[] arguments=joinPoint.getArgs();
            for (Object object: arguments){
                if(object instanceof Book){
                    Book myBook=(Book) object;
                    System.out.println("инфо о книге "+ myBook.getName()+ " "+myBook.getAuthor()+" "
                            + myBook.getYarsOfPublication());
                } else if (object instanceof  String) {
                    System.out.println(" книгу в бибилиотеку добавляет "+ object);
                }
            }
        }

        System.out.println("beforeGetBookAdvice : логгирование попытки получить книгу/журнал");
        System.out.println("---------------------------------------------------------");
    }


//    @Before("execution(* returnBook())") // если не указать модификатор доступа
//    // то подойдет любой, * озночает любой тип данных
//    public void beforeReturnBookAdvice() {
//        System.out.println("beforeReturnBookAdvice : попытка вернуть книгу");
//    }
}
