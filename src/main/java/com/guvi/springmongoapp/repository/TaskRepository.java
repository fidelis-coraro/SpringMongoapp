package com.guvi.springmongoapp.repository;

import com.guvi.springmongoapp.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task,String> {
  //spring automatically method
    List<Task> findBySeverity(int severity);

  //custom method->assignee name
    @Query("{assignee:?0}")
    List<Task> getTaskByAssignee(String assignee);
}
