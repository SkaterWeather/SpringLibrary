package libraryapp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import libraryapp.config.AppConfig;
import libraryapp.entity.Author;
import libraryapp.entity.Book;
import libraryapp.entity.Rent;
import libraryapp.entity.User;
import libraryapp.service.AuthorService;
import libraryapp.service.BookService;
import libraryapp.service.RentService;
import libraryapp.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        RentService rentService = context.getBean(RentService.class);

        //Add users
        userService.add(new User("Suni", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));

        //Add books
        bookService.add(new Book("Fight Club", 25.00, 1996, Collections.emptyList()));
        bookService.add(new Book("LOTR: Fellowhip of the Ring", 25.00, 1954, Collections.emptyList()));

        //Add authors
        authorService.add(new Author("Chuck", "Palahniuk", bookService.getByTitle("Fight Club")));
        authorService.add(new Author("John Ronald Reuel", "Tolkien", bookService.getByTitle("LOTR")));

        //Add rents
        rentService.add(new Rent(LocalDate.now(),
                userService.getAll().get(0),
                bookService.getByTitle("LOTR: Fellowhip of the Ring").get(0),
                true));

        //Get Authors
        List<Author> getAll = authorService.getAll();
        List<Author> getByName = authorService.getByName("Chuck");
        List<Author> getByNameAndSurname = authorService.getByNameAndSurname("Chuck", "Palahniuk");

        //Get rents
        List<Rent> rents = rentService.getAll();

        context.close();
    }
}
