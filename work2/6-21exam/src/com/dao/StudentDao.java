package com.dao;

import com.pojos.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDao {
    public SessionFactory init()
    {
        Configuration configuration=new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public List query()
    {
        Session session=this.init().openSession();
        Query query=session.createQuery("");
        List<Student> list=query.list();
        session.close();
//        hql??????????????
        return list;
    }

    public void add(Student student)
    {
        Session session=this.init().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

}
