package edu.sjsu.ieptracker.entity;

import javax.persistence.*;

@Entity
@Table(name="TASKS")
@NamedQueries({
        @NamedQuery(
                name = "findTaskById",
                query = "from Task t where t.taskID = :id"
        ),
        @NamedQuery(
                name = "findTaskByObjectiveId",
                query = "from Task t where t.objective.objectiveID = :id"
        ),
        @NamedQuery(
                name = "findTaskByGoalId",
                query = "from Task t where t.goal.goalID = :id"
        ),
        @NamedQuery(
                name = "findAllTasksForStudent",
                query = "from Task t where t.student.studentID = :id"
        ),
})

public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int taskID;

    @Column(name = "taskDescription") private String taskDescription;
    @Column(name = "startDate") private String startDate;
    @Column(name = "completionDate") private String completionDate;
    @Column(name = "actualCompetionDate") private String actualCompetionDate;
    @Column(name = "isCompleted") private int isCompleted;
    @Column(name = "inProgress") private int inProgress;
    @Column(name = "notStarted") private int notStarted;
    @Column(name = "evaluationTotal") private int evaluationTotal;
    @Column(name = "evaluationCompleted") private int evaluationCompleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "objectiveID")
    private Objective objective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goalID")
    private Goal goal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentID")
    private Student student;

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

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
