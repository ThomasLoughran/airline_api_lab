package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> getAllFlights(){
        List<Flight> flights = flightRepository.findAll();
        return flights;
    }

    public Flight getFlightById(long id){
        Flight flight;
        if(flightRepository.findById(id).isPresent()){
            flight = flightRepository.findById(id).get();
        }
        else {
            flight = null;
        }
        return flight;
    }

    public Flight createFlight(FlightDTO flightDTO){
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        for (Long passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flight.addPassenger(passenger);
        }
        flightRepository.save(flight);
        return flight;
    }

    public void cancelFlightById(long id){
        flightRepository.deleteById(id);
    }

}
