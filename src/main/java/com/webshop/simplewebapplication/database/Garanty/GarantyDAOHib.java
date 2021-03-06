package com.webshop.simplewebapplication.database.Garanty;

import com.webshop.simplewebapplication.database.HibernateSessionFactoryUtil;
import com.webshop.simplewebapplication.model.Garanty;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GarantyDAOHib implements GarantyDAO{
    @Override
    public List<Garanty> getActive() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Garanty> garanties = (List<Garanty>) session.createQuery("From Garanty where date >= :date").setParameter("date", new Date()).list();
            return garanties;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Garanty> getOverdue() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Garanty> garanties = (List<Garanty>) session.createQuery("From Garanty where date < :date").setParameter("date", new Date()).list();
            return garanties;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Garanty> getAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Garanty> garanties = (List<Garanty>) session.createQuery("From Garanty").list();
            return garanties;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void addGaranty(Garanty garanty) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(garanty);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public Garanty findByID(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM Garanty where id = :id");
            query.setParameter("id", id);
            return (Garanty) query.list().get(0);
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteGaranty(Garanty garanty) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.delete(garanty);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
