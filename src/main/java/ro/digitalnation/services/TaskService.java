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
    private TaskRepository taskRepository; // Injectează TaskRepository

    public Iterator<Task> getAll() {
        return taskRepository.findAll().iterator(); // Returnează toate task-urile
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id); // Găsește task-ul după ID
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setCreatedAt(Instant.now()); // Setează data creării dacă ID-ul e null
        }
        task.setUpdatedAt(Instant.now()); // Setează data actualizării
        return taskRepository.save(task); // Salvează task-ul
    }

    public void delete(Task task) {
        taskRepository.delete(task); // Șterge task-ul
    }
}
