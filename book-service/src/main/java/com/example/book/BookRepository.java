package com.example.book;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookRepository {

    @PersistenceContext(unitName = "bookPU")
    private EntityManager em;

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class)
                 .getResultList();
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public Book create(Book book) {
        em.persist(book);
        return book;
    }

    public Book update(Long id, Book data) {
        Book existing = em.find(Book.class, id);
        if (existing == null) {
            return null;
        }
        existing.setTitle(data.getTitle());
        existing.setAuthor(data.getAuthor());
        return existing;
    }

    public boolean delete(Long id) {
        Book existing = em.find(Book.class, id);
        if (existing == null) {
            return false;
        }
        em.remove(existing);
        return true;
    }
}
