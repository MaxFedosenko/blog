package com.kam.blog.controllers;

import com.kam.blog.entities.Quote;
import com.kam.blog.services.impl.QuoteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
@RequiredArgsConstructor
public class QuoteController {
    
    private final QuoteServiceImpl quoteService;
    
    @GetMapping
    public ResponseEntity<List<Quote>> gelAll(){
        return ResponseEntity.ok().body(quoteService.getAll());
    }
    
    @GetMapping("/getbyid")
    public ResponseEntity<Quote> getById(@RequestParam Long id){
        return ResponseEntity.ok().body(quoteService.getById(id));
    }
    
    @GetMapping("/randomquote")
    public ResponseEntity<Quote> randomQuote() {
        return ResponseEntity.ok().body(quoteService.randomQuote());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Quote> create(@Valid Quote quote) {
        return ResponseEntity.ok().body(quoteService.create(quote));
    }
    
    @PostMapping("/update")
    public ResponseEntity<Quote> update(@RequestParam String description, @RequestParam Long id) {
        quoteService.update(description, id);
        return ResponseEntity.ok().body(quoteService.getById(id));
    }
    
    @PostMapping("/like")
    public void like (@RequestParam Long id) {
        quoteService.sendLike(id);
    }
    
    @PostMapping("/dislike")
    public void disLike (@RequestParam Long id) {
        quoteService.sendDislike(id);
    }
    
    @GetMapping("/top10")
    public ResponseEntity<List<Quote>> top10Quotes() {
        return ResponseEntity.ok().body(quoteService.top10Quotes());
    }
    
    @GetMapping("/flop10")
    public ResponseEntity<List<Quote>> flop10Quotes() {
        return ResponseEntity.ok().body(quoteService.flop10Quotes());
    }
    
    @DeleteMapping()
    public void delete(@RequestParam Long id) {
        quoteService.delete(id);
    }
    
}
