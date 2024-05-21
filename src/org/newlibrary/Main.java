package org.newlibrary;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 3,number_of_pages;
        String author, title, publisher;

        Book[] booksArray = new Book[n];

        for (int i = 0; i < n; i++) {
            Book book = null;
            while(book == null){
                try {
                    System.out.println("Insert title: ");
                    title = scanner.nextLine();
                    System.out.println("Insert author: ");
                    author = scanner.nextLine();
                    System.out.println("Insert publisher: ");
                    publisher = scanner.nextLine();
                    System.out.println("Insert number of pages: ");
                    number_of_pages = Integer.parseInt(scanner.nextLine());
                    book = new Book(title,author,publisher,number_of_pages);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            booksArray[i] = book;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(booksArray[i].printBook());
        }

    }
}
