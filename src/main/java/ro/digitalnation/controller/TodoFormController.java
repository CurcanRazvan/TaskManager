package ro.digitalnation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println("Verificare functie!!!");
        model.addAttribute("todoItem", new TodoItem()); // Adaugă obiectul în model
        return "new-todo-item"; // Numele corect al template-ului
    }

    @PostMapping("/todo")
    public String createTask(@Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-todo-item"; // Numele corect al template-ului
        }

        todoService.save(todoItem);
        return "redirect:/";
    }
}
