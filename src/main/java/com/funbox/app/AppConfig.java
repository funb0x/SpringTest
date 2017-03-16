package com.funbox.app;

import com.funbox.aspect.Logger;
import com.funbox.car.Car;
import com.funbox.chassis.Chassis;
import com.funbox.chassis.impl.WheelChassis;
import com.funbox.motor.Motor;
import com.funbox.motor.impl.CombustionMotor;
import com.funbox.motor.impl.ElectricMotor;
import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.xml.ws.Endpoint;
import java.io.IOException;

/**
 * Created by Анна on 18.02.2017.
 */
@Configuration
@EnableAspectJAutoProxy
@EnableCaching
@ComponentScan("com.funbox.service")
public class AppConfig {

    @Bean
    public Car car(Chassis chassis) {
        return new Car(chassis);
    }

    @Bean
    //@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Motor motor() {
        return new CombustionMotor();
    }

    @Bean
   // @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Chassis chassis() {
        return new WheelChassis();
    }

    @Bean
    public Logger logger() {
        return new Logger();
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("engine");
    }

    @Bean
    public SimpleJaxWsServiceExporter jaxWsExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8080/");
        return exporter;
    }

}
