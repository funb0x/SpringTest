package com.funbox.mvc;

import com.funbox.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Анна on 26.02.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private Car car;

    @RequestMapping(value="/test", method=GET)
    public @ResponseBody String home() {
        car.move();
        return "home";
    }

}
