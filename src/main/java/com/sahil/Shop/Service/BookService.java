package com.sahil.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Repository.BookRepo;


import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;

    public List<Book> getAllNotebooks() {
        return bookRepository.findAll();
    }

    public Book getbookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
    }

    public Book createNotebook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateNotebook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));

        book.setName(bookDetails.getName());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        book.setImage(bookDetails.getImage());

        return bookRepository.save(book);
    }

    public void deleteNotebook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
        bookRepository.delete(book);
    }

    public void deletebook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletebook'");
    }
}

