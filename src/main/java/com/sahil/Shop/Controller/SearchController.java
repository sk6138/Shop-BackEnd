package com.sahil.Shop.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.Shop.Service.SearchService;

@RestController
@RequestMapping("/api/search")
@CrossOrigin(origins = "http://localhost:5173/")
public class SearchController {
    
    @Autowired
    private SearchService searchService;

    @GetMapping
    public ResponseEntity<List<Object>> search(@RequestParam String term) {
        List<Object> results = searchService.searchAcrossTables(term);
        return ResponseEntity.ok(results);
    }
}

