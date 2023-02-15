package com.kam.blog.services;

import com.kam.blog.entities.Quote;

import java.util.List;

public interface QuoteService {
    
    Quote create(Quote quote);
    Quote getById(Long id);
    Quote randomQuote();
    List<Quote> getAll();
    void update(String description, Long id);
    void delete(Long id);
    void sendLike(Long quoteId);
    void sendDislike(Long quoteId);
    List<Quote> top10Quotes();
    List<Quote> flop10Quotes();
    
}
