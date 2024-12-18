package com.ef.alatrista.torres.jose.abdon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer carId;
    public String make;
    public String model;
    public Integer year ;
    public String vin ;
    public String licensePlate;
    public String ownerName;
    public String ownerContact;
    public Date purchaseDate;
    public Integer mileage;
    public String engineType;
    public String color;
    public String insuranceCompany ;
    public String insurancePolicyNumber;
    public Date registrationExpirationDate ;
    public Date serviceDueDate;

}
