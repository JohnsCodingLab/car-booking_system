package com.johnscodinglab.user;

import java.util.UUID;

public class User {
    private final String ID;
    private String firstName;
    private String lastName;


    {
        this.ID = UUID.randomUUID().toString();
    }

    public User(
            String firstName,
            String lastName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getID() {
        return this.ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + ID + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + "}";
    }
}
