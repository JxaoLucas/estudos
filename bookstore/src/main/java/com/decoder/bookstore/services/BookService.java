package com.decoder.bookstore.services;

import com.decoder.bookstore.dtos.BookRecordDto;
import com.decoder.bookstore.models.BookModel;
import com.decoder.bookstore.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final ReviewService reviewService;

    public BookService(BookRepository bookRepository, ReviewService reviewService) {
        this.bookRepository = bookRepository;
        this.reviewService = reviewService;
    }

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(UUID id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public BookModel save(BookRecordDto bookRecordDto) {
        var bookModel = new BookModel();
        BeanUtils.copyProperties(bookRecordDto, bookModel);
        bookModel.setReview(reviewService.generateReview(bookModel.getTitle()));
        return bookRepository.save(bookModel);
    }

    @Transactional
    public BookModel save(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    @Transactional
    public BookModel update(BookModel bookModel, BookRecordDto bookRecordDto) {
        BeanUtils.copyProperties(bookRecordDto, bookModel);
        return bookRepository.save(bookModel);
    }

    @Transactional
    public void delete(BookModel bookModel) {
        bookRepository.delete(bookModel);
    }

    @Transactional
    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
