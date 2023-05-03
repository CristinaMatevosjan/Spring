package hiberneteTest.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session=factory.getCurrentSession();
            Employee employee=new Employee("Oleg", "Sidorov","hr",8000);
            session.beginTransaction();
            session.save(employee); // это был инсерт/креэйт
           // session.getTransaction().commit(); // тут транзакции надо открывать и закрывать самим

            int myId=employee.getId(); //рид делается через селект
//            session=factory.getCurrentSession(); // надо снова открыть сессию, потому что закрыли ее на прошлом шаге
//            session.beginTransaction();
            Employee employee1=session.get(Employee.class,myId); // получть того же работника,
            // которого только что добавила. за гет отвечает селект
            System.out.println(employee1);
            session.getTransaction().commit(); // закрваем сессию


        }
        finally {
            factory.close();
        }
    }
}
