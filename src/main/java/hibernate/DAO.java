package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Objects;

public class DAO {
    private List<Author> authorList;
    private List<Book> bookList;
    private Book updatedBook;
    private int commandDao;
    private long deleteID;
    private long updateID;
    private long readID;

    public DAO(List<Author> authorList, List<Book> bookList, int commandDao, long deleteID, long updateID, Book updatedBook, long readID) {
        this.authorList = authorList;
        this.bookList = bookList;
        this.commandDao = commandDao;
        this.deleteID = deleteID;
        this.updateID = updateID;
        this.readID = readID;
        this.updatedBook = updatedBook;
        start();
    }

    public void start(){
        switch (commandDao) {
            case 1:
                addBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                deleteBook();
                break;
            case 4:
                readBook();
                break;
        }
    }

    private void deleteBook() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        Book load = sessionFactory.getCurrentSession().load(Book.class,deleteID);
        sessionFactory.getCurrentSession().delete(load);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    private void updateBook() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        Book update = sessionFactory.getCurrentSession().get(Book.class,updateID);
        update.setTitle(updatedBook.getTitle());
        update.setGenre(updatedBook.getGenre());
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    private void addBook() {
        bookList.forEach(book -> {
            if (Objects.nonNull(book)){
                SessionFactory sessionFactory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                sessionFactory1.getCurrentSession().beginTransaction();
                sessionFactory1.getCurrentSession().save(book);
                sessionFactory1.getCurrentSession().getTransaction().commit();
            }
        });
    }

    private void readBook(){
        SessionFactory sessionFactory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory1.getCurrentSession().beginTransaction();
        Book book = sessionFactory1.getCurrentSession().get(Book.class, readID);
        System.out.println(book);
    }

    private void addColumn(){
        bookList.forEach(book1 -> {
            if (Objects.nonNull(book1)){
                SessionFactory sessionFactory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                sessionFactory1.getCurrentSession().beginTransaction();
                sessionFactory1.getCurrentSession().save(book1);
                sessionFactory1.getCurrentSession().getTransaction().commit();
            }
        });
        authorList.forEach(author1 -> {
            if (Objects.nonNull(author1)){
                SessionFactory sessionFactory1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                sessionFactory1.getCurrentSession().beginTransaction();
                sessionFactory1.getCurrentSession().save(author1);
                sessionFactory1.getCurrentSession().getTransaction().commit();
            }
        });
    }
}
