package com.kam.blog.services.impl;

import com.kam.blog.entities.Quote;
import com.kam.blog.exceptions.ResourceNotFoundException;
import com.kam.blog.repositories.QuoteRepository;
import com.kam.blog.services.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    
    private final QuoteRepository quoteRepository;
    
    @Override
    public Quote create(Quote quote) {
        return quoteRepository.save(quote);
    }
    
    @Override
    public Quote getById(Long id) {
        return quoteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found"));
    }
    
    @Override
    public List<Quote> getAll() {
        return quoteRepository.findAll();
    }
    
    @Override
    public List<Quote> top10Quotes() {
        return quoteRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Quote::getLikes).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Quote> flop10Quotes() {
        return quoteRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Quote::getLikes))
                .limit(10)
                .collect(Collectors.toList());
    }
    
    @Override
    public void sendLike(Long id) {
        Quote quote = getById(id);
        quoteRepository.updateLike(quote.getLikes() + 1, id);
    }
    
    @Override
    public void sendDislike(Long id) {
        Quote quote = getById(id);
        quoteRepository.updateLike(quote.getLikes() - 1, id);
    }
    
    @Override
    public void update(String description, Long id) {
        quoteRepository.updateDescription(description, id);
        quoteRepository.updateDate(new Date(), id);
    }
    
    @Override
    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }
    
    @Override
    public Quote randomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int randomId = (int) (Math.random() * (quotes.size() - 1));
        return quotes.get(randomId);
    }
    
}
