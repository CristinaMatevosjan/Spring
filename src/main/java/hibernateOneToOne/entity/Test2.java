package hibernateOneToOne.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//отношение 1 к 1 юни дирекшенал
public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session=null;

        try {

//            session=factory.getCurrentSession();
//
//            Employee employee=new Employee("Misha", "Sidorov", "hr", 300);
//            Detail detail=new Detail("hjvh","12879873456","ssffgljk.com");
////создаем 1 к 1 связь бай дирекшинал, для этого сеттером добавляем данные и тому и другому
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//
//            session.beginTransaction();
//
//            session.save(detail);
//
//            session.getTransaction().commit();


//            session=factory.getCurrentSession();
////получим информацию из базы
//            session.beginTransaction();
//            Detail detail=session.get(Detail.class,3);
//            System.out.println(detail.getEmployee()); // получм инфо о работнике по его детаям
//
//            session.getTransaction().commit();


//            session=factory.getCurrentSession();
////удалим детали о работнике
//            session.beginTransaction();
//            Detail detail=session.get(Detail.class,3);
//
//            session.delete(detail); // работник тоже удалится благодаря каскаду
//
//            session.getTransaction().commit();


            session=factory.getCurrentSession();
//удалим детали о работнике
            session.beginTransaction();
            Detail detail=session.get(Detail.class,1);// какскад с олл изменен, поэтому работник останется
            //но! надо сначала разрушить между ними связь
            detail.getEmployee().setEmpDetail(null); //просто присвоив нал
            session.delete(detail);

            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}