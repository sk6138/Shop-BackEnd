package com.sahil.Shop.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Model.Notebook;
import com.sahil.Shop.Service.NotebookService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/notebooks")
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    // Get all notebooks
    @GetMapping("/all")
    public List<Notebook> getAllNotebooks() {
        return notebookService.getAllNotebooks();
    }

    // Get notebook by ID
    @GetMapping("/{id}")
    public ResponseEntity<Notebook> getNotebookById(@PathVariable Long id) {
        Notebook notebook = notebookService.getNotebookById(id);
        return ResponseEntity.ok(notebook);
    }

    // Create a new notebook
    @PostMapping("/post")
    public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook) {
        Notebook newNotebook = notebookService.createNotebook(notebook);
        return ResponseEntity.ok(newNotebook);
    }

    // Update a notebook
    @PutMapping("/{id}")
    public ResponseEntity<Notebook> updateNotebook(@PathVariable Long id, @RequestBody Notebook notebookDetails) {
        Notebook updatedNotebook = notebookService.updateNotebook(id, notebookDetails);
        return ResponseEntity.ok(updatedNotebook);
    }

    // Delete a notebook
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotebook(@PathVariable Long id) {
        notebookService.deleteNotebook(id);
        return ResponseEntity.noContent().build();
    }
}

