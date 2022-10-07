package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="vehicle")
public class Vehicle implements Comparable<Vehicle>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvehicle", nullable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name="vehicletype", nullable = false)
    private VehicleType vehicleType;
    @Column(name = "totalPrice")
    private double total;
    @Column(name="priceKm", nullable = false)
    private double priceKm;
    @Column(name="km", nullable = false)
    private double km;

    @Column(name="startPoint", nullable = false)
    private String startPoint;
    @Column(name="endPoint", nullable = false)
    private String endPoint;
    @Column(name="dateDeparture", nullable = false)
    private LocalDate dateDeparture;
    @Column(name="dateArrival", nullable = false)
    private LocalDate dateArrival;

    @Column(name="completedCourse",nullable = false)
    private boolean completedCourse;
    @Column(name="totalWeight", nullable = false)
    private double totalWeight;

    @Transient
    private Company company;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "iddriver")
    private Driver driver;

    public Vehicle(VehicleType vehicleType, double priceKm, String startPoint, String endPoint, LocalDate dateDeparture, LocalDate dateArrival) {
        this.vehicleType = vehicleType;
        this.priceKm = priceKm;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
        this.completedCourse = false;
    }

    public Vehicle() {
        this.completedCourse = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {return vehicleType;}

    public Vehicle setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return null;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getPriceKm() {
        return priceKm;
    }

    public void setPriceKm(double priceKm) {
        this.priceKm = priceKm;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDate getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(LocalDate dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public LocalDate getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(LocalDate dateArrival) {
        this.dateArrival = dateArrival;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void totalPrice(){
        total = Math.ceil(priceKm*km);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(boolean completedCourse) {
        this.completedCourse = completedCourse;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", priceKm=" + priceKm +
                ", km=" + km +
                ", total=" + total +
                " , totalWeight=" + totalWeight +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", dateDeparture=" + dateDeparture +
                ", dateArrival=" + dateArrival +
                " , driver=" + driver.getName() +
                " , isDone=" + completedCourse +
                '}' + "\n";
    }

    @Override
    public int compareTo(Vehicle vehicle) {
        return vehicle.getVehicleType().compareTo(vehicle.getVehicleType());
    }

}
