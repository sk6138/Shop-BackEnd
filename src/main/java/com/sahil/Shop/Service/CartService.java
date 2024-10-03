package com.sahil.Shop.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Cart;
import com.sahil.Shop.Repository.CartRepo;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepository;

    

     public void addToCart(String userId,String image, Long productId, String productName, Double price, Integer quantity) {
        Cart cart = new Cart(userId,image, productId, productName, price, quantity);
        cartRepository.save(cart);
    }

   

    // Get all items in the user's cart
    public List<Cart> getCartItems(String userId) {
        return cartRepository.findByUserId(userId);
    }

    // Remove an item from the cart (optional)
    public void removeCartItem(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }
}

