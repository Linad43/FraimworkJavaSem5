package linad.FraimworkHWLes5.controller;

import linad.FraimworkHWLes5.aspect.LogAspect;
import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/tasks_postman")
@AllArgsConstructor
public class TaskControllerPostman {
    private final TaskService service;
    @GetMapping()
    public List<Task> getAllTasks(){
        return service.getAllTask();
    }
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") long id){
        return service.getTaskById(id);
    }
    @PostMapping()
    public void addTask(Task task){
        service.addTask(task);
    }
    @PutMapping("/{id}")
    public Task changeStatus(@PathVariable("id") long id) {
        service.changeStatus(id);
        return service.getTaskById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable("id") long id) {
        service.deleteTask(id);
    }
}
