package edu.sjsu.ieptracker.dto;

import java.io.Serializable;
import java.util.List;

public class GoalDto implements Serializable {

    private int goalID;
    private String goalTitle;
    private String description;
    private String goalCategory;
    private String initialInstructionDate;
    private String completionDate;
    private String specificStimuli;
    private String attendingBehavior;
    private String prompts;
    private String responseCue;
    private String responsePrompts;
    private String correctionProcedures;
    private String reinforcement;
    private int studentID;
    private List<ObjectiveDto> objectiveDtoList;

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoalCategory() {
        return goalCategory;
    }

    public void setGoalCategory(String goalCategory) {
        this.goalCategory = goalCategory;
    }

    public String getInitialInstructionDate() {
        return initialInstructionDate;
    }

    public void setInitialInstructionDate(String initialInstructionDate) {
        this.initialInstructionDate = initialInstructionDate;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getSpecificStimuli() {
        return specificStimuli;
    }

    public void setSpecificStimuli(String specificStimuli) {
        this.specificStimuli = specificStimuli;
    }

    public String getAttendingBehavior() {
        return attendingBehavior;
    }

    public void setAttendingBehavior(String attendingBehavior) {
        this.attendingBehavior = attendingBehavior;
    }

    public String getPrompts() {
        return prompts;
    }

    public void setPrompts(String prompts) {
        this.prompts = prompts;
    }

    public String getResponseCue() {
        return responseCue;
    }

    public void setResponseCue(String responseCue) {
        this.responseCue = responseCue;
    }

    public String getResponsePrompts() {
        return responsePrompts;
    }

    public void setResponsePrompts(String responsePrompts) {
        this.responsePrompts = responsePrompts;
    }

    public String getCorrectionProcedures() {
        return correctionProcedures;
    }

    public void setCorrectionProcedures(String correctionProcedures) {
        this.correctionProcedures = correctionProcedures;
    }

    public String getReinforcement() {
        return reinforcement;
    }

    public void setReinforcement(String reinforcement) {
        this.reinforcement = reinforcement;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public List<ObjectiveDto> getObjectiveDtoList() {
        return objectiveDtoList;
    }

    public void setObjectiveDtoList(List<ObjectiveDto> objectiveDtoList) {
        this.objectiveDtoList = objectiveDtoList;
    }
}
