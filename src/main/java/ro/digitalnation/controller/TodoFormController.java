package ro.digitalnation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import javax.validation.Valid;
import ro.digitalnation.models.TodoItem;
import ro.digitalnation.services.TodoItemService;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoService;

    @GetMapping("/create-todo")
    public String showCreateForm(Model model) {
        System.out.println("Navigating to create-todo page...");
        model.addAttribute("todoItem", new TodoItem());
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTask(@Valid TodoItem todoItem, BindingResult result, Model model) {
        System.out.println("Creating new todo item...");
        if (result.hasErrors()) {
            return "new-todo-item";
        }

        todoService.save(todoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        System.out.println("Deleting todo item with id: " + id);
        TodoItem todoItem = todoService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        todoService.delete(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        System.out.println("Navigating to edit-todo-item page with id: " + id);
        TodoItem todoItem = todoService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", todoItem);
        return "edit-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        System.out.println("Updating todo item with id: " + id);
        if (result.hasErrors()) {
            return "edit-todo-item";
        }

        TodoItem item = todoService
                .getById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        item.setIsComplete(todoItem.getIsComplete());
        item.setDescription(todoItem.getDescription());

        todoService.save(item);

        return "redirect:/";
    }
}
