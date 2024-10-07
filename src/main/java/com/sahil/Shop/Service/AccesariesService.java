package com.sahil.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Accesaries;
import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Repository.AccesariesRepo;
import com.sahil.Shop.Repository.BookRepo;


import java.util.List;

@Service
public class AccesariesService {

    @Autowired
    private AccesariesRepo AccesariesRepo;

    public List<Accesaries> getAllNotebooks() {
        return AccesariesRepo.findAll();
    }

    public Accesaries getbookById(Long id) {
        return AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
    }

    public Accesaries createNotebook(Accesaries book) {
        return AccesariesRepo.save(book);
    }

    public Accesaries updateNotebook(Long id, Accesaries bookDetails) {
        Accesaries book = AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));

        book.setName(bookDetails.getName());
        book.setDescription(bookDetails.getDescription());
        book.setPrice(bookDetails.getPrice());
        book.setImage(bookDetails.getImage());

        return AccesariesRepo.save(book);
    }

    public void deleteNotebook(Long id) {
        Accesaries book = AccesariesRepo.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
        AccesariesRepo.delete(book);
    }

    public void deletebook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletebook'");
    }

    public List<Book> getAllAccesaaries() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAccesaaries'");
    }
}

