package com.tweb.icekeeper.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "community_impacts")
public class CommunityImpact {
    // Numero totale di azioni registrate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int totalActions;
    // Impatto totale stimato (es. riduzione CO2)
    @Column
    private double totalImpact;
    // Messaggio motivazionale o informativoà
    @Column
    private String message;
    @ManyToOne
    @JoinColumn(name ="project_id")
    private Project project;
    public  CommunityImpact(){}
    public CommunityImpact(int totalActions, double totalImpact, String message , Project project) {
        this.totalActions = totalActions;
        this.totalImpact = totalImpact;
        this.message = message;
        this.project= project;
    }

    public double getTotalImpact() {
        return totalImpact;
    }

    public void setTotalImpact(double totalImpact) {
        this.totalImpact = totalImpact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(int totalActions) {
        this.totalActions = totalActions;
    }
}
