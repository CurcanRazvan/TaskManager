package ro.digitalnation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.digitalnation.models.Task;
import ro.digitalnation.repository.TaskRepository;

import java.time.Instant;
import java.util.Iterator;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository; //Injecteaza TaskRepository

    public Iterator<Task> getAll() {
        return taskRepository.findAll().iterator(); //Returneaza toate taskurile
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id); //Gaseste taskul dupa ID
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setCreatedAt(Instant.now()); //Seteaza data crearii dacă ID-ul e null
        }
        task.setUpdatedAt(Instant.now()); // Seteaza data actualizarii
        return taskRepository.save(task); // Salveaza taskul
    }

    public void delete(Task task) {
        taskRepository.delete(task); // Șterge taskul
    }
}
