package com.sahil.Shop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.Shop.Model.Cart;
import java.util.List;


@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

     List<Cart> findByUserId(String userId);

     
}

