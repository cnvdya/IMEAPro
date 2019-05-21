package edu.sjsu.ieptracker.mapper;


import edu.sjsu.ieptracker.dao.StudentDAO;
import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.GuardianDto;
import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Objective;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoalMapper {

    @Autowired
    ObjectiveMapper objectiveMapper;

    @Autowired
    StudentDAO studentDAO;

    public Goal mapToGoal(GoalDto goalDto){
        Goal goal = new Goal();

        goal.setGoalID(goalDto.getGoalID());
        goal.setGoalTitle(goalDto.getGoalTitle());
        goal.setDescription(goalDto.getDescription());
        goal.setGoalCategory(goalDto.getGoalCategory());
        goal.setInitialInstructionDate(goalDto.getInitialInstructionDate());
        goal.setCompletionDate(goalDto.getCompletionDate());
        goal.setSpecificStimuli(goalDto.getSpecificStimuli());
        goal.setAttendingBehavior(goalDto.getAttendingBehavior());
        goal.setPrompts(goalDto.getPrompts());
        goal.setResponseCue(goalDto.getResponseCue());
        goal.setResponsePrompts(goalDto.getResponsePrompts());
        goal.setCorrectionProcedures(goalDto.getCorrectionProcedures());
        goal.setReinforcement(goalDto.getReinforcement());
        goal.setStudentID(goalDto.getStudentID());
        List<Objective> objectives = new ArrayList<>();
        goalDto.getObjectiveDtoList().forEach(objectiveDto->{
            Objective objective = objectiveMapper.mapToObjective(objectiveDto);
            objective.setGoal(goal);
            try {
                objective.setStudent(studentDAO.findById(goalDto.getStudentID()));
            }catch (Exception ex){
                //Do nothing
            }

            objectives.add(objective);
        });

        goal.setObjectives(objectives);

        return goal;
    }


    public  GoalDto mapToGoalDto(Goal goal) {
        GoalDto goalDto = new GoalDto();


        goalDto.setGoalID(goal.getGoalID());
        goalDto.setGoalTitle(goal.getGoalTitle());
        goalDto.setDescription(goal.getDescription());
        goalDto.setGoalCategory(goal.getGoalCategory());
        goalDto.setInitialInstructionDate(goal.getInitialInstructionDate());
        goalDto.setCompletionDate(goal.getCompletionDate());
        goalDto.setSpecificStimuli(goal.getSpecificStimuli());
        goalDto.setAttendingBehavior(goal.getAttendingBehavior());
        goalDto.setPrompts(goal.getPrompts());
        goalDto.setResponseCue(goal.getResponseCue());
        goalDto.setResponsePrompts(goal.getResponsePrompts());
        goalDto.setCorrectionProcedures(goal.getCorrectionProcedures());
        goalDto.setReinforcement(goal.getReinforcement());
        goalDto.setStudentID(goal.getStudentID());

        List<Objective> objectives = goal.getObjectives();

        List<ObjectiveDto> objectiveDtos = objectives.stream().map(objectiveMapper::mapToDto).collect(Collectors.toList());
        goalDto.setObjectiveDtoList(objectiveDtos);

        return goalDto;
    }
}
