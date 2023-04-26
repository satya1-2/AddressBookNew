package com.bridgelabz.addressBook;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddressBookMain  {
    public static void main(String[] args) {
        List<NewContact> persons = new ArrayList<>();
        persons.add(new NewContact("Satya", "yadav", "up", "12344", "7065434", "sspra123@gmail"));
        persons.add(new NewContact("kundan", "kumar", "bihar", "12334", "34065434", "kund123@gmail"));
        persons.add(new NewContact("praveen", "singh", "karnataka", "1232344", "7234065434", "pra123@gmail"));
        persons.add(new NewContact("pallavi", "parteti", "pune", "12322344", "723434065434", "pall123@gmail"));
        System.out.println("writing a file of csv");
        System.out.println("reading a file of csv");

        try {
            FileWriter file = new FileWriter("sample.csv");
            PrintWriter write = new PrintWriter(file);
            for (NewContact name : persons) {
                write.println(name);
            }
            write.close();
        } catch (IOException exe) {
            System.out.println("Cannot create file");
            String line = "";
            String splitBy = ",";
            try {
//parsing a CSV file into BufferedReader class constructor
                BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\stya yadav\\Desktop/sample.csv"));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] newContact = line.split(splitBy);    // use comma as separator
                    System.out.println("newContact [First Name=" + newContact[0] + ", Last Name=" + newContact[1] + ", state=" + newContact[2] + ", zip=" + newContact[3] + ", phoneNumber= " + newContact[4] + ", email= " + newContact[5] + "]");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}

