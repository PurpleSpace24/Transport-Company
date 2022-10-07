package entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Tables;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import java.util.*;

@Entity
@Table(name="driver")
public class Driver implements Comparable<Driver> {

    @Id
    @Column(name = "iddriver", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="driverName", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="driverQualification", nullable = false)
    private Qualification qualification;

    @Enumerated(EnumType.STRING)
    @Column(name="driverVehicletype", nullable = false)
    private VehicleType vehicleType;

    @Column(name="driverSalary", nullable = false)
    private double salary;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idcompany")
    private List<Company> company;

    @Transient
    private Vehicle vehicle;

    @Transient
    private double price;

    public Driver() {
        company = new ArrayList<>();
    }

    public Driver(String name, Qualification qualification) {
        this.name = name;
        this.qualification = qualification;

        company = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Company> getCompanyList() {
        return company;
    }

    public void setCompany(List<Company> companyList) {
        this.company = companyList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", qualification=" + qualification +
                ", vehicleType=" + vehicleType +
                ", salary= " + price +
                '}' + "\n";
    }

    @Override
    public int compareTo(Driver driver) {
        return driver.getQualification().compareTo(driver.getQualification());
    }

}
