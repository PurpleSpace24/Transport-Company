package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entity.Driver;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DriverDAO {

    // save company
    public static void saveDriver(Driver driver) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    public static void saveOrUpdateDriver(Driver driver) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    // save list of drivers
    public static void saveDrivers(List<Driver> drivers) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            drivers.forEach(session::save);
            transaction.commit();
        }
    }

    // get all drivers from db
    public static List<Driver> readDrivers() {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Driver ", Driver.class).getResultList();
        }
    }

    // delete driver
    public static void deleteDriver(Driver driver){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(driver);
            transaction.commit();
        }
    }

    // sort driver by qualification and salary
    public static void sortDriverByQualificationAndSalary(){
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            session.createQuery("FROM Driver ORDER by driverQualification,driverSalary", Driver.class).getResultList();
        }
    }

    // write in file from db
    public static void writeDriver(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("All drivers: " + readDrivers() + System.lineSeparator());
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // read from file
    public static void readDr(String fileName){
        try(FileReader fr = new FileReader(fileName)){
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
