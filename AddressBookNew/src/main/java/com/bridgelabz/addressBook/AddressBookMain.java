package com.bridgelabz.addressBook;

public class AddressBookMain {
    public static void main(String[] args) {

            System.out.println("Welcome to Address Book System Program");

            AddressBookSystem addressBookSystem = new AddressBookSystem();
            addressBookSystem.addContacts();
            addressBookSystem.displayContacts();
        }

    }
