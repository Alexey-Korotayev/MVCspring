package com.epam.MVCspring.services;

import com.epam.MVCspring.beans.Car;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

public interface CarService {

//    void setDataSource(DataSource dataSource);

    List<Car> getCabs();

    List<Car> getPageCabs(int size, int page, int sort);

    Car findFirstByYear(int manufactureYear);

    List<Car> findAllByYear(int manufactureYear);

    void deleteCarById(int id);

    Car getCarById(int id);

    void addCar(Car car) throws Exception;

    void updateCar(Car car) throws Exception;

}
