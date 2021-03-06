package com.webshop.simplewebapplication.database.Device;

import com.webshop.simplewebapplication.database.HibernateSessionFactoryUtil;
import com.webshop.simplewebapplication.model.Device;
import com.webshop.simplewebapplication.model.Garanty;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceDAOHib implements DeviceDAO {

    @Override
    public void addDevice(Device device) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(device);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Device> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Device> devices = (List<Device>) session.createQuery("from Device").list();
            return devices;
        }catch (Exception e){
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public Device findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery("FROM Device where id = :id");
            query.setParameter("id", id);
            return (Device)query.list().get(0);
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteDevice(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            Device device = findById(id);
            session.delete(device);
            transaction.commit();
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public int countOfDevices() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try {
            List<Device> devices = (List<Device>) session.createQuery("From Device").list();
            return devices.size();
        }catch (Exception e){
            return 0;
        }finally {
            session.close();
        }
    }

    @Override
    public void changeDevice(Device device, String model) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try{
            Transaction transaction = session.beginTransaction();
            device.setModel(model);
            session.update(device);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
