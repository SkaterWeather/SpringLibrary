package libraryapp.controller;

import java.time.LocalDate;
import libraryapp.entity.Book;
import libraryapp.entity.Rent;
import libraryapp.entity.User;
import libraryapp.service.BookService;
import libraryapp.service.RentService;
import libraryapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;

    @Autowired
    private RentService rentService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public String allRentByUser(ModelMap model) {
        model.put("rents", rentService.getAllByUserId(USER_ID));
        return "rent-all-by-user";
    }

    @GetMapping("/add")
    public String addRent(@RequestParam("book_id") Long bookId, ModelMap model) {
        User user = userService.get(USER_ID);
        Book book = bookService.get(bookId);
        rentService.add(new Rent(LocalDate.now(), user, book, true));
        return allRentByUser(model);
    }

    @GetMapping("/discredit")
    public String discreditRent(@RequestParam("rent_id") Long rentId, ModelMap model) {
        rentService.discreditRent(rentId);
        return allRentByUser(model);
    }
}
