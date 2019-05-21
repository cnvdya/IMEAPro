package edu.sjsu.ieptracker.service;

import edu.sjsu.ieptracker.dao.GoalDAO;
import edu.sjsu.ieptracker.dao.TaskDAO;
import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.entity.Task;
import edu.sjsu.ieptracker.mapper.GoalMapper;
import edu.sjsu.ieptracker.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    TaskDAO taskDAO;

    @Autowired
    TaskMapper taskMapper;

    public String saveOrUpdate(TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        return taskDAO.saveOrUpdate(task);
    }

    public List<TaskDto> getAllTasksForGoal(int goalID) {
        List<Task> tasks =  taskDAO.getAllTasksForGoal(goalID);
        return tasks.stream().map(taskMapper::mapToDto).collect(Collectors.toList());
    }

    public TaskDto getTaskByID(int taskID) {
        return taskMapper.mapToDto(taskDAO.findById(taskID));
    }


}
