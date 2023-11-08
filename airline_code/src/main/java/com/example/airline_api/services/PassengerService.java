package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getPassengerList(){
        List<Passenger> passengers = passengerRepository.findAll();
        return passengers;
    }

    public Passenger getPassengerById(long id){
        Passenger passenger;
        if (passengerRepository.findById(id).isPresent()){
            passenger = passengerRepository.findById(id).get();
        } else {
            passenger = null;
        }
        return passenger;
    }

    public Passenger addNewPassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());
        passengerRepository.save(passenger);
        return passenger;
    }

}
