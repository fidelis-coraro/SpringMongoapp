package com.guvi.springmongoapp.controller;

import com.guvi.springmongoapp.entity.Task;
import com.guvi.springmongoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tasks")
public class TaskController {
   // inject the service layer into controller layer

    @Autowired
    private TaskService service;

    // create api endpoint for adding a new task->POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
    return service.addTask(task);
}
    // create api endpoint for reteival of all task->GET
    @GetMapping
    public List<Task> getTask(){
    return service.findAllTask();
}
    //create api endpoint for reteiving of task by id->GET
    @GetMapping ("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return service.getTaskByTaskId(taskId);
    }
   // create api endpoint for reteiving of task by seviority
    @GetMapping ("/severity/{severity}")
    public List <Task> findTaskUsingSeverity(@PathVariable int severity){
        return service.getTaskBySeverity(severity);
    }

    // create api endpoint for reteiving of task by assignee->GET
    @GetMapping ("/assignee/{assignee}")
    public List <Task> findTaskUsingSeverity(@PathVariable String assignee){
        return service.getTaskByAssignee(assignee);
    }
//create api endpoint for update method->PUT
    @PutMapping
    public Task modifyTask(@RequestBody Task task){
    return service.updateTask(task);
    }
//create api endpoint for delete tesk by id->Delete mapping

    @DeleteMapping ("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
     return service.deleteTask(taskId);
    }
}
