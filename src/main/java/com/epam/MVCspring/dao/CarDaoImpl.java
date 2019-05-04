package com.epam.MVCspring.dao;

import com.epam.MVCspring.beans.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.util.List;

@Component
public class CarDaoImpl implements CarDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

//    private SimpleJdbcInsert insertTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {  // <---- Inject DataSource through setter
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    //  public Car(Integer id, String brend, String decription, Date date_of_manufacture, String ip_user) {
    private static final RowMapper cabRowMapper = (rs, rowNumber) -> new Car(
            rs.getInt("id"),
            rs.getString("brend"),
            rs.getString("decription"),
            rs.getDate("date_of_manufacture"),
            rs.getInt("ip_user")
    );

    @Override
    public List<Car> findAll() {
        return jdbcTemplate.query("SELECT * FROM java_car ", cabRowMapper);
    }


    @Override
    public List<Car> pageCabs(int size, int page, int sort) {
        String sql = "SELECT * FROM java_car ";
        if ( sort > 0 ) {
            sql = sql + " ORDER BY "+sort;
        }
        int ofset = (page-1)*size;
        int lim = size;
        sql = sql + " OFFSET "+ofset+" LIMIT "+lim;
        List<Car> result = jdbcTemplate.query(sql, cabRowMapper);
        return result;
    };


    @Override
    public List<Car> findByYear(int year) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("manufactureYear", year);
        List<Car> result = namedParameterJdbcTemplate.query(
                "SELECT * FROM java_car WHERE Extract(YEAR from date_of_manufacture ) = :manufactureYear", namedParameters,
                cabRowMapper);
        return result;
    }

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO java_car (id, brend, decription, date_of_manufacture, ip_user) VALUES ((select max(id)+1 from java_car), ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getBrend(), car.getDecription(), car.getDate_of_manufacture(), car.getIp_user());
    }

    @Override
    public Car getCarById(int id) {
        String sql = "SELECT * FROM java_car WHERE id=?";
        return (Car)jdbcTemplate.queryForObject(sql, cabRowMapper, id);
    }

    @Override
    public void deleteCarById(int id) {
        String sql = "DELETE FROM java_car WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Car car) {
        String sql = "UPDATE java_car SET brend = ?, decription = ?, date_of_manufacture = ?, ip_user =? WHERE id=?";
        jdbcTemplate.update(sql, car.getBrend(), car.getDecription(), car.getDate_of_manufacture(), car.getIp_user(), car.getId());
    }
}
