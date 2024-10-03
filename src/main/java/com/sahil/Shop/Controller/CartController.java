package com.sahil.Shop.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Model.Cart;
import com.sahil.Shop.Model.CartRequest;
import com.sahil.Shop.Service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "https://shop-frontend-plum.vercel.app/")
public class CartController {

    @Autowired
    private CartService cartService;

     @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
       Cart newcart = cartService.addToCart(cart);
        return ResponseEntity.ok(newcart);
    }

    // Get all items in the user's cart
    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable String userId) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    // Optional: Remove item from the cart
    @DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeCartItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
        return ResponseEntity.ok("Item removed from cart.");
    }
}
