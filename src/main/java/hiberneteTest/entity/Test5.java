package hiberneteTest.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//удаление объектов делит
        try {
            Session session=factory.getCurrentSession();
            session.beginTransaction();

//            Employee emp=session.get(Employee.class,1);
//            session.delete(emp);
            // если готового объекта нет можно удалять через HQL
            session.createQuery("delete Employee " +
                    "where name='Elena'")
                    .executeUpdate();

            session.getTransaction().commit(); // тут транзакции надо открывать и закрывать самим
        }
        finally {
            factory.close();
        }
    }
}
