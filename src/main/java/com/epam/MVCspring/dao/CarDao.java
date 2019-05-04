package com.epam.MVCspring.dao;

import com.epam.MVCspring.beans.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    List<Car> pageCabs(int size, int page, int sort);

    List<Car> findByYear(int year);

    void addCar(Car car);

    Car getCarById(int id);

    void deleteCarById(int id);

    void update(Car car);

}
