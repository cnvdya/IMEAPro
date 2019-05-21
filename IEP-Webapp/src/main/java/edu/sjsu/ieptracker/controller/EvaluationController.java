package edu.sjsu.ieptracker.controller;

import edu.sjsu.ieptracker.dao.EvaluationDAO;
import edu.sjsu.ieptracker.dto.EvaluationDto;
import edu.sjsu.ieptracker.dto.MessageDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.Evaluation;
import edu.sjsu.ieptracker.mapper.EvaluationMapper;
import edu.sjsu.ieptracker.service.EvaluationService;
import edu.sjsu.ieptracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.sjsu.ieptracker.utils.IEPTrackerConstants.*;

@RequestMapping(path="/student")
@RestController
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;

    @RequestMapping(value = SAVE_EVALUATION, method = RequestMethod.POST)
    public MessageDto saveEvaluation(@RequestBody EvaluationDto evaluationDto) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(evaluationService.saveOrUpdate(evaluationDto));
        return messageDto;
    }

    @RequestMapping(value=GET_EVALUATIONS_BY_TASK_ID, method= RequestMethod.GET)
    public List<EvaluationDto> getAllEvaluationsForTask(@RequestParam Integer taskID) {
        return evaluationService.getAllEvaluationsForTask(taskID);
    }




}
