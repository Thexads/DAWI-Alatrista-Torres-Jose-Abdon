package com.ef.alatrista.torres.jose.abdon.dto;

import java.util.Date;

public record CarDetailDTO(Integer carId,
                           String make,
                           String model,
                           Integer year,
                           String vin,
                           String licensePlate,
                           String ownerName,
                           String ownerContact,
                           Date purchaseDate,
                           Integer mileage,
                           String engineType,
                           String color,
                           String insuranceCompany,
                           String insurancePolicyNumber) {
}
