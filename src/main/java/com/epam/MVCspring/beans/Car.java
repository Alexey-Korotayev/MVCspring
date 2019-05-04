package com.epam.MVCspring.beans;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "java_car")
public class Car {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "brend")
    private String brend;

    @Column(name = "decription")
    private String decription;

    @Column(name = "date_of_manufacture")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_manufacture;

    @Column(name = "ip_user")
    private Integer ip_user;

    public Car() {
    }


    public Car(Integer id, String brend, String decription, Date date_of_manufacture, Integer ip_user) {
        this.id = id;
        this.brend = brend;
        this.decription = decription;
        this.date_of_manufacture = date_of_manufacture;
        this.ip_user = ip_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Date getDate_of_manufacture() {
        return date_of_manufacture;
    }

    public void setDate_of_manufacture(Date date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public Integer getIp_user() {
        return ip_user;
    }

    public void setIp_user(Integer ip_user) {
        this.ip_user = ip_user;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brend='" + brend + '\'' +
                ", decription='" + decription + '\'' +
                ", date_of_manufacture=" + date_of_manufacture +
                ", ip_user='" + ip_user + '\'' +
                '}';
    }
}
