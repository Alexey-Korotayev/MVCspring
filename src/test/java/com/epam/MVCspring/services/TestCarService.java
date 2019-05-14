package com.epam.MVCspring.services;

import com.epam.MVCspring.beans.Car;
import com.epam.MVCspring.dao.CarDao;
import com.epam.MVCspring.dao.CarDaoImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class TestCarService {

    @Mock
    CarDao carDao;
    @InjectMocks
    CarDaoImpl carDaoImpl = new CarDaoImpl();

    @Mock
    CarService carService;
    @InjectMocks
    CarServiceImpl carServiceImpl = new CarServiceImpl();

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void createValidCar() throws Exception {
        Car newCar = new Car();
        newCar.setId(100);
        newCar.setBrend("FFFFFF");
        Date dt = new java.sql.Date(System.currentTimeMillis());
        newCar.setDate_of_manufacture(dt);
        newCar.setDecription("dddddddddddddddd");
        newCar.setIp_user(1111);

        try {
        carServiceImpl.addCar(newCar);
        } catch (SQLException se) {
            throw se;
        }
    }

    @Test
    public void createNotValidCar() throws Exception {
        Car newCar = new Car();
        newCar.setId(100);
        Date dt = new java.sql.Date(System.currentTimeMillis());
        newCar.setDate_of_manufacture(dt);
        newCar.setDecription("dddddddddddddddd");
        newCar.setIp_user(1111);

        try {
            carServiceImpl.addCar(newCar);
        } catch (SQLException se) {
            throw se;
        }
    }

}
