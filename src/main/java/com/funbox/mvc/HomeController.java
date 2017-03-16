package com.funbox.mvc;

import com.funbox.car.Car;
import com.funbox.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Анна on 26.02.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private Car car;

    @RequestMapping(value="/", method=GET)
    public String home() {
        car.move();
        return "index";
    }

    @RequestMapping(value="/registration", method=POST)
    public @ResponseBody String registration(@RequestPart("profilePicture") MultipartFile profilePicture, User user) {
        car.move();
        return "home";
    }

}
