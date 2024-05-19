package linad.FraimworkHWLes5.controller;

import linad.FraimworkHWLes5.aspect.LogAspect;
import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks_swagger")
@RequiredArgsConstructor
public class TaskControllerSwagger {
    private final TaskService service;
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTask(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@RequestBody long id){
        return new ResponseEntity<>(service.getTaskById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        /*service.addTask(task);
        return ResponseEntity.ok().build();*/
        return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> changeStatus(@RequestBody long id) {
        /*
        service.changeStatus(id);
        return ResponseEntity.ok().build();
        */
        return new ResponseEntity<>(service.changeStatus(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@RequestBody long id) {
        service.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
