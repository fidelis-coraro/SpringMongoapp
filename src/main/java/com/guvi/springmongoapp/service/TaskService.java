package com.guvi.springmongoapp.service;

import com.guvi.springmongoapp.entity.Task;
import com.guvi.springmongoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    // 1. add a new task to the db
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }
    // 2. fetch all task from db
    public List<Task> findAllTask() {
        return repository.findAll();
    }
    // 3. fetch single task with Id
    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    // 4. fetching of task based on severity
    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    // 5. fetching of task based on assignee
    public List<Task> getTaskByAssignee(String assignee) {
        return repository.getTaskByAssignee(assignee);
    }

    // 6. update the existing task in database
    public Task updateTask(Task taskRequest){
        Task existingTask= repository.findById(taskRequest.getTaskId()).get();
      //update the data using existingtask reference.
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
     // save the data back to db after update
        return repository.save(existingTask);
    }
    // 7. Delete -> delete task from the database ->Id
    public String deleteTask(String taskID){
        repository.deleteById(taskID);
        return taskID+ "Deleted succesfully from database ...";
    }

}
