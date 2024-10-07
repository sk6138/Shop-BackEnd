package com.sahil.Shop.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Service.AccesariesService;
import com.sahil.Shop.Service.BookService;


import java.util.List;

@RestController
@CrossOrigin(origins = "https://shop-frontend-plum.vercel.app/")
@RequestMapping("/api/accesaries")
public class AccesaariesController {

    @Autowired
    private AccesariesService acc;

    // Get all notebooks
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return acc.getAllNotebooks();
    }

    // Get notebook by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getbookById(@PathVariable Long id) {
        Book book = acc.getbookById(id);
        return ResponseEntity.ok(book);
    }

    // Create a new notebook
    @PostMapping("/post")
    public ResponseEntity<Book> createbook(@RequestBody Book book) {
        Book newbook = acc.createNotebook(book);
        return ResponseEntity.ok(newbook);
    }

    // Update a notebook
    @PutMapping("/{id}")
    public ResponseEntity<Book> updatebook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedbook = acc.updateNotebook(id, bookDetails);
        return ResponseEntity.ok(updatedbook);
    }

    // Delete a notebook
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebook(@PathVariable Long id) {
        acc.deletebook(id);
        return ResponseEntity.noContent().build();
    }
}


