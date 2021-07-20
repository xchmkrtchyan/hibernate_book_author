package hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Book book;
    private Book updatedBook;
    private Author author;
    private List<Author> authorList = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private long deleteID;
    private long updateID;
    private long readID;
    private int commandDao;

    public Controller() {
        start();
        DAO dao = new DAO(authorList,bookList,commandDao,deleteID,updateID,updatedBook,readID);
    }

    private void start() {
        System.out.println("Press number");
        System.out.println(" 1 for create book");
        System.out.println(" 2 for update book");
        System.out.println(" 3 for delete book");
        System.out.println(" 4 for read book");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        menuCoordinator(command);
    }

    private void menuCoordinator(int command) {
        switch (command) {
            case 1:
                bookCreateMenu();
                commandDao = 1;
                break;
            case 2:
                bookUpdateMenu();
                commandDao = 2;
                break;
            case 3:
                bookDeleteMenu();
                commandDao = 3;
                break;
            case 4:
                bookReadMenu();
                commandDao = 4;
                break;
        }
    }

    private void bookReadMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id");
        int inputId = scanner.nextInt();
        readID = inputId;
    }

    private void authorCreateMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Enter author name");
        String authorName = scanner.nextLine();
        System.out.println("Enter book name");
        String bookName = scanner1.nextLine();
        System.out.println("Enter book genre");
        String bookGenre = scanner2.nextLine();
        Author author = new Author(authorName);
        Book book = new Book(bookName,bookGenre);
        author.setBook(book);
        System.out.println("If you want to add any book for this author press 1 or 2 for exit");
        String anInt = scanner3.nextLine();
        while (!anInt.equals("2")) {
            System.out.println("Enter book name, press 2 for exit");
            String secondBookName = scanner4.nextLine();
            if (secondBookName.equals("2")){
                break;
            }
            System.out.println("Enter book genre");
            String secondBookGenre = scanner5.nextLine();
            Book book1 = new Book(secondBookName,secondBookGenre);
            author.setBook(book1);
            authorList.add(author);
        }
    }


    private void bookDeleteMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        long inputDeleteMenu = scanner.nextLong();
        deleteID = inputDeleteMenu;
    }

    private void deleteBookByName() {

    }

    private void deleteBookByID() {

    }

    private void bookUpdateMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter ID");
        long inputUpdate = scanner.nextLong();
        updateID = inputUpdate;
        System.out.println("Enter name to update");
        String updatedName = scanner1.nextLine();
        System.out.println("Enter genre to update");
        String updatedGenreName = scanner2.nextLine();
        updatedBook = new Book(updatedName,updatedGenreName);
    }

    private void bookCreateMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Enter book title");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book genre");
        String bookGenre = scanner1.nextLine();
        createBook(bookTitle,bookGenre);
        System.out.println("Enter author name");
        String authorName = scanner2.nextLine();
        createAuthor(authorName);
        System.out.println("If you want to add any author for this book press 1 or 2 for exit");
        String anInt = scanner3.nextLine();
        while (!anInt.equals("2")) {
            System.out.println("Enter author name, press 2 for exit");
            String secondAuthorName = scanner4.nextLine();
            anInt = secondAuthorName;
            createAuthor(secondAuthorName);
        }
    }

    private void createAll(String bookTitle, String bookGenre, String authorName) {
        createBook(bookTitle, bookGenre);
        createAuthor(authorName);
    }


    private void createAuthor(String authorName) {
        author = new Author();
        author.setName(authorName);
        authorList.add(author);
    }

    private void createBook(String bookTitle, String bookGenre) {
        book = new Book();
        book.setTitle(bookTitle);
        book.setGenre(bookGenre);
        bookList.add(book);
    }
}


