package com.funbox.car;

import com.funbox.chassis.Chassis;
import com.funbox.motor.Motor;

/**
 * Created by Анна on 18.02.2017.
 */
public class Car {

    private Chassis chassis;

    private Motor motor;

    public Car(Chassis chassis, Motor motor) {
        this.chassis = chassis;
        this.motor = motor;
    }

    public void move() {
        motor.torque();
        chassis.ride();
    }
}
