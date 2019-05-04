package com.epam.MVCspring.services;

import com.epam.MVCspring.beans.Car;
import com.epam.MVCspring.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> getCabs() {
        return  carDao.findAll();
    }

    @Override
    public List<Car> getPageCabs(int size, int page, int sort) {
        return  carDao.pageCabs( size, page, sort);
    }


    @Override
    public Car findFirstByYear(int manufactureYear) {
        List<Car> result = carDao.findByYear(manufactureYear);
        if(result.size() > 0) {
            return result.get(0);
        }
        return new Car();
    }

    @Override
    public List<Car> findAllByYear(int manufactureYear) {
        List<Car> result = carDao.findByYear(manufactureYear);
        return result;
    }

    @Override
    public void deleteCarById(int id) {
        carDao.deleteCarById(id);
    }

    @Override
    public Car getCarById(int id) {
       return carDao.getCarById(id);
    }

    @Override
    public void addCar(Car car) throws Exception {
        if ( car.getBrend() == null || car.getDate_of_manufacture()==null) {
            throw new Exception("Не заполнен бренд или год производства");
        } else {
            carDao.addCar(car);
        }
    }

    @Override
    public void updateCar(Car car) throws Exception {
        carDao.update(car);
    }


}
