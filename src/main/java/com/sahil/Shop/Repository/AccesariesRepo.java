
package com.sahil.Shop.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.Shop.Model.Accesaries;



@Repository
public interface AccesariesRepo extends JpaRepository<Accesaries, Long> {
    List<Accesaries> findByNameContaining(String searchTerm);
}

