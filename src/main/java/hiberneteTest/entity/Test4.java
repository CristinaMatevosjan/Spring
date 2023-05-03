package hiberneteTest.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//изменение таблицы апдейт
        try {
            Session session=factory.getCurrentSession();
            session.beginTransaction();
            //получим работника по ай ди и изменим ее зарплату
//            Employee emp=session.get(Employee.class,1);
//            emp.setSalary(1500); // легко с помощью сеттера на объекте джава меню зп
            session.createQuery("update Employee set salary=1000 " +
                    "where name='Elena'")
                            .executeUpdate(); // запускаем с помощью экзекут апдейт


            session.getTransaction().commit(); // тут транзакции надо открывать и закрывать самим
        }
        finally {
            factory.close();
        }
    }
}
