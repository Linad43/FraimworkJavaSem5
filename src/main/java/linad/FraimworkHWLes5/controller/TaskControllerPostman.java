package linad.FraimworkHWLes5.controller;

import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/tasks1")
@AllArgsConstructor
public class TaskControllerPostman {
    private final TaskService service;
    @GetMapping()
    public List<Task> getAllTasks(){
        return service.getAllTask();
    }
    @PostMapping("/tasks-add1")
    public void addTasks(Task task){
        service.addTask(task);
    }
    @GetMapping("/task_update1/{id}")
    public void changeStatus(@PathVariable("id") long id) {
        service.changeStatus(id);
    }
    @GetMapping("/task_delete1/{id}")
    public void deleteTask(@PathVariable("id") long id) {
        service.deleteTask(id);
    }
}
