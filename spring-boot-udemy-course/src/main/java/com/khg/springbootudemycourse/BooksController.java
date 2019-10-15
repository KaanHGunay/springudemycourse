package com.khg.springbootudemycourse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

@RestController
public class BooksController {
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return Collections.singletonList(new Book(1L, "TestBook", "TestAuthor"));
    }
}
