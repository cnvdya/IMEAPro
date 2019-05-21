package edu.sjsu.ieptracker.service;


import edu.sjsu.ieptracker.dao.GoalDAO;
import edu.sjsu.ieptracker.dao.ObjectiveDAO;
import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.mapper.GoalMapper;
import edu.sjsu.ieptracker.mapper.ObjectiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectiveService {

    @Autowired
    ObjectiveDAO objectiveDAO;

    @Autowired
    ObjectiveMapper objectiveMapper;


    public List<ObjectiveDto> getAllObjectivesForGoal(int goalID) {
        List<Objective> objectives =  objectiveDAO.getAllObjectivesForGoal(goalID);
        return objectives.stream().map(objectiveMapper::mapToDto).collect(Collectors.toList());
    }
}
