package edu.sjsu.ieptracker.service;

import edu.sjsu.ieptracker.dao.EvaluationDAO;
import edu.sjsu.ieptracker.dao.ObjectiveDAO;
import edu.sjsu.ieptracker.dao.TaskDAO;
import edu.sjsu.ieptracker.dto.EvaluationDto;
import edu.sjsu.ieptracker.dto.TaskDto;
import edu.sjsu.ieptracker.entity.Evaluation;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.entity.Task;
import edu.sjsu.ieptracker.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    @Autowired
    EvaluationDAO evaluationDAO;

    @Autowired
    TaskDAO taskDAO;

    @Autowired
    ObjectiveDAO objectiveDAO;

    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    SentimentAnalysis sentimentAnalysis;


    public List<EvaluationDto> getAllEvaluationsForTask(int taskID) {
        List<Evaluation> evaluations =  evaluationDAO.getAllEvaluationsForTask(taskID);
        return evaluations.stream().map(evaluationMapper::mapToDto).collect(Collectors.toList());
    }

    public String saveOrUpdate(EvaluationDto evaluationDto) {

        evaluationDto=sentimentAnalysis.detectSentiment(evaluationDto);
        Evaluation evaluation = evaluationMapper.mapToEvaluation(evaluationDto);

        Task task = evaluation.getTask();
//        task.setTaskID(100);
        Objective objective = evaluation.getObjective();

        if(evaluation.getPassed()==0){
            task=makeTaskInProgress(task);
            objective=makeObjectiveInProgress(objective);
        }

        if(evaluation.getPassed()==1){

            task.setEvaluationCompleted(task.getEvaluationCompleted()+1);

            if(task.getEvaluationTotal()>task.getEvaluationCompleted()){
                task=makeTaskInProgress(task);
                objective=makeObjectiveInProgress(objective);
            }
            else if(task.getEvaluationTotal()==task.getEvaluationCompleted()){
                task=makeTaskCompleted(task);
                task.setActualCompetionDate(evaluation.getEvaluationDate());

                objective=makeObjectiveCompleted(objective);
                objective.setActualCompetionDate(task.getActualCompetionDate());
            }

        }

        evaluation.setTask(task);
        evaluation.setObjective(objective);

        objectiveDAO.saveOrUpdate(objective);

        taskDAO.saveOrUpdate(task);


        return evaluationDAO.saveOrUpdate(evaluation);
    }

    private Task makeTaskInProgress(Task task){
        task.setInProgress(1);
        task.setIsCompleted(0);
        task.setNotStarted(0);
        return task;
    }

    private Task makeTaskCompleted(Task task){
        task.setInProgress(0);
        task.setIsCompleted(1);
        task.setNotStarted(0);
        return task;
    }

    private Objective makeObjectiveInProgress(Objective objective){
        objective.setInProgress(1);
        objective.setIsCompleted(0);
        objective.setNotStarted(0);
        return objective;
    }

    private Objective makeObjectiveCompleted(Objective objective){
        objective.setInProgress(0);
        objective.setIsCompleted(1);
        objective.setNotStarted(0);
        return objective;
    }
}
