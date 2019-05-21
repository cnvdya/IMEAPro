package edu.sjsu.ieptracker.controller;


import edu.sjsu.ieptracker.dto.ObjectiveDto;
import edu.sjsu.ieptracker.service.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edu.sjsu.ieptracker.utils.IEPTrackerConstants.GET_OBJECTIVES_BY_GOAL_ID;

@RequestMapping(path="/student")
@RestController
public class ObjectiveController {

    @Autowired
    ObjectiveService objectiveService;


    @RequestMapping(value=GET_OBJECTIVES_BY_GOAL_ID, method= RequestMethod.GET)
    public List<ObjectiveDto> getAllObjectivesForGoal(@RequestParam Integer goalId) {
        return objectiveService.getAllObjectivesForGoal(goalId);
    }
}
