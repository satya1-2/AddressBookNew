package com.bridgelabz.addressBook;

import com.bridgelabz.addressBook.Contacts;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class AddressBook extends Contacts{

            private static Scanner in = new Scanner(System.in);
            private static File file = new File("Addresses.txt");
            static List<Contacts> people = new ArrayList<>();

    AddressBook(String name, String surname, String phoneNumber, String email, String address) {
        super(name, surname, phoneNumber, email, address);
    }

    public static void main(String[] args) throws IOException {
                readPeopleFromFile();
                showMainMenu();
            }

            private static void findPerson() throws IOException {
                System.out.println("1. Find with name");
                System.out.println("2. Find with surname");

                String choice;
                do {
                    choice = in.nextLine();
                    switch (choice) {
                        case "1":
                            findByName();
                            break;
                        case "2":
                            findBySurname();
                            break;
                        default:
                            System.out.print("Choose 1 or 2: ");
                    }
                } while (!choice.equals("1") && !choice.equals("2"));
                System.out.println();
                showMainMenu();
            }

            private static void findBySurname() {
                System.out.print("Enter surname: ");
                String surnameToFind = in.nextLine();
                int matches = 0;
                for(Contacts person : people) {
                    if(person.getSurname().equals(surnameToFind)) {
                        System.out.println(person);
                        matches++;
                    }
                }
                if(matches<=0) {
                    System.out.println("There is no Person with this surname");
                }
            }

            private static void findByName() {
                System.out.print("Enter name: ");
                String nameToFind = in.nextLine();
                int matches = 0;
                for(Contacts person : people) {
                    if(person.getName().equals(nameToFind)) {
                        System.out.println(person);
                        matches++;
                    }
                }
                if(matches<=0) {
                    System.out.println("There is no Person with this name ");
                }
            }

            private static void addPerson() throws IOException {

                System.out.println("Enter name: ");
                String name = in.nextLine();
                System.out.println("Enter surname: ");
                String surname = in.nextLine();
                System.out.println("Enter phone number: ");
                String phoneNumber = in.nextLine();
                System.out.println("Enter email: ");
                String email = in.nextLine();
                System.out.println("Enter addres: ");
                String address = in.nextLine();

                Contacts person = new Contacts(name, surname, phoneNumber, email, address);
                addToFile(person);
                people.add(person);
                System.out.println("Added Person number: "  + person);
                System.out.println();
                showMainMenu();
            }

            private static void addToFile(Contacts person) {
                try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(person.getName()+"\r\n" + person.getSurname() + "\r\n" + person.getPhoneNumber() + "\r\n" + person.getEmail() +
                            "\r\n" + person.getAddress() + "\r\n\r\n");
                } catch(IOException e) {
                    System.out.println(e);
                }
            }

            private static boolean readPeopleFromFile() throws IOException {
                try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String name = null;
                    while((name = reader.readLine()) != null) {
                        Contacts person = new Contacts(name, reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine());
                        people.add(person);        //adds Person to the list
                        reader.readLine();
                    }
                    return true;
                }
                catch ( IOException e) {
                    System.out.println(e);
                }
                return false;
            }

            private static void showMainMenu() throws IOException {
                System.out.println("1. Add Person");
                System.out.println("2. Find Person");
                System.out.println("3. Show all contacts");
                System.out.println("4. Close program");

                String choice;
                do {
                    choice = in.nextLine();
                    switch (choice) {
                        case "1":
                            addPerson();
                            break;
                        case "2":
                            findPerson();
                            break;
                        case "3":
                            System.out.println(people);
                            System.out.println();
                            showMainMenu();
                            break;
                        case "4":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Enter numer from 1 to 4");
                    }
                }while(!choice.equals("4"));
            }
        }