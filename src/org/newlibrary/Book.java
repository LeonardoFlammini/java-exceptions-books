package org.newlibrary;

public class Book {

    //Attributes
    private int number_of_pages;
    private String author,title,publisher;



    //Constructor
    public Book (String title,String author,String publisher,int number_of_pages) throws IllegalArgumentException{
        checkString(title, "Title");
        checkString(author, "Author");
        checkString(publisher, "Publisher");
        checkPages(number_of_pages);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.number_of_pages = number_of_pages;
    }




    //Setter
    public void setTitle(String title) throws IllegalArgumentException{
        checkString(title, "Title");
        this.title = title;
    }
    public void setAuthor(String author) throws IllegalArgumentException{
        checkString(author,"Author");
        this.author = author;
    }
    public void setPublisher(String publisher) throws IllegalArgumentException{
        checkString(publisher,"Publisher");
        this.publisher = publisher;
    }
    public void setNumber_of_pages(int number_of_pages) throws NumberFormatException{
        checkPages(number_of_pages);
        this.number_of_pages = number_of_pages;
    }



    // Getter
    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    //Methods
    public String printBook(){
        String book = String.format("{\nTitle: %s\nAuthor: %s\nPublisher: %s\nNumber of pages: %d\n}",title,author,publisher,number_of_pages);
        return book;
    }



    //Exception
    public void checkString(String s, String type) throws IllegalArgumentException{
        if (s == null || s.isEmpty()){
            throw new IllegalArgumentException("Invalid parameter " + type);
        }
    }

    public void checkPages(int p){
        if (p<=0){
            throw new NumberFormatException("Invalid number of pages");
        }
    }



}
