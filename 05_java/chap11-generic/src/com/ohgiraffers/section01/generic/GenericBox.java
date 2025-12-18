package com.ohgiraffers.section01.generic;

public class GenericBox<T> {

    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}
