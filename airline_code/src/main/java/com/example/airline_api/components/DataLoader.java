package com.example.airline_api.components;

import com.example.airline_api.AirlineApiApplication;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flight londonFlight = new Flight("London", 100, "15/08/2024", "12:30");
        flightRepository.save(londonFlight);

        Passenger zsolt = new Passenger("Zsolt", "Zsolt@gmail.com");
        londonFlight.addPassenger(zsolt);
        passengerRepository.save(zsolt);

        Passenger colin = new Passenger("Colin", "colin@gmail.com");
        londonFlight.addPassenger(colin);
        passengerRepository.save(colin);

    }

}
