package com.ef.alatrista.torres.jose.abdon.api;

import com.ef.alatrista.torres.jose.abdon.dto.CarDTO;
import com.ef.alatrista.torres.jose.abdon.dto.CarDetailDTO;
import com.ef.alatrista.torres.jose.abdon.response.*;
import com.ef.alatrista.torres.jose.abdon.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maintenance-Api")
public class MaintenanceApi {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/allCar")
    public FindCarResponse finCar(){
        try {
            List<CarDTO> cars = maintenanceService.getAllCars();
            return new FindCarResponse("01","",cars);

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99","Service not found",null);
        }
    }

    @GetMapping("/Car")
    public FindCarResponse finCarId(@RequestParam(value ="carId",defaultValue = "0") String carId){
        try {
            if( Integer.parseInt(carId) > 0){
                Optional<CarDTO> optional = maintenanceService.getCarDTOById(Integer.parseInt(carId));
                if(optional.isPresent()){
                    CarDTO carDTO = optional.get();
                    return new FindCarResponse("01", "", List.of(carDTO));
                }else {
                    return new FindCarResponse("99", "Car not found",null);
                }
            }else{
                return new FindCarResponse("02", "Car not Found", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99","Service not found",null);
        }
    }

    @GetMapping("/details")
    public FindDetailsCarResponse detailsCarId(@RequestParam(value ="carId",defaultValue = "0") String carId){
        try {
            if( Integer.parseInt(carId) > 0){
                Optional<CarDetailDTO> optional = maintenanceService.getCarDetailById(Integer.parseInt(carId));
                if(optional.isPresent()){
                    CarDetailDTO carDetailDTO = optional.get();
                    return new FindDetailsCarResponse("01", "", carDetailDTO);
                }else {
                    return new FindDetailsCarResponse("99", "Car not found",null);
                }
            }else{
                return new FindDetailsCarResponse("02", "Car not Found", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindDetailsCarResponse("99","Service not found",null);
        }
    }

    @PostMapping("/update")
    public updateCarResponse updateCar(@RequestBody CarDetailDTO carDetailDTO){
        try {

                if(maintenanceService.updateCar(carDetailDTO)){
                    return new updateCarResponse("01", "");
                }else {
                    return new updateCarResponse("99", "Car not found");
                }

        }catch (Exception e) {
            e.printStackTrace();
            return new updateCarResponse("01", "Car not found");
        }
    }

    @PostMapping("/create")
    public createCarResponse createCar(@RequestBody CarDetailDTO carDetailDTO){
        try {

            if(maintenanceService.addCar(carDetailDTO)){
                return new createCarResponse("01", "");
            }else {
                return new createCarResponse("99", "Car not found");
            }

        }catch (Exception e) {
            e.printStackTrace();
            return new createCarResponse("99", "Car not found");
        }
    }

    @PostMapping("/delete")
    public deleteCarResponse deleteCar(@RequestParam(value = "carId",defaultValue = "0'") String carId){
        try {
            if( Integer.parseInt(carId) > 0){
                maintenanceService.deleteCarById(Integer.parseInt(carId));
                return new deleteCarResponse("01", "");
            }else{
                return new deleteCarResponse("02", "Car not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new deleteCarResponse("99","Service not found");
        }
    }

}
