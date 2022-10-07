package dao;

import configuration.SessionFactoryUtil;
import entity.Client;
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
import java.math.BigDecimal;
import java.util.List;



public class ClientDAO {

    // save client
    public static void saveClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    // save or update
    public static void saveOrUpdateClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

        // save list of clients
     public static void saveClients (List < Client > clientList) {
            try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                clientList.stream().forEach((com) -> session.save(com));
                transaction.commit();
            }
        }

    // get all clients
    public static List<Client> readClient () {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Client", Client.class).getResultList();
        }
    }

    // delete client
    public static void deleteClient (Client client){
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }

    // write in file from db
    public static void writeCl(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("All clients: " + readClient() + System.lineSeparator());
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // read from file
    public static void readCl(String fileName){
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
