package com.example.LMS.controller;


import com.example.LMS.model.Book;
import com.example.LMS.model.User;
import com.example.LMS.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
@SessionAttributes("user")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/add")
    public String showAddBooks(@ModelAttribute User user,Model model) {
        if(!isLoggedIn(user)){
            return "redirect:/user/login";
        }
        model.addAttribute(new Book());
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book,
                          BindingResult result,
                          @ModelAttribute("user") User user){
        if(!isLoggedIn(user)){
            return "redirect:/user/login";
        }

        if(result.hasErrors()){
            return "add-book";
        }
        bookService.addBook(book);
        return "redirect:/book/viewbook";
    }

    @GetMapping("/viewbook")
    public String showViewBookPage(@ModelAttribute("user") User user, Model model){
        if(!isLoggedIn(user)){
            return "redirect:/user/login";
        }



        model.addAttribute("books", bookService.getAllBooks());
        return "view-books";
    }

    @GetMapping("/view/{id}")
    public String showBooksDetails(@PathVariable("id") long id,
                                   @ModelAttribute("user") User user,
                                   Model model) {
        if(!isLoggedIn(user)){
            return "redirect:/user/login";
        }
        model.addAttribute("book", bookService.getBookById(id));
        return "book-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookById(@PathVariable("id") long id,
                                 @ModelAttribute("user") User user) {
        if(!isLoggedIn(user)){
            return "redirect:/user/login";
        }

        bookService.deleteBookById(id);
        return "redirect:/book/viewbook";
    }




    private boolean isLoggedIn(User user) {
        if(user == null || user.getEmail() == null){
            return false;
        }
        return true;
    }
}
