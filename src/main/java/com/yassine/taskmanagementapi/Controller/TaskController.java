package com.yassine.taskmanagementapi.Controller;

import com.yassine.taskmanagementapi.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {

        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Lebenslauf aktualisieren");
        task1.setDescription("Neue Projekte hinzufügen");
        task1.setStatus("OPEN");
        task1.setDueDate("2026-10-10");

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Bewerbung senden");
        task2.setDescription("Bewerbung für Junior Java Developer senden");
        task2.setStatus("DONE");
        task2.setDueDate("2026-10-12");

        tasks.add(task1);
        tasks.add(task2);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {

        for (Task task : tasks) {

            if (task.getId().equals(id)) {
                return task;
            }
        }

        return null;
    }
}