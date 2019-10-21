package libraryapp.controller;

import libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("allBooks", bookService.getAll());
        return "book-all";
    }

    @GetMapping("/info")
    public String bookInfo(@RequestParam("book_id") Long id, ModelMap model) {
        model.put("book", bookService.get(id));
        return "book-info";
    }
}
