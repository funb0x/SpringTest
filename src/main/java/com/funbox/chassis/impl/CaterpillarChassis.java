package com.funbox.chassis.impl;

import com.funbox.chassis.Chassis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Анна on 19.02.2017.
 */
public class CaterpillarChassis implements Chassis {

    private static AtomicInteger instances = new AtomicInteger();

    public CaterpillarChassis() {
        instances.incrementAndGet();
    }

    public String ride(int speed) {
        String message = "riding on caterpillars speed " + speed + " instances " + instances.get();
        System.out.println(message);
        return message;
    }
}
