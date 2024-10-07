package com.sahil.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Repository.AccesariesRepo;
import com.sahil.Shop.Repository.BookRepo;


import java.util.List;

@Service
public class AccesariesService {

    @Autowired
    private AccesariesRepo AccesariesRepo;

    public List<Book> getAllNotebooks() {
        return AccesariesRepo.findAll();
    }

    public Book getbookById(Long id) {
        return AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
    }

    public Book createNotebook(Book book) {
        return AccesariesRepo.save(book);
    }

    public Book updateNotebook(Long id, Book bookDetails) {
        Book book = AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));

        book.setName(bookDetails.getName());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        book.setImage(bookDetails.getImage());

        return AccesariesRepo.save(book);
    }

    public void deleteNotebook(Long id) {
        Book book = AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
        AccesariesRepo.delete(book);
    }

    public void deletebook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletebook'");
    }
}

