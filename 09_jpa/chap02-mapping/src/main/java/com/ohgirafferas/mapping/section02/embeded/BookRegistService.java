package com.ohgirafferas.mapping.section02.embeded;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookRegistService {

    private BookRepository bookRepository;

    public BookRegistService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void registBook(BookRegistDTO newbook){

        Book book = new Book(
                newbook.getBookTitle(),
                newbook.getAuthor(),
                newbook.getPublisher(),
                newbook.getPublishedDate(),
                new Price(
                        newbook.getRegularPrice(),
                        newbook.getDiscountRate()
                )
        );
        bookRepository.save(book);
    }
}
