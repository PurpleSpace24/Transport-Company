import configuration.SessionFactoryUtil;

import dao.*;
import dao.CompanyDAO;
import dao.DriverDAO;
import dao.VehicleDAO;

import entity.*;
import entity.Company;
import entity.Driver;
import entity.Vehicle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main (String[] arg){

        //-------Company START-------------
        Company company = new Company();
        company.setName("DHL");
        company.setBalance(3000);

        Company company1 = new Company();
        company1.setName("Uber");
        company1.setBalance(5000);

        Company company2 = new Company();
        company2.setName("Petrol");
        company2.setBalance(5000);

        Company company3 = new Company();
        company3.setName("Army");
        company3.setBalance(5000);

        List<Company> companyList = Arrays.asList(company,company1,company2);

        // save company
        CompanyDAO.saveCompany(company);
        CompanyDAO.saveCompany(company1);
        CompanyDAO.saveCompany(company2);
        CompanyDAO.saveCompany(company3);

        // rename company
        company1.setName("World Travelling");
        CompanyDAO.saveOrUpdateCompany(company1);

        // delete company
        CompanyDAO.deleteCompany(company3);
        //--------------END Company-------------------


        //--------------Driver START-------------------------
        Driver driver = new Driver();
        driver.setName("Ivan");
        driver.setQualification(Qualification.SpecialGoods);
        driver.setVehicleType(VehicleType.Truck);

        Driver driver1 = new Driver();
        driver1.setName("Petar");
        driver1.setQualification(Qualification.Flammable);
        driver1.setVehicleType(VehicleType.TankTruck);

        Driver driver2 = new Driver();
        driver2.setName("Angel");
        driver2.setQualification(Qualification.TransportPeople);
        driver2.setVehicleType(VehicleType.Bus);

        Driver driver3 = new Driver();
        driver3.setName("Martin");
        driver3.setQualification(Qualification.TransportPeople);
        driver3.setVehicleType(VehicleType.Bus);

        Driver driver4 = new Driver();
        driver4.setName("Vanesa");
        driver4.setQualification(Qualification.Flammable);
        driver4.setVehicleType(VehicleType.TankTruck);

        Driver driver5 = new Driver();
        driver5.setName("Mark");
        driver5.setQualification(Qualification.SpecialGoods);
        driver5.setVehicleType(VehicleType.Truck);

        DriverDAO.saveDriver(driver);
        DriverDAO.saveDriver(driver1);
        DriverDAO.saveDriver(driver2);
        DriverDAO.saveDriver(driver3);
        DriverDAO.saveDriver(driver4);
        DriverDAO.saveDriver(driver5);

        //---------------END Driver----------------------


        //--------------Vehicle START-------------------
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.Bus);
        vehicle.setPriceKm(1.02);
        vehicle.setKm(550);
        vehicle.setDateDeparture(LocalDate.of(2021,12,30));
        vehicle.setDateArrival(LocalDate.of(2021,12,30));
        vehicle.setStartPoint("Sofia");
        vehicle.setEndPoint("Burgas");
        vehicle.totalPrice();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType(VehicleType.TankTruck);
        vehicle1.setPriceKm(2.01);
        vehicle1.setKm(2342);
        vehicle1.setTotalWeight(12500);
        vehicle1.setDateDeparture(LocalDate.of(2022,2,1));
        vehicle1.setDateArrival(LocalDate.of(2022,2,5));
        vehicle1.setStartPoint("Moscow");
        vehicle1.setEndPoint("Sarajevo");
        vehicle1.totalPrice();

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType(VehicleType.Truck);
        vehicle2.setPriceKm(0.67);
        vehicle2.setKm(823);
        vehicle2.setTotalWeight(15850);
        vehicle2.setDateDeparture(LocalDate.of(2022,1,2));
        vehicle2.setDateArrival(LocalDate.of(2022,1,3));
        vehicle2.setStartPoint("Varna");
        vehicle2.setEndPoint("Podgorica");
        vehicle2.totalPrice();

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleType(VehicleType.Truck);
        vehicle3.setPriceKm(0.98);
        vehicle3.setKm(340);
        vehicle3.setTotalWeight(20000);
        vehicle3.setDateDeparture(LocalDate.of(2022,1,3));
        vehicle3.setDateArrival(LocalDate.of(2022,1,3));
        vehicle3.setStartPoint("Plovdiv");
        vehicle3.setEndPoint("Athens");
        vehicle3.totalPrice();

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setVehicleType(VehicleType.TankTruck);
        vehicle4.setPriceKm(1.52);
        vehicle4.setKm(1164);
        vehicle4.setTotalWeight(18300);
        vehicle4.setDateDeparture(LocalDate.of(2022,1,9));
        vehicle4.setDateArrival(LocalDate.of(2022,1,11));
        vehicle4.setStartPoint("Tirana");
        vehicle4.setEndPoint("Budapest");
        vehicle4.totalPrice();

        Vehicle vehicle5 = new Vehicle();
        vehicle5.setVehicleType(VehicleType.Bus);
        vehicle5.setPriceKm(3.01);
        vehicle5.setKm(1476);
        vehicle5.setDateDeparture(LocalDate.of(2022,1,10));
        vehicle5.setDateArrival(LocalDate.of(2022,1,12));
        vehicle5.setStartPoint("Vienna");
        vehicle5.setEndPoint("Burgas");
        vehicle5.totalPrice();

        VehicleDAO.saveVehicle(vehicle);
        VehicleDAO.saveVehicle(vehicle1);
        VehicleDAO.saveVehicle(vehicle2);
        VehicleDAO.saveVehicle(vehicle3);
        VehicleDAO.saveVehicle(vehicle4);
        VehicleDAO.saveVehicle(vehicle5);
        //---------------END Vehicle------------------------


        //------------Client START------------------
        Client client = new Client();
        client.setName("Ivan");
        client.setPaid(false);

        Client client1 = new Client();
        client1.setName("Moan");
        client1.setPaid(true);

        Client client2 = new Client();
        client2.setName("Ivana");
        client2.setPaid(true);

        Client client3 = new Client();
        client3.setName("Preslava");
        client3.setPaid(false);

        Client client4 = new Client();
        client4.setName("Anelia");
        client4.setPaid(false);

        ClientDAO.saveClient(client);
        ClientDAO.saveClient(client1);
        ClientDAO.saveClient(client2);
        ClientDAO.saveClient(client3);
        ClientDAO.saveClient(client4);
        //---------END Client-----------------

        // add driver
        companyList.get(0).hireDriver(driver);
        companyList.get(0).hireDriver(driver1);
        companyList.get(0).hireDriver(driver2);
        companyList.get(0).setSalary(driver,869);
        companyList.get(0).setSalary(driver1,810);
        companyList.get(0).setSalary(driver2,1010);
        driver.setCompany(companyList);
        driver1.setCompany(companyList);
        driver2.setCompany(companyList);

        companyList.get(1).hireDriver(driver);
        companyList.get(1).hireDriver(driver1);
        companyList.get(1).hireDriver(driver2);
        companyList.get(1).hireDriver(driver3);
        companyList.get(1).hireDriver(driver4);
        companyList.get(1).hireDriver(driver5);
        companyList.get(1).setSalary(driver2,1010);
        companyList.get(1).setSalary(driver1,810);
        companyList.get(1).setSalary(driver3,1200);
        companyList.get(1).setSalary(driver5,999);
        companyList.get(1).setSalary(driver4,890);
        companyList.get(1).setSalary(driver,869);
        driver3.setCompany(companyList);
        driver.setCompany(companyList);
        driver1.setCompany(companyList);
        driver2.setCompany(companyList);
        driver5.setCompany(companyList);
        driver4.setCompany(companyList);

        companyList.get(2).hireDriver(driver4);
        companyList.get(2).hireDriver(driver1);
        companyList.get(2).setSalary(driver4,1200);
        companyList.get(2).setSalary(driver1,810);
        driver4.setCompany(companyList);
        driver1.setCompany(companyList);

        // add vehicle
        companyList.get(0).companyTakeVehicle(vehicle);
        companyList.get(0).companyTakeVehicle(vehicle1);
        companyList.get(0).companyTakeVehicle(vehicle2);
        companyList.get(0).isCompletedTransportation(true,vehicle);
        companyList.get(0).isCompletedTransportation(false,vehicle1);
        companyList.get(0).isCompletedTransportation(true,vehicle2);
        vehicle.setCompany(companyList.get(0));
        vehicle1.setCompany(companyList.get(0));
        vehicle2.setCompany(companyList.get(0));

        companyList.get(1).companyTakeVehicle(vehicle3);
        companyList.get(1).companyTakeVehicle(vehicle5);
        companyList.get(1).isCompletedTransportation(true,vehicle3);
        companyList.get(1).isCompletedTransportation(false,vehicle5);
        vehicle5.setCompany(companyList.get(1));
        vehicle3.setCompany(companyList.get(1));

        companyList.get(2).companyTakeVehicle(vehicle4);
        companyList.get(2).isCompletedTransportation(true,vehicle4);
        vehicle4.setCompany(companyList.get(2));


        // add client
        companyList.get(0).addClient(client);
        companyList.get(0).addClient(client1);
        companyList.get(0).addClient(client2);
        companyList.get(0).addClient(client3);
        client.setCompany(companyList);
        client1.setCompany(companyList);
        client2.setCompany(companyList);
        client3.setCompany(companyList);

        companyList.get(1).addClient(client4);
        companyList.get(1).addClient(client2);
        companyList.get(1).addClient(client1);
        client4.setCompany(companyList);
        client2.setCompany(companyList);
        client1.setCompany(companyList);

        companyList.get(2).addClient(client1);
        companyList.get(2).addClient(client3);
        client1.setCompany(companyList);
        client3.setCompany(companyList);

        // driver takes vehicle
        companyList.get(0).DriverTakesVehicle();
        companyList.get(1).DriverTakesVehicle();
        companyList.get(2).DriverTakesVehicle();

        companyList.get(0).TotalWon();
        companyList.get(1).TotalWon();
        companyList.get(2).TotalWon();

        // update in database
        DriverDAO.saveOrUpdateDriver(driver);
        DriverDAO.saveOrUpdateDriver(driver1);
        DriverDAO.saveOrUpdateDriver(driver2);
        DriverDAO.saveOrUpdateDriver(driver3);
        DriverDAO.saveOrUpdateDriver(driver4);
        DriverDAO.saveOrUpdateDriver(driver5);

        VehicleDAO.saveOrUpdateVehicle(vehicle);
        VehicleDAO.saveOrUpdateVehicle(vehicle1);
        VehicleDAO.saveOrUpdateVehicle(vehicle2);
        VehicleDAO.saveOrUpdateVehicle(vehicle3);
        VehicleDAO.saveOrUpdateVehicle(vehicle4);
        VehicleDAO.saveOrUpdateVehicle(vehicle5);

        ClientDAO.saveOrUpdateClient(client);
        ClientDAO.saveOrUpdateClient(client1);
        ClientDAO.saveOrUpdateClient(client2);
        ClientDAO.saveOrUpdateClient(client3);
        ClientDAO.saveOrUpdateClient(client4);

        companyList.get(0).write("company.txt");
        companyList.get(1).write("company1.txt");
        companyList.get(2).write("company2.txt");

        System.out.println("\n -------------------------Driver sort --------------------");
        DriverDAO.sortDriverByQualificationAndSalary();
        System.out.println("\n -------------------------Vehicle sort --------------------");
        VehicleDAO.sortVehicleByKm();
        System.out.println("\n -------------------------Company sort --------------------");
        CompanyDAO.sortCompanyNameAndPureProfit();

    }
}

