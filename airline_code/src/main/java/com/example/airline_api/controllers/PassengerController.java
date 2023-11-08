package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        List<Passenger> passengers = passengerService.getPassengerList();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long id){
        Passenger passenger = passengerService.getPassengerById(id);
        if(passenger != null){
            return new ResponseEntity<>(passenger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(passenger, HttpStatus.NOT_FOUND);
        }
    }

    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDTO passengerDTO){
        Passenger passenger = passengerService.addNewPassenger(passengerDTO);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

}
