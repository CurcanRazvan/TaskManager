package ro.digitalnation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.digitalnation.models.TodoItem;
import ro.digitalnation.services.TodoItemService;

import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TodoRestController {

    @Autowired
    private TodoItemService todoService;

    @GetMapping
    public Iterable<TodoItem> getAllTasks() {
        return todoService.getAll();
    }

    @PostMapping
    public TodoItem createTask(@RequestBody TodoItem todoItem) {
        return todoService.save(todoItem);
    }

    @GetMapping("/{id}")
    public Optional<TodoItem> getTaskById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @PutMapping("/{id}")
    public Optional<TodoItem> updateTask(@PathVariable Long id, @RequestBody TodoItem taskDetails) {
        return todoService.getById(id).map(task -> {
            task.setDescription(taskDetails.getDescription());
            task.setIsComplete(taskDetails.getIsComplete());
            return todoService.save(task);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        todoService.getById(id).ifPresent(todoService::delete);
    }
}
