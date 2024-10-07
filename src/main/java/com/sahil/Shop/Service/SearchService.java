package com.sahil.Shop.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Shop.Model.Accesaries;
import com.sahil.Shop.Model.Book;
import com.sahil.Shop.Model.Notebook;
import com.sahil.Shop.Repository.AccesariesRepo;
import com.sahil.Shop.Repository.BookRepo;
import com.sahil.Shop.Repository.NotebookRepo;

@Service
public class SearchService {
    
    @Autowired
    private BookRepo table1Repository;
    
    @Autowired
    private NotebookRepo table2Repository;
    
    @Autowired
    private AccesariesRepo table3Repository;

    public List<Object> searchAcrossTables(String searchTerm) {
        List<Book> table1Results = table1Repository.findByNameContaining(searchTerm);
        List<Notebook> table2Results = table2Repository.findByNameContaining(searchTerm);
        List<Accesaries> table3Results = table3Repository.findByNameContaining(searchTerm);

        // Combine results
        List<Object> combinedResults = new ArrayList<>();
        combinedResults.addAll(table1Results);
        combinedResults.addAll(table2Results);
        combinedResults.addAll(table3Results);

        return combinedResults;
    }
}

