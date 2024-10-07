
package com.sahil.Shop.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahil.Shop.Model.Book;


@Repository
public interface AccesariesRepo extends JpaRepository<Book, Long> {
}

