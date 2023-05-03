package hibernateOneToManyUni.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//отношение 1 к 1 юни дирекшенал
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(hibernateOneToManyUni.entity.Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session=null;

        try {

//            session=factory.getCurrentSession();
//            Department dep=new Department("hr",500,1000);
//            Employee emp1=new Employee("kot","mat",600);
//            Employee emp2=new Employee("anna","atman",900);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();


//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department=session.get(Department.class,4);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();


//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee=session.get(Employee.class,1);
//            System.out.println(employee);
//
//            session.getTransaction().commit();

//***********************************************************************************************
            session=factory.getCurrentSession();

            session.beginTransaction();
            Department department=session.get(Department.class,8);

            session.delete(department);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
