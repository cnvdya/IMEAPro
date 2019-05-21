package edu.sjsu.ieptracker.mapper;



import edu.sjsu.ieptracker.dao.GoalDAO;
import edu.sjsu.ieptracker.dao.ObjectiveDAO;
import edu.sjsu.ieptracker.dao.StudentDAO;
import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    GoalDAO goalDAO;

    @Autowired
    ObjectiveDAO objectiveDAO;


    public TaskDto mapToDto(Task task) {

        TaskDto taskDto = new TaskDto();
        taskDto.setTaskID(task.getTaskID());
        taskDto.setTaskDescription(task.getTaskDescription());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setCompletionDate(task.getCompletionDate());
        taskDto.setActualCompetionDate(task.getActualCompetionDate());
        taskDto.setIsCompleted(task.getIsCompleted());
        taskDto.setInProgress(task.getInProgress());
        taskDto.setNotStarted(task.getNotStarted());
        taskDto.setEvaluationTotal(task.getEvaluationTotal());
        taskDto.setEvaluationCompleted(task.getEvaluationCompleted());
        taskDto.setStudentID(task.getGoal().getStudentID());
        taskDto.setObjectiveID(task.getObjective().getObjectiveID());
        taskDto.setGoalID(task.getGoal().getGoalID());

        return taskDto;

    }

    public Task mapToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTaskID(taskDto.getTaskID());
        task.setTaskDescription(taskDto.getTaskDescription());
        task.setStartDate(taskDto.getStartDate());
        task.setCompletionDate(taskDto.getCompletionDate());
        task.setActualCompetionDate(taskDto.getActualCompetionDate());
        task.setIsCompleted(taskDto.getIsCompleted());
        task.setInProgress(taskDto.getInProgress());
        task.setNotStarted(taskDto.getNotStarted());
        task.setEvaluationTotal(taskDto.getEvaluationTotal());
        task.setEvaluationCompleted(taskDto.getEvaluationCompleted());
        Goal goal = goalDAO.findByGoalId(taskDto.getGoalID());
        task.setGoal(goal);
        task.setStudent(studentDAO.findById(goal.getStudentID()));
        task.setObjective(objectiveDAO.findObjectiveById(taskDto.getObjectiveID()));

        return task;

    }

}
