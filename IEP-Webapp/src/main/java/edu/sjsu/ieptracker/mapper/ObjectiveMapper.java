package edu.sjsu.ieptracker.mapper;


import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectiveMapper {




    public ObjectiveDto mapToDto(Objective objective) {

        ObjectiveDto objectiveDto = new ObjectiveDto();
        objectiveDto.setObjectiveID(objective.getObjectiveID());
        objectiveDto.setObjectiveDescription(objective.getObjectiveDescription());
        objectiveDto.setStartDate(objective.getStartDate());
        objectiveDto.setCompletionDate(objective.getCompletionDate());
        objectiveDto.setActualCompetionDate(objective.getActualCompetionDate());
        objectiveDto.setIsCompleted(objective.getIsCompleted());
        objectiveDto.setInProgress(objective.getInProgress());
        objectiveDto.setNotStarted(objective.getNotStarted());
        objectiveDto.setStudentID(objective.getStudent().getStudentID());
        objectiveDto.setGoalID(objective.getGoal().getGoalID());
        //task list
        return objectiveDto;

    }

    public Objective mapToObjective(ObjectiveDto objectiveDto) {
        Objective objective = new Objective();
        objective.setObjectiveID(objectiveDto.getObjectiveID());
        objective.setObjectiveDescription(objectiveDto.getObjectiveDescription());
        objective.setStartDate(objectiveDto.getStartDate());
        objective.setCompletionDate(objectiveDto.getCompletionDate());
        objective.setActualCompetionDate(objectiveDto.getActualCompetionDate());
        objective.setIsCompleted(objectiveDto.getIsCompleted());
        objective.setInProgress(objectiveDto.getInProgress());
        objective.setNotStarted(objectiveDto.getNotStarted());
//        objective.setStudentID(objectiveDto.getStudent().getStudentID());
//        objective.setGoalID(objectiveDto.getGoal().getGoalID());
        return objective;

    }
}
