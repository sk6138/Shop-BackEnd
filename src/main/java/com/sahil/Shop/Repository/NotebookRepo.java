package com.sahil.Shop.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.Shop.Model.Notebook;

@Repository
public interface NotebookRepo extends JpaRepository<Notebook, Long> {
}

