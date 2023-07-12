package com.cts.lms.service;

import com.cts.lms.model.Book;

import java.util.List;

public interface BookService {

    public String addBook(Book book);

    public String updateBook(int id, String title, String author, int publicationyear, int quantity);

    public String deleteBook(Book book);

    public List<Book> getAllBook();

    public String InvenCheck();

    public String finalcheck();

    public String firstcheck();
}
