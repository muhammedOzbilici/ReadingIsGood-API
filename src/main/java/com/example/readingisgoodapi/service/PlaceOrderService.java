package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.converter.OrderDtoToEntityConverter;
import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.Book;
import com.example.readingisgoodapi.model.ResponseModel;
import com.example.readingisgoodapi.repository.BookRepository;
import com.example.readingisgoodapi.repository.OrderEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceOrderService {
    private final OrderEntityRepository orderEntityRepository;
    private final BookRepository bookRepository;
    private final OrderDtoToEntityConverter orderDtoToEntityConverter;

    @Retryable(include = {ConcurrencyFailureException.class, StaleObjectStateException.class},
            backoff = @Backoff(delay = 100L, multiplier = 3), maxAttempts = 5)
    public ResponseModel placeOrder(OrderDto orderDto) {
        ResponseModel responseModel = new ResponseModel();
        Long bookId = orderDto.getBookId();
        Optional<Book> foundedBook = bookRepository.findByBookIdAndActive(bookId, true);
        if (foundedBook.isPresent()) {
            Book book = foundedBook.get();
            if (book.getStock() > 0) {
                orderEntityRepository.save(Objects.requireNonNull(orderDtoToEntityConverter.convert(orderDto)));
                book.setStock(book.getStock() - 1);
                bookRepository.save(book);
                responseModel.setSuccessful(true);
            } else {
                log.info("There is not enough stock for this bookId={}", bookId);
                responseModel.setResultMessage("There is not enough stock.");
                responseModel.setSuccessful(false);
            }
        } else {
            log.info("Couldn't find book with bookId={}", bookId);
            responseModel.setResultMessage("Couldn't find this book.");
            responseModel.setSuccessful(false);
        }
        return responseModel;
    }

}
