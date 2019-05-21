package edu.sjsu.ieptracker.service;


import edu.sjsu.ieptracker.dao.GoalDAO;
import edu.sjsu.ieptracker.dao.StudentDAO;
import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Student;
import edu.sjsu.ieptracker.mapper.GoalMapper;
import edu.sjsu.ieptracker.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    @Autowired
    GoalDAO goalDAO;

    @Autowired
    GoalMapper goalMapper;

    public String saveOrUpdate(GoalDto goalDto) {
        Goal goal = goalMapper.mapToGoal(goalDto);
        return goalDAO.saveOrUpdate(goal);
    }

    public List<GoalDto> getAllGoalsForStudent(int studentID) {
        List<Goal> goals =  goalDAO.getAllGoalsForStudent(studentID);
        return goals.stream().map(goalMapper::mapToGoalDto).collect(Collectors.toList());
    }

    public GoalDto findByGoalId(int goalId) {
        return goalMapper.mapToGoalDto(goalDAO.findByGoalId(goalId));
    }
}
