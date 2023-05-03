package hiberneteTest.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
//получение объектов из базы не по ай ди,а с помощью HQL(хайбернет)
        try {
            Session session=factory.getCurrentSession();
// выведем всех работников на экран
            session.beginTransaction();
//            List<Employee> employees=session.createQuery("from Employee") //создание запроса с указанием имени класса
//                            .getResultList(); // получение запроса списком

            List<Employee> employees=session.createQuery("from Employee "+
                    "where name = 'Elena' and salary>1000") //добавила запрос по условию здесь нейим это поле класса эмплои
                    .getResultList(); //
            for (Employee e: employees){
                System.out.println(e); // выводим форычем
            }


            session.getTransaction().commit(); // тут транзакции надо открывать и закрывать самим
        }
        finally {
            factory.close();
        }
    }
}
