package org.newlibrary;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File filePath = new File("./resources/data.txt");

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
            writeBooksToFile(book, filePath);
        }

        readFile(filePath);

        scanner.close();
    }

    private static void writeBooksToFile(Book book, File file) {
        // try-with-resources
        try (FileWriter fileWriter = new FileWriter(file, true)) { // Aggiunto 'true' per abilitare l'append
            fileWriter.write(book.printBook() + "\n"); // Aggiunto '\n' per separare i libri nel file
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + e.getMessage());
        }
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read file");
        }
    }
}
