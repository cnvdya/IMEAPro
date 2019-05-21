package edu.sjsu.ieptracker.controller;


import edu.sjsu.ieptracker.dto.GoalDto;
import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.service.GoalService;
import edu.sjsu.ieptracker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.sjsu.ieptracker.utils.IEPTrackerConstants.*;

@RequestMapping(path="/student")
@RestController
public class GoalController {


    @Autowired
    GoalService goalService;


    @RequestMapping(value=GET_GOALS_BY_STUDENT_ID, method= RequestMethod.GET)
    public List<GoalDto> getAllGoalsForStudent(@RequestParam Integer studentId) {
        return goalService.getAllGoalsForStudent(studentId);
    }

    @RequestMapping(value = SAVE_GOAL, method = RequestMethod.POST)
    public void saveGoal(@RequestBody GoalDto goalDto) {
        goalService.saveOrUpdate(goalDto);
    }


    @RequestMapping(value= GET_GOAL_BY_ID, method=RequestMethod.GET)
    public @ResponseBody
    GoalDto getGoalById(@RequestParam Integer goalId) {
        return  goalService.findByGoalId(goalId);
    }
}
