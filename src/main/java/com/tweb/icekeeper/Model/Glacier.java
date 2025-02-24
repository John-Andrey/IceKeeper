package com.tweb.icekeeper.Model;


import jakarta.persistence.*;

import jakarta.persistence.*; // Use this import for Jakarta EE (Spring Boot 3.x and later)

@Entity
@Table(name = "glaciers")
public class Glacier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double temperature;
    @Column(nullable = false)
    private String condition;
    @Column(nullable = false)
    private String location;

    // Default constructor
    public Glacier() {}
    public Glacier(String name, double temperature,String condition, String location) {
        this.name = name;
        this.temperature=temperature;
        this.condition = condition;
        this.location = location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

