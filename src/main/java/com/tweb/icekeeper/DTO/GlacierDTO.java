package com.tweb.icekeeper.DTO;

public class GlacierDTO {
    // Identificatore unico del ghiacciaio
    private Long id;
    // Nome del ghiacciaio
    private String name;
    // Temperatura attuale del ghiacciaio
    private double temperature;
    // Condizione del ghiacciaio (es. "sano", "in pericolo")
    private String location;
    private String condition;

    public GlacierDTO(Long id, String name, double temperature, String condition, String location) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.location = location;
        this.condition=condition;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    @Override
    public String toString() {
        return "GlacierDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", temperature=" + temperature +
                ", condition='" + location + '\'' +
                '}';
    }
}
