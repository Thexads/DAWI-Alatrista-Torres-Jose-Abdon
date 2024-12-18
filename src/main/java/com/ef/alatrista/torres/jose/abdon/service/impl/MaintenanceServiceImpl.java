package com.ef.alatrista.torres.jose.abdon.service.impl;

import com.ef.alatrista.torres.jose.abdon.dto.CarDTO;
import com.ef.alatrista.torres.jose.abdon.dto.CarDetailDTO;
import com.ef.alatrista.torres.jose.abdon.entity.Car;
import com.ef.alatrista.torres.jose.abdon.repository.CarRepository;
import com.ef.alatrista.torres.jose.abdon.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDTO> getAllCars() throws Exception {

        List<CarDTO> cars = new ArrayList<CarDTO>();
        Iterable<Car> iterable =  carRepository.findAll();
        iterable.forEach(car -> {
            CarDTO carDTO = new CarDTO(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getVin(),
                    car.getColor());
            cars.add(carDTO);
        });

        return cars;
    }

    @Override
    public Optional<CarDTO> getCarDTOById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDTO(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getColor()
        ));
    }

    @Override
    public Optional<CarDetailDTO> getCarDetailById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDTO(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber()
        ));
    }

    @Override
    public Boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map( car -> {
                carRepository.delete(car);
                return true;
        }).orElse(false);

    }

    @Override
    public Boolean addCar(CarDetailDTO carDetailDTO) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDTO.carId());
        if (optional.isPresent()) {
            return false;
        }else{
            Car car = new Car();
            car.setMake(carDetailDTO.make());
            car.setModel(carDetailDTO.model());
            car.setYear(carDetailDTO.year());
            car.setVin(carDetailDTO.vin());
            car.setLicensePlate(carDetailDTO.licensePlate());
            car.setOwnerName(carDetailDTO.ownerName());
            car.setOwnerContact(carDetailDTO.ownerContact());
            car.setMileage(carDetailDTO.mileage());
            car.setEngineType(carDetailDTO.engineType());
            car.setColor(carDetailDTO.color());
            car.setInsuranceCompany(carDetailDTO.insuranceCompany());
            car.setInsurancePolicyNumber(carDetailDTO.insurancePolicyNumber());
            carRepository.save(car);
            return true;
        }


    }

    @Override
    public Boolean updateCar(CarDetailDTO carDetailDTO) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDTO.carId());
        return optional.map(car ->{
                car.setMake(carDetailDTO.make());
                car.setModel(carDetailDTO.model());
                car.setYear(carDetailDTO.year());
                car.setVin(carDetailDTO.vin());
                car.setLicensePlate(carDetailDTO.licensePlate());
                car.setOwnerName(carDetailDTO.ownerName());
                car.setOwnerContact(carDetailDTO.ownerContact());
                car.setMileage(carDetailDTO.mileage());
                car.setEngineType(carDetailDTO.engineType());
                car.setColor(carDetailDTO.color());
                car.setInsuranceCompany(carDetailDTO.insuranceCompany());
                car.setInsurancePolicyNumber(carDetailDTO.insurancePolicyNumber());
                carRepository.save(car);
                return true;
        }).orElse(false);
    }
}
