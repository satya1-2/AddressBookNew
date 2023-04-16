package com.bridgelabz.addressBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookMain extends Contacts {

        public static void main(String[] args) {
            List<Contacts> contactList = new ArrayList<Contacts>();
            contactList.add(new Contacts("satya", "yadav", "92348", "gorakhpur", "765234567", "ssiu23r@gmail.com"));
            contactList.add(new Contacts("kundan ", "kumar", "92334", "shivdhar", "7645567", "kuhgd23@gmail.com"));
            contactList.add(new Contacts("praveen", "singh", "92348", "bangaluru", "345234567", "prav12@gmail.com"));
            contactList.add(new Contacts("shubham", "kush", "6543", "pune", "234234567", "subh56@gmail.com"));
            contactList.add(new Contacts("elam", "prethi", "24548", "maharastra", "985234567", "elam97@gmail.com"));

//   filter the alphabetic name with Strat with s
            System.out.println("serach with alphabet of name : ");
            List<Contacts> newS = contactList.stream().filter(e -> e.name.startsWith("s")).collect(Collectors.toList());
            System.out.println(newS);

            // filter the city name who start with S
            System.out.println("searched with alphabet of city : ");
            List<Contacts> newSs = contactList.stream().filter(e -> e.city.startsWith("s")).collect(Collectors.toList());
            System.out.println(newSs);

            //  when only one contach detail need then we can use it
            System.out.println("only one contact list needed then : ");
            Contacts praveen = contactList.stream()
                    .filter(P -> "praveen".equals(P.getName()))
                    .findAny()
                    .orElse(null);
            System.out.println(praveen);

            System.out.println("printing all contact  in one list : ");
            List<Contacts> sortedList = contactList.stream()
                    .sorted(Comparator.comparing(contactList::contains))
                    .collect(Collectors.toList());
            System.out.println(sortedList);


            // Converting Contact List into a Map search two thing and
            System.out.println("fining two thing from contact list one is city and other is phonenumber : ");
            Map<String, String> productPriceMap =
                    contactList.stream()
                            .collect(Collectors.toMap(p -> p.city, p -> p.phoneNumber));

            System.out.println(productPriceMap);


        }
    }
