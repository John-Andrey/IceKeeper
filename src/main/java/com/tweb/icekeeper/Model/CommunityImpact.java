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
    public  CommunityImpact(){}
    public CommunityImpact(int totalActions, double totalImpact, String message) {
        this.totalActions = totalActions;
        this.totalImpact = totalImpact;
        this.message = message;
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

    public int getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(int totalActions) {
        this.totalActions = totalActions;
    }
}
