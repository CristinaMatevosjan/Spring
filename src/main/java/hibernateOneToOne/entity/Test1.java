package hibernateOneToOne.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//отношение 1 к 1 юни дирекшенал
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session=null;

        try {
//            Session session=factory.getCurrentSession();
//            Employee employee=new Employee("Kris", "Mat", " it", 800);
//            Detail detail=new Detail("arch","123456","sfgg.com");
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();

////
//            session=factory.getCurrentSession();
//            session.beginTransaction();
//           Employee employee=session.get(Employee.class,1);
//            System.out.println(employee.getEmpDetail());
//
//            session.getTransaction().commit();



            session=factory.getCurrentSession();
            session.beginTransaction();
            Employee employee=session.get(Employee.class,2);
            session.delete(employee);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
