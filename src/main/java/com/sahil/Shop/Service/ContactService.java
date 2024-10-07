package com.sahil.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sahil.Shop.Model.Contact;

import com.sahil.Shop.Repository.ContactRepo;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepo bookRepository;

    public List<Contact> getAllNotebooks() {
        return bookRepository.findAll();
    }

    

    public Contact createContact(Contact contact) {
        return bookRepository.save(contact);
    }



    

    

    
    
}

