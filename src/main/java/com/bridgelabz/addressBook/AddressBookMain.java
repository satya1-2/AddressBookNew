package com.bridgelabz.addressBook;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class AddressBookMain {

    public static void main(String[] args) throws IOException {
        AddressBookMain writeIntoJsonDemo = new AddressBookMain();
        writeIntoJsonDemo.writeIntoJson();
        writeIntoJsonDemo.readFromJson();
    }

    public void writeIntoJson() throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(
                "C:\\Users\\stya yadav\\IdeaProjects\\AddressBookNew\\src\\main\\resources\\contacts.json");


        NewContact contact = new NewContact();
        contact.setFirstName("Satya");
        contact.setLastName("yadav");
        contact.setState("lucknow");
        contact.setZip("274702");
        contact.setPhoneNumber("1234562345");
        contact.setEmail("sspra143@gmail.com");

        String json = gson.toJson(contact);

        fileWriter.write(json);
        fileWriter.close();
        System.out.println(json);

    }

    public void readFromJson() throws FileNotFoundException {
        Gson gson = new Gson();
        System.out.println("Reading data from the json");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "C:\\Users\\stya yadav\\IdeaProjects\\AddressBookNew\\src\\main\\resources\\contacts.json"));
        NewContact info = gson.fromJson(bufferedReader, NewContact.class);
        System.out.println("contact First Name: " + info.getFirstName());
        System.out.println("contact Last Name:" + info.getLastName());
        System.out.println("contact state: " + info.getState());
        System.out.println("contact Zip:" + info.getZip());
        System.out.println("contact phoneNumber:" + info.getPhoneNumber());
        System.out.println("contact Email:" + info.getEmail());

    }
}
