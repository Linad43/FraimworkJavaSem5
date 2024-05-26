package linad.FraimworkHWLes5.service;

import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.repos.TaskRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepos repos;

    /**
     * Добавление задачи
     * @param task
     */
    public Task addTask(Task task){
        return repos.save(task);
    }

    /**
     * Просмотр всех задач
     * @return
     */
    public List<Task> getAllTask(){
        return repos.findAll();
    }

    /**
     * Просмотр задачи по id
     * @param id
     * @return
     */
    public Task getTaskById(Long id){
        return repos.getReferenceById(id);
    }

    /**
     * Изменение статуса по id
     * @param id
     */

    public Task changeStatus(Long id){
        Optional<Task> optionalTask = repos.findById(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setStatus(!task.isStatus());
            repos.save(task);
            return task;
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * Удаление задачи
     * @param id
     */
    public void deleteTask(Long id){
        repos.deleteById(id);
    }
}
