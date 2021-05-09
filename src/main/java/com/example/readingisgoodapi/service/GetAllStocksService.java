package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.entity.Book;
import com.example.readingisgoodapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetAllStocksService {
    private final BookRepository bookRepository;

    public  List<Book> getAllStocks() {
        return bookRepository.findByActive(true);
    }

}
