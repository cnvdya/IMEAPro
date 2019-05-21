package edu.sjsu.ieptracker.controller;


import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.service.GoalService;
import edu.sjsu.ieptracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.sjsu.ieptracker.utils.IEPTrackerConstants.*;

@RequestMapping(path="/student")
@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(value = SAVE_TASK, method = RequestMethod.POST)
    public void saveGoal(@RequestBody TaskDto taskDto) {
        taskService.saveOrUpdate(taskDto);
    }

    @RequestMapping(value=GET_TASKS_BY_GOAL_ID, method= RequestMethod.GET)
    public List<TaskDto> getAllTasksForGoal(@RequestParam Integer goalId) {
        return taskService.getAllTasksForGoal(goalId);
    }

    @RequestMapping(value=GET_TASKS_BY_ID, method= RequestMethod.GET)
    public TaskDto getTaskByID(@RequestParam Integer taskID) {
        return taskService.getTaskByID(taskID);
    }
}
