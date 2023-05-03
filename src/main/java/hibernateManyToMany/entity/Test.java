package hibernateManyToMany.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session=null;

        try {
//            session=factory.getCurrentSession();
//
//            Section section1=new Section("football");
//
//            Child child1=new Child("kris", 6);
//            Child child2=new Child("dav", 3);
//            Child child3=new Child("vano", 5);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
            //*************************************************************
//            session=factory.getCurrentSession();
//
//            Section section1=new Section("match");
//            Section section2=new Section("voleiball");
//            Section section3=new Section("chess");
//
//            Child child1=new Child("igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
            //*************************************************************
//            session=factory.getCurrentSession();
//
//
//            session.beginTransaction();
//
//           Section section=session.get(Section.class,1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
            //***********************************************************
//            session=factory.getCurrentSession();
//
///            session.beginTransaction();
//
//            Child child=session.get(Child.class,4);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
            //*********************************************************************
//            session=factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section=session.get(Section.class,1);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            session=factory.getCurrentSession();
//
//            Section section1=new Section("football");
//
//            Child child1=new Child("kris", 6);
//            Child child2=new Child("dav", 3);
//            Child child3=new Child("vano", 5);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//
//            session.getTransaction().commit();
            //*************************************************************
//            session=factory.getCurrentSession();
//
//            Section section1=new Section("dance");
//
//            Child child1=new Child("olja", 6);
//            Child child2=new Child("tanja", 3);
//            Child child3=new Child("petja", 5);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1); //здесь используем персист вместо сейв
//             для каскадного сохранения когда тип каскада стоит не олл
//
//            session.getTransaction().commit();
            //*********************************************************************
//            session=factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section1=session.get(Section.class,6);
//            session.delete(section1);
//
//            session.getTransaction().commit();
            //*******************************************************************
            session=factory.getCurrentSession();
            session.beginTransaction();

            Child child=session.get(Child.class, 5);
            session.delete(child);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
