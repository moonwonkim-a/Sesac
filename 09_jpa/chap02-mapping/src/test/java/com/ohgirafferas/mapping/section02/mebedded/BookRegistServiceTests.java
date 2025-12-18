package com.ohgirafferas.mapping.section02.mebedded;

import com.ohgirafferas.mapping.section02.embeded.Book;
import com.ohgirafferas.mapping.section02.embeded.BookRegistDTO;
import com.ohgirafferas.mapping.section02.embeded.BookRegistService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class BookRegistServiceTests {

    @Autowired
    private BookRegistService bookRegistService;

    private static Stream<Arguments> getBook () {
        return Stream.of(
                Arguments.of(
                        "혼자 공부하는 자바",
                        "신용권",
                        "한빛미디어",
                        LocalDate.now(),
                        28000,
                        0.1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getBook")
    void testCreateEmbeddedPriceOfBook(
            String bookTitle, String author, String publisher,
            LocalDate publishedDate, int regularPrice, double discountRate
    ){
        // given
        BookRegistDTO newBook = new BookRegistDTO(
                bookTitle,author,publisher,publishedDate,regularPrice,discountRate
        );

        // when
        // then
        assertDoesNotThrow(
                () -> bookRegistService.registBook(newBook)
        );
    }

}
