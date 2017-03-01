package com.funbox.app;

import com.funbox.aspect.Logger;
import com.funbox.car.Car;
import com.funbox.chassis.Chassis;
import com.funbox.chassis.impl.WheelChassis;
import com.funbox.motor.Motor;
import com.funbox.motor.impl.ElectricMotor;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Анна on 18.02.2017.
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan("com.funbox.mvc")
public class AppConfig {

    @Bean
    public Car car(Chassis chassis) {
        return new Car(chassis);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Motor motor() {
        return new ElectricMotor();
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Chassis chassis() {
        return new WheelChassis();
    }

    @Bean
    public Logger logger() {
        return new Logger();
    }

}
