package com.funbox.app;

import com.funbox.car.Car;
import com.funbox.chassis.Chassis;
import com.funbox.chassis.impl.WheelChassis;
import com.funbox.motor.Motor;
import com.funbox.motor.impl.ElectricMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Анна on 18.02.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    public Car car(Chassis chassis) {
        return new Car(chassis, motor());
    }

    @Bean
    public Motor motor() {
        return new ElectricMotor();
    }

    @Bean
    public Chassis chassis() {
        return new WheelChassis();
    }

}
