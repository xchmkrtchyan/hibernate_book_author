package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
         Controller controller = new Controller();
 /*       SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        Book book = new Book("girq","janr");
        book.addAuthor(new Author("garnik"));
        book.addAuthor(new Author("barnik"));
        book.addAuthor(new Author("darnik"));
        long id = 2;
        Book book1 = sessionFactory.getCurrentSession().get(Book.class, id);
        System.out.println(book1);
        sessionFactory.getCurrentSession().getTransaction().commit();*/

        /*SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        sessionFactory.getCurrentSession().beginTransaction();
        Author author = new Author("graano");
        author.addBook(new Book("bsaaaaaook","comedy"));
        author.addBook(new Book("basook","comedy"));
        sessionFactory.getCurrentSession().save(author);
        sessionFactory.getCurrentSession().getTransaction().commit();*/
        //long id = 3;
        //Book load = sessionFactory.getCurrentSession().load(Book.class,id);
        //sessionFactory.getCurrentSession().delete(load);
        //transaction.commit();
        //sessionFactory.getCurrentSession().close();
        //System.out.println(load.getTitle());/*
        //transaction.commit();*/


        /*sessionFactory1.getCurrentSession().update(book);*/

        //sessionFactory1.getCurrentSession().beginTransaction();
       // sessionFactory.getCurrentSession().save(book);
       // sessionFactory.getCurrentSession().flush();
        //sessionFactory1.getCurrentSession().getTransaction().commit();

    }
}






















/*hibernate.Controller controller = new hibernate.Controller();
        controller.start();
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(hibernate.Book.class).addAnnotatedClass(hibernate.Author.class).buildSessionFactory();

        sessionFactory.getCurrentSession().beginTransaction();
        hibernate.Book book = new hibernate.Book();

        //sessionFactory.getCurrentSession().save();
        sessionFactory.getCurrentSession().getTransaction().commit();*/
