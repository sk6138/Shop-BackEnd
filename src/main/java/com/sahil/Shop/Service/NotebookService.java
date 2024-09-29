package com.sahil.Shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Notebook;
import com.sahil.Shop.Repository.NotebookRepo;

import java.util.List;

@Service
public class NotebookService {

    @Autowired
    private NotebookRepo notebookRepository;

    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    public Notebook getNotebookById(Long id) {
        return notebookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
    }

    public Notebook createNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

    public Notebook updateNotebook(Long id, Notebook notebookDetails) {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));

        notebook.setName(notebookDetails.getName());
        notebook.setDescription(notebookDetails.getDescription());
        notebook.setPrice(notebookDetails.getPrice());
        notebook.setImage(notebookDetails.getImage());

        return notebookRepository.save(notebook);
    }

    public void deleteNotebook(Long id) {
        Notebook notebook = notebookRepository.findById(id).orElseThrow(() -> new RuntimeException("Notebook not found"));
        notebookRepository.delete(notebook);
    }
}
