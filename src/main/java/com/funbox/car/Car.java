package com.funbox.car;

import com.funbox.chassis.Chassis;
import com.funbox.motor.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Анна on 18.02.2017.
 */
public class Car {

    private Chassis chassis;
    private Motor motor;

    public Car(Chassis chassis) {
        this.chassis = chassis;
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void move() {
        motor.torque();
        chassis.ride(10);
    }

    @Cacheable(value = "engine")
    public int getFuelConsumptionForDistance(int km) {
        return motor.getFuelConsumptionForDistance(km);
    }
}
