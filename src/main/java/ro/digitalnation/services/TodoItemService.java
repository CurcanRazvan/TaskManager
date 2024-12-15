package ro.digitalnation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.models.TodoItem;
import ro.digitalnation.repository.TodoItemRepository;

import java.time.Instant;
import java.util.Iterator;
import java.util.Optional;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository; //Injecteaza TaskRepository

    public Iterator<TodoItem> getAll() {
        return todoItemRepository.findAll().iterator(); //Returneaza toate taskurile
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id); //Gaseste taskul dupa ID
    }

    public TodoItem save(TodoItem todoItem) {
         if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now()); //Seteaza data crearii dacă ID-ul e null
        }
        todoItem.setUpdatedAt(Instant.now()); // Seteaza data actualizarii
        return todoItemRepository.save(todoItem); // Salveaza taskul
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem); // Șterge taskul
    }
}
