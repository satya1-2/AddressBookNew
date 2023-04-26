package com.bridgelabz.addressBook;


public class NewContact {
                String firstName;
                String lastName;
                String state;
                String zip;
                String phoneNumber;
                String email;
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
                public String getState() {
                        return state;
                }
                public void setState(String state) {
                        this.state = state;
                }
                public String getZip() {
                        return zip;
                }
                public void setZip(String zip) {
                        this.zip = zip;
                }
                public String getPhoneNumber() {
                        return phoneNumber;
                }
                public void setPhoneNumber(String phoneNumber) {
                        this.phoneNumber = phoneNumber;
                }
                public String getEmail() {
                        return email;
                }
                public void setEmail(String email) {
                        this.email = email;
                }
                public NewContact(String firstName, String lastName, String state, String zip, String phoneNumber, String email) {
                        this.firstName = firstName;
                        this.lastName = lastName;
                        this.state = state;
                        this.zip = zip;
                        this.phoneNumber = phoneNumber;
                        this.email = email;
                }
                public NewContact() {
                        super();
                }
                @Override
                public String toString() {
                        return " name " + this.firstName + " lastname " + this.lastName + " state " + this.state + " zip" + this.zip + " phoneNumber " + this.phoneNumber +
                                "gmail" + this.email;
                }

        }