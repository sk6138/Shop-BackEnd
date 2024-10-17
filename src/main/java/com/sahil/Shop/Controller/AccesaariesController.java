package com.sahil.Shop.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Model.Accesaries;
import com.sahil.Shop.Service.AccesariesService;



import java.util.List;

@RestController
@CrossOrigin(origins = "https://shop-frontend-plum.vercel.app/")
@RequestMapping("/api/accesaries")
public class AccesaariesController {

    @Autowired
    private AccesariesService acc;

    // Get all notebooks
    @GetMapping("/all")
    public List<Accesaries> getAllAccesaaries() {
        return acc.getAllNotebooks();
    }

    // Get notebook by ID
    @GetMapping("/{id}")
    public ResponseEntity<Accesaries> getAccesaariesById(@PathVariable Long id) {
        Accesaries Accesaaries = acc.getbookById(id);
        return ResponseEntity.ok(Accesaaries);
    }

    // Create a new notebook
    @PostMapping("/post")
    public ResponseEntity<Accesaries> createbook(@RequestBody Accesaries book) {
        Accesaries newbook = acc.createNotebook(book);
        return ResponseEntity.ok(newbook);
    }

    // Update a notebook
    @PutMapping("/{id}")
    public ResponseEntity<Accesaries> updatebook(@PathVariable Long id, @RequestBody Accesaries bookDetails) {
        Accesaries updatedbook = acc.updateNotebook(id, bookDetails);
        return ResponseEntity.ok(updatedbook);
    }

    // Delete a notebook
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletebook(@PathVariable Long id) {
        acc.deletebook(id);
        return ResponseEntity.noContent().build();
    }
}


