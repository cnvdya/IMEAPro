package com.example.pradhan.iep_parent_portal.responseVO;

import java.util.List;

public class TaskDto {

    private int taskID;
    private String taskDescription;
    private String startDate;
    private String completionDate;
    private String actualCompetionDate;
    private int isCompleted;
    private int inProgress;
    private int notStarted;
    private int evaluationTotal;
    private int evaluationCompleted;
    private int studentID;
    private int objectiveID;
    private int goalID;
    private List<EvaluationDto> evaluationDtoList;

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getActualCompetionDate() {
        return actualCompetionDate;
    }

    public void setActualCompetionDate(String actualCompetionDate) {
        this.actualCompetionDate = actualCompetionDate;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

    public int getInProgress() {
        return inProgress;
    }

    public void setInProgress(int inProgress) {
        this.inProgress = inProgress;
    }

    public int getNotStarted() {
        return notStarted;
    }

    public void setNotStarted(int notStarted) {
        this.notStarted = notStarted;
    }

    public int getEvaluationTotal() {
        return evaluationTotal;
    }

    public void setEvaluationTotal(int evaluationTotal) {
        this.evaluationTotal = evaluationTotal;
    }

    public int getEvaluationCompleted() {
        return evaluationCompleted;
    }

    public void setEvaluationCompleted(int evaluationCompleted) {
        this.evaluationCompleted = evaluationCompleted;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getObjectiveID() {
        return objectiveID;
    }

    public void setObjectiveID(int objectiveID) {
        this.objectiveID = objectiveID;
    }

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public List<EvaluationDto> getEvaluationDtoList() {
        return evaluationDtoList;
    }

    public void setEvaluationDtoList(List<EvaluationDto> evaluationDtoList) {
        this.evaluationDtoList = evaluationDtoList;
    }
}
