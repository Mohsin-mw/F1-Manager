package com.f1manager.demo.Formula1;

import com.f1manager.demo.Formula1.Aileron.Ailerons;
import com.f1manager.demo.Formula1.Moteurs.Moteurs;
import com.f1manager.demo.Formula1.wheels.Wheels;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class F1 {
    @Id
    @Column(insertable = false, updatable = false)
    private int id;
    private double poidsF1;
    private double vitesseMax;
    private double zeroTo100;
    private Level maniabilty;

    private Double coef;

    @Embedded
    private Wheels wheels;

    @Embedded
    private Moteurs moteur;

    @Embedded
    private Ailerons ailerons;

    public F1(){}

    public F1(double poidsF1, double vitesseMax, double zeroTo100, Level maniabilty, Wheels wheels, Moteurs moteur, Double coef) {
        this.poidsF1 = poidsF1;
        this.vitesseMax = vitesseMax;
        this.zeroTo100 = zeroTo100;
        this.maniabilty = maniabilty;
        this.wheels = wheels;
        this.moteur = moteur;
        this.coef = coef;
    }

}
