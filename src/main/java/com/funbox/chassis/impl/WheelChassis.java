package com.funbox.chassis.impl;

import com.funbox.chassis.Chassis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Анна on 18.02.2017.
 */
public class WheelChassis implements Chassis {

    private static AtomicInteger instances = new AtomicInteger();

    public WheelChassis() {
        instances.incrementAndGet();
    }
    public String ride(int speed) {
        String message = "riding on Wheels!!!! speed " + speed + " instances " + instances.get();
        System.out.println(message);
        return message;
    }
}
