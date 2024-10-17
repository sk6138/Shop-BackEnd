package com.sahil.Shop.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Model.Contact;
import com.sahil.Shop.Service.BookService;
import com.sahil.Shop.Service.ContactService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService bookService;

    // Get all notebooks
    @GetMapping("/all")
    public List<Contact> getAllBooks() {
        return bookService.getAllNotebooks();
    }

    // Get notebook by ID
    // @GetMapping("/{id}")
    // public ResponseEntity<Contact> getbookById(@PathVariable Long id) {
    //     Contact book = bookService.getbookById(id);
    //     return ResponseEntity.ok(book);
    // }

    // Create a new notebook
    @PostMapping("/post")
    public void createbook(@RequestBody Contact book) {
        bookService.createContact(book);
        
    }

    // Update a notebook
    // @PutMapping("/{id}")
    // public ResponseEntity<Contact> updatebook(@PathVariable Long id, @RequestBody Contact bookDetails) {
    //     Contact updatedbook = bookService.updateNotebook(id, bookDetails);
    //     return ResponseEntity.ok(updatedbook);
    // }

    // Delete a notebook
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletebook(@PathVariable Long id) {
    //     bookService.deletebook(id);
    //     return ResponseEntity.noContent().build();
    // }
}


