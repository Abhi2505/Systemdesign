package com.SystemDesign.PhoneDirectory;

public class Main {
    public static void main(String[] args) {
        Directory directory=new Directory();
        directory.insert("9827276648","Kishor");
        directory.insert("9340356840","Abhinav");
        directory.insert("9675678923","Ram");
        System.out.println("Searching for 9827276648: " + directory.search("9827276648"));
        System.out.println("Searching for 5556667777: " + directory.search("5556667777"));
        System.out.println("Searching for 9675678923: " + directory.search("9675678923"));

        // Display all contacts
        System.out.println("\nAll Contacts:");
        directory.displayContacts();
    }

}
