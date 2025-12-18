package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO{

    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl(){
        bookList = new HashMap<>();
        bookList.put(1,new BookDTO(1,12345,"자바의 정석","남궁민","도우출판사",new Date()));
        bookList.put(2,new BookDTO(2,22334,"초보 웹 개발자를 위한 스프링","최병균","가매출판사",new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectOneBook(int sequence) {
        return bookList.get(sequence);
    }
}
