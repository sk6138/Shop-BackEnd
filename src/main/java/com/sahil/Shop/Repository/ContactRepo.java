package com.sahil.Shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.Shop.Model.Contact;

@Repository
public interface ContactRepo  extends JpaRepository<Contact,Long>{
    
}
