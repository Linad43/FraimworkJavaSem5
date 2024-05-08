package linad.FraimworkHWLes5.controller;

import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RestController
@Controller
@AllArgsConstructor
public class TaskController {
    private final TaskService service;
    @GetMapping("/tasks")
    public String getAllTasks(Model model){
        model.addAttribute("tasks", service.getAllTask());
        return "tasks";
    }
    @PostMapping("/tasks-add")
    public String addTasks(Task task, Model model){
        service.addTask(task);
        model.addAttribute("tasks", service.getAllTask());
        return "redirect:/tasks";
    }
    @GetMapping("/task_update/{id}")
    public String changeStatus(@PathVariable("id") long id) {
        service.changeStatus(id);
        return "redirect:/tasks";
    }
    @GetMapping("/task_delete/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        service.deleteTask(id);
        return "redirect:/tasks";
    }

}
