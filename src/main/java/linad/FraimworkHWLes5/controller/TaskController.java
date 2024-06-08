package linad.FraimworkHWLes5.controller;

import linad.FraimworkHWLes5.aspect.LogAspect;
import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.service.FileGateWay;
import linad.FraimworkHWLes5.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@EnableAspectJAutoProxy
public class TaskController {
    private final TaskService service;
    private final FileGateWay fileGateWay;

    @Bean
    public LogAspect getLogAspect() {
        return new LogAspect();
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", service.getAllTask());
        return "tasks";
    }

    @PostMapping("/tasks-add")
    public String addTasks(Task task, Model model) {
        service.addTask(task);
        fileGateWay.writeToFile(task.getName() + ".txt", task.toString());
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
