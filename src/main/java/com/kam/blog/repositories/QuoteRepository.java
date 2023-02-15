package com.kam.blog.repositories;

import com.kam.blog.entities.Quote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    
    @Transactional
    @Modifying
    @Query("update Quote set description = :description where id = :id")
    void updateDescription(@Param("description") String description,
                 @Param("id") Long quoteId);
    
    @Transactional
    @Modifying
    @Query("update Quote set creationDate = :date where id = :id")
    void updateDate(@Param("date")Date date,
                    @Param("id") Long quoteId);
    
    @Transactional
    @Modifying
    @Query("update Quote set likes = :likes where id = :id")
    void updateLike(@Param("likes") int likes,
                @Param("id") Long quoteId);
    
}
