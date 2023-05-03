package hibernateOneToManyBy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {

//            session = factory.getCurrentSession();
//            Department dep = new Department("sales", 1000, 500);
//            Employee emp1 = new Employee("kris", "mat", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 700);
//            Employee emp3 = new Employee("Anna", "Vodnikova", 900);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//
//            session.save(dep);
//
//            session.getTransaction().commit();
//*****************************************************************************************************
            session=factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department");
            Department department=session.get(Department.class,15);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим работников");
            department.getEmps().get(0); // это такой обман, т к тут лэзи и до окнчания сессии
            // надо загрузить работников чтобы не было исключения
// при игор такого обмана делать не надо
            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
//*****************************************************************************************************
//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee=session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//*****************************************************************************************************

//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee=session.get(Employee.class,3);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();
//        }

        }
        finally{
            session.close();
            factory.close();
        }
    }
}
