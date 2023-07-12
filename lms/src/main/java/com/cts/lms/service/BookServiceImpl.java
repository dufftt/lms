package com.cts.lms.service;

import com.cts.lms.model.Book;
import com.cts.lms.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@EnableScheduling
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    public BookRepository repo;


    @Override
    public String addBook(Book book) {
        repo.save(book);
        return "added successfully";
    }

    @Override
    public String updateBook(int id, String title, String author, int publicationyear, int quantity) {
        Book req = repo.findById(id).get();
        req.setAuthor(author);
        req.setTitle(title);
        req.setQuantity(quantity);
        req.setPublicationyear(publicationyear);
        repo.save(req);
        return "updated";
    }

    @Override
    public String deleteBook(Book book) {
        repo.deleteById(book.getId());
        return "deleted";
    }

    @Override
    public List<Book> getAllBook() {
        return repo.findAll();
    }

    @Override
    @Scheduled(fixedRate = 1000)
    public String InvenCheck() {
        List<Book> books = repo.findAll();
        if(books.size()<10){
            return "Warning: Book is very less";
        }else{
            return "Everything ok";
        }


    }


    @Override
    @PreDestroy
    public String finalcheck() {
        return InvenCheck();
    }

    @Override
    @PostConstruct
    public String firstcheck() {
        return InvenCheck();
    }
}
