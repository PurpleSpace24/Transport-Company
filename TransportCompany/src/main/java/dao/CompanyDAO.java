package dao;

import configuration.SessionFactoryUtil;
import entity.Company;
import entity.Driver;
import entity.Vehicle;
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
import java.util.List;

public class CompanyDAO {

    // save company
    public static void saveCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    // save or update
    public static void saveOrUpdateCompany(Company company) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(company);
            transaction.commit();
        }
    }

    // save list of companies
        public static void saveCompanies(List<Company> company1) {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                company1.forEach(session::save);
                transaction.commit();
            }
        }

    // get all companies
        public static List<Company> readCompanies() {
            try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
                return session.createQuery("FROM Company", Company.class).getResultList();
            }
        }

    // delete company
    public static void deleteCompany(Company company){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
        }
    }

    // sort company by name and pure profit
    public static void sortCompanyNameAndPureProfit(){
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            session.createQuery("FROM Company ORDER by companyName,companyPureProfit",
                            Company.class).getResultList();
        }
    }


    // write in file from db
    public static void writeCompany(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            fw.write("All companies: " + readCompanies() + "\n" + System.lineSeparator());
            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // read from file
    public static void readCompany(String fileName) {
        try (FileReader fr = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
