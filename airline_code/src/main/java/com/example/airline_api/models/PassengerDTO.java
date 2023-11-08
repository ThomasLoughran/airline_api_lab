package com.example.airline_api.models;

public class PassengerDTO {
    private String name;
    private String email;

    public PassengerDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public PassengerDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
