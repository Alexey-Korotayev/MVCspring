package com.epam.MVCspring.controllers;

import com.epam.MVCspring.beans.Car;
import com.epam.MVCspring.services.CarService;
import com.epam.MVCspring.services.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/mvc")
public class CarController {

    @Autowired
    private CarService carService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Work with cars");
        // Имя представления
        return "index";
    }

    @GetMapping("/carAdd")
    public String createCarPage() {
        return "carAdd";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car) throws Exception {
        carService.addCar(car);
        return "redirect:/mvc/cabList";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") int id) {
        carService.deleteCarById(id);
        return "redirect:/mvc/cabList";
    }

    @RequestMapping(value="edit", method = RequestMethod.POST)
    public String editCar(@ModelAttribute("car") Car car) {
        try {
            carService.updateCar(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/mvc/cabList";
    }

    @GetMapping("/edit/{id}")
    public String getCar(@PathVariable("id") int id,  Model model) {
        model.addAttribute( "car", carService.getCarById(id) ) ;
        return "editCar";
    }

    @RequestMapping(value = "/cabList", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cars", carService.getCabs());
        modelAndView.setViewName("cabList");
        return modelAndView;
    }

    @RequestMapping(value = "/pageList", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView extendedLeave(@RequestParam(required = false) String page,
                                                 @RequestParam(required = false) String sort) throws Exception {
        int sizePage = 5;
        int numberPage;
        int sortPage;
        if (page == null) {
            numberPage = 1;
        } else {
            numberPage = Integer.parseInt(page);
        }
        if (sort == null) {
            sortPage = 0;
        } else {
            sortPage = Integer.parseInt(sort);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cars", carService.getPageCabs(sizePage, numberPage, sortPage));
        modelAndView.addObject("page", page);
        modelAndView.addObject("sort", sort);
        modelAndView.setViewName("pageList");
        return modelAndView;
    }


    @RequestMapping(value = "/carListYear/{manufactureYear}", method = RequestMethod.GET)
    public ModelAndView getAll(@PathVariable("manufactureYear") int manufactureYear, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cars", carService.findAllByYear(manufactureYear));
        modelAndView.setViewName("carListYear");
        return modelAndView;

    }

    @GetMapping(value = "/cab/{manufactureYear}")
    public String get(@PathVariable("manufactureYear") int manufactureYear, Model model) {
        Car car = carService.findFirstByYear(manufactureYear);
        model.addAttribute("car", car);
        return "cab";
    }

/*
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(Model model){
        return "login";
    }
*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }

    /*
    @GetMapping("/deleteCar/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @RequestMapping(method=DELETE)
*/
}
