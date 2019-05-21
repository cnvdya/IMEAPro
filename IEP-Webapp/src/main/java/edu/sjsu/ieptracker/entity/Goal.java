package edu.sjsu.ieptracker.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="GOAL")
@NamedQueries({
        @NamedQuery(
                name = "findGoalById",
                query = "from Goal g where g.goalID = :id"
        ),
        @NamedQuery(
                name="findAllGoalsForStudent",
                query = "from Goal g where g.studentID = :id"
        )
})
public class Goal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int goalID;

    @Column(name = "goalTitle") private String goalTitle;
    @Column(name = "description") private String description;
    @Column(name = "goalCategory") private String goalCategory;
    @Column(name = "initialInstructionDate") private String initialInstructionDate;
    @Column(name = "completionDate") private String completionDate;
    @Column(name = "specificStimuli") private String specificStimuli;
    @Column(name = "attendingBehavior") private String attendingBehavior;
    @Column(name = "prompts") private String prompts;
    @Column(name = "responseCue") private String responseCue;
    @Column(name = "responsePrompts") private String responsePrompts;
    @Column(name = "correctionProcedures") private String correctionProcedures;
    @Column(name = "reinforcement") private String reinforcement;
    @Column(name = "studentID") private int studentID;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "goalID")
    private List<Objective> objectives =new ArrayList<>();


    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

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
}
