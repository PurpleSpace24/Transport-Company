package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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

public class VehicleDAO {

     public static void saveVehicle(Vehicle vehicle){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    public static void saveOrUpdateVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    // save list of vehicles
    public static void saveVehicles(List<Vehicle> vehicleList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicleList.stream().forEach((com) -> session.save(com));
            transaction.commit();
        }
    }

    // get all vehicles
    public static List<Vehicle> readVehicle() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Vehicle", Vehicle.class).getResultList();
        }
    }

    // delete vehicle
    public static void deleteVehicle(Vehicle vehicle){
         try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
             Transaction transaction = session.beginTransaction();
             session.delete(vehicle);
             transaction.commit();
         }
     }

     // sort vehicle by km
     public static void sortVehicleByKm(){
         try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
           session.createQuery("FROM Vehicle ORDER BY km", Vehicle.class).getResultList();
         }
     }

    // write in file from db
    public static void writeVeh(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("All vehicles: " + readVehicle() + System.lineSeparator());
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // read from file
    public static void readVeh(String fileName){
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
