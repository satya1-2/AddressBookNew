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

    public static void main(String[] args) throws  IOException {

        List<NewContact> persons = new ArrayList<>();
        persons.add(new NewContact("Satya", "yadav", "up", "12344", "7065434", "sspra123@gmail"));
        persons.add(new NewContact("kundan", "kumar", "bihar", "12334", "34065434", "kund123@gmail"));
        persons.add(new NewContact("praveen", "singh", "karnataka", "1232344", "7234065434", "pra123@gmail"));
        persons.add(new NewContact("pallavi", "parteti", "pune", "12322344", "723434065434", "pall123@gmail"));
        String fileName = "C:src/main/resources/persons.json";
        Path path = Paths.get(fileName);


        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();

            JsonElement tree = gson.toJsonTree(persons);
            gson.toJson(tree, writer);

        }

        System.out.println("persons details  written to file");
        System.out.println(".....................................");
        System.out.println("reading the person  details file ");
        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            Gson gson = new Gson();
            List<NewContact> person = gson.fromJson(reader,
                    new TypeToken<List<NewContact>>() {
                    }.getType());

            person.forEach(System.out::println);
        }
    }
}

