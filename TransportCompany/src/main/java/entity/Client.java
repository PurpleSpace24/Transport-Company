package entity;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idclient", nullable = false)
    private long id;

    @Column(name="clientName", nullable = false)
    private String name;

    @Column(name="clientPaid", nullable = false)
    private boolean isPaid;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "idcompany")
    private List<Company> company;

    public Client() {
        company = new ArrayList<>();
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, boolean isPaid) {
        this.name = name;
        this.isPaid = isPaid;

        company = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", isPaid=" + isPaid +
                '}' + "\n";
    }
}
