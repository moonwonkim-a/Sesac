package com.ohgiraffers.section01.autowired.constructor;


import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("constructorBookService")
public class BookService {

    private final BookDAO bookDAO;

    /* 생성자 주입 (가장 권장하는 방식)
    * BookDAO 타입의 빈(bean)객체를 생성자에 자동으로 주입
    * 생성자가 단 한 개 뿐이라면 어노테이션을 생략해도 자동으로 생성자 주입이 동작한다.
    * */
    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence){
        return bookDAO.selectOneBook(sequence);
    }
}
