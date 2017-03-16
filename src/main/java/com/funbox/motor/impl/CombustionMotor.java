package com.funbox.motor.impl;

import com.funbox.motor.Motor;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Анна on 19.02.2017.
 */
public class CombustionMotor implements Motor {

    private static AtomicInteger instances = new AtomicInteger();

    public CombustionMotor() {
        instances.incrementAndGet();
    }

    public void torque() {
        System.out.println("Combustion Motor. Instance " + instances.get());
    }

    public int getFuelConsumptionForDistance(int km) {
        return km * 10;
    }
}
