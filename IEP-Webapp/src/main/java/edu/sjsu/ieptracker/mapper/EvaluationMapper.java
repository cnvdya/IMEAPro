package edu.sjsu.ieptracker.mapper;


import edu.sjsu.ieptracker.dao.GoalDAO;
import edu.sjsu.ieptracker.dao.ObjectiveDAO;
import edu.sjsu.ieptracker.dao.StudentDAO;
import edu.sjsu.ieptracker.dao.TaskDAO;
import edu.sjsu.ieptracker.dto.EvaluationDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EvaluationMapper {


    @Autowired
    TaskMapper taskMapper;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    GoalDAO goalDAO;

    @Autowired
    TaskDAO taskDAO;



    public EvaluationDto mapToDto(Evaluation evaluation) {

        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setEvaluationID(evaluation.getEvaluationID());
        evaluationDto.setEvaluationDate(evaluation.getEvaluationDate());
        evaluationDto.setComments(evaluation.getComments());
        evaluationDto.setStrategyUsed(evaluation.getStrategyUsed());
        evaluationDto.setPositiveScore(evaluation.getPositiveScore());
        evaluationDto.setNegativeScore(evaluation.getNegativeScore());
        evaluationDto.setAverageScore(evaluation.getAverageScore());
        evaluationDto.setPassed(evaluation.getPassed());
        evaluationDto.setTaskID(evaluation.getTask().getTaskID());
        evaluationDto.setObjectiveID(evaluation.getObjective().getObjectiveID());
        evaluationDto.setGoalID(evaluation.getGoal().getGoalID());
        evaluationDto.setStudentID(evaluation.getStudent().getStudentID());
        return evaluationDto;

    }

    public Evaluation mapToEvaluation(EvaluationDto evaluationDto) {
        Evaluation evaluation = new Evaluation();
        evaluation.setEvaluationID(evaluationDto.getEvaluationID());
        evaluation.setEvaluationDate(evaluationDto.getEvaluationDate());
        evaluation.setComments(evaluationDto.getComments());
        evaluation.setStrategyUsed(evaluationDto.getStrategyUsed());
        evaluation.setPositiveScore(evaluationDto.getPositiveScore());
        evaluation.setNegativeScore(evaluationDto.getNegativeScore());
        evaluation.setAverageScore(evaluationDto.getAverageScore());
        evaluation.setPassed(evaluationDto.getPassed());

        Task task = taskDAO.findById(evaluationDto.getTaskID());
        evaluation.setTask(task);
        evaluation.setObjective(task.getObjective());
        evaluation.setGoal(task.getGoal());
        evaluation.setStudent(task.getStudent());
        return evaluation;

    }

}
