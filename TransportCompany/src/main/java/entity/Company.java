package entity;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="company")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcompany", nullable = false)
    private long id;

    @Column(name="companyName", nullable = false)
    private String name;

    @Column(name="companyBalance", nullable = false)
    private double balance;

    @Column(name="companyPureProfit", nullable = false)
    private double pureProfit;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="company_has_driver", joinColumns = @JoinColumn(name = "idcompany"),
            inverseJoinColumns =@JoinColumn(name = "iddriver"))
    private List<Driver> driversList;

    @OneToMany(cascade = {CascadeType.ALL})  // cascade = {CascadeType.ALL}
    @JoinTable(name="company_has_vehicle", joinColumns = @JoinColumn(name = "idcompany"),
            inverseJoinColumns =@JoinColumn(name = "idvehicle"))
    private List<Vehicle> vehicleList;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="company_has_clients", joinColumns = @JoinColumn(name = "idcompany"),
            inverseJoinColumns =@JoinColumn(name = "idclient"))
    private List<Client> clientList;


    // ignoring fields shouldn't be persisted
    @Transient
    private Driver driver;
    @Transient
    private Vehicle vehicle;
    @Transient
    private double Salary;
    @Transient
    private String isDone;
    @Transient
    private int countCompletedCourses;

    public Company(String name) {
        this.name = name;
        driversList = new ArrayList<>();
        vehicleList = new ArrayList<>();
        clientList = new ArrayList<>();
    }

    public Company() {
        driversList = new ArrayList<>();
        vehicleList = new ArrayList<>();
        clientList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String isDone() {
        return isDone;
    }

    public void setDone(String done) {
        isDone = done;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCountCompletedCourses() {
        return countCompletedCourses;
    }

    public void setCountCompletedCourses(int countCompletedCourses) {
        this.countCompletedCourses = countCompletedCourses;
    }

   public void hireDriver(Driver driver){
        driversList.add(driver);
    }

    public void companyTakeVehicle(Vehicle veh){
        vehicleList.add(veh);
    }

    public void addClient(Client cl){
        clientList.add(cl);
    }

    public void setSalary(Driver driver,double salary){
        driver.setPrice(salary);
        salary += driver.getSalary();  // full salary from companies where driver works
        driver.setSalary(salary);      //
    }

    public double getSalary() {
        return Salary;
    }

    public double getPureProfit() {
        return pureProfit;
    }

    public void setPureProfit(double pureProfit) {
        this.pureProfit = pureProfit;
    }


    public void DriverTakesVehicle(){
        for(Driver dr : driversList){
            for(Vehicle veh : vehicleList){
                      if(dr.getVehicleType().equals(veh.getVehicleType())){
                          if(dr.getVehicle() != null){
                              driversList.stream().skip(1);
                          }else{
                              veh.setDriver(dr);
                              dr.setVehicle(veh);
                      }
                  }
                }
        }
    }

    public void isCompletedTransportation(boolean isDone, Vehicle vehicle){
        vehicle.setCompletedCourse(isDone);
    }


    public double TotalWon(){
        pureProfit += balance;

        for(Vehicle vehicle : vehicleList){       // count every totalPrice from vehicle with completed course
            if(vehicle.isCompletedCourse()) {
                pureProfit += vehicle.getTotal();
                countCompletedCourses++;
            }
        }

        for(Driver driver : driversList){
            pureProfit -= driver.getPrice();       // minus every salary from driver
        }
        return pureProfit;
    }

    // write in file
    public void write(String fileName){
        try(FileWriter fw = new FileWriter(fileName)){
            double all = 0;
            fw.write("Company: \n" + getName() + "\nBalance: " + getBalance() + "\nDrivers: \n" + driversList +
                    "\nVehicles: \n" + vehicleList + "\nClients: \n" + clientList + System.lineSeparator());
            fw.write("\nNumber of completed courses: " + getCountCompletedCourses());
            fw.write("\nPure profit : " + getPureProfit());

            fw.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // read from file
    public void read(String fileName){
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

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}' + "\n";
    }
}
