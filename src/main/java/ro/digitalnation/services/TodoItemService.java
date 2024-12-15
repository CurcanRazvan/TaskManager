package ro.digitalnation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.models.TodoItem;
import ro.digitalnation.repository.TodoItemRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository; // Injecteaza TaskRepository

    // Metoda trebuie să returneze un Iterable în loc de Iterator
    public List<TodoItem> getAll() {
        return todoItemRepository.findAll(); // Returneaza toate task-urile
    }

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id); // Gasește task-ul după ID
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now()); // Setează data crearii dacă ID-ul e null
        }
        todoItem.setUpdatedAt(Instant.now()); // Setează data actualizarii
        return todoItemRepository.save(todoItem); // Salveaza task-ul
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem); // Șterge task-ul
    }
}
