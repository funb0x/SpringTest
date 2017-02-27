package com.funbox.motor.impl;

import com.funbox.motor.Motor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Анна on 18.02.2017.
 */
public class ElectricMotor implements Motor {

    private static AtomicInteger instances = new AtomicInteger();

    public ElectricMotor() {
        instances.incrementAndGet();
    }

    public void torque() {
        System.out.println("Electric motor. instance " + instances.get());
    }
}
