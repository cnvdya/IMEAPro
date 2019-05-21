package edu.sjsu.ieptracker.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="EVALUATION")
@NamedQueries({
        @NamedQuery(
                name = "findEvaluationById",
                query = "from Evaluation e where e.evaluationID = :id"
        ),
        @NamedQuery(
                name = "findEvaluationByTaskId",
                query = "from Evaluation e where e.task.taskID = :id"
        ),
        @NamedQuery(
                name = "findEvaluationByObjectiveId",
                query = "from Evaluation e where e.objective.objectiveID = :id"
        ),
        @NamedQuery(
                name = "findEvaluationByGoalId",
                query = "from Evaluation e where e.goal.goalID = :id"
        ),
        @NamedQuery(
                name = "findAllevaluationForStudent",
                query = "from Evaluation e where e.student.studentID = :id"
        ),
})
public class Evaluation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int evaluationID;

    @Column(name = "evaluationDate") private String evaluationDate;
    @Column(name = "comments") private String comments;
    @Column(name = "strategyUsed") private String strategyUsed;
    @Column(name = "positiveScore") private String positiveScore;
    @Column(name = "negativeScore") private String negativeScore;
    @Column(name = "averageScore") private String averageScore;
    @Column(name = "passed") private int passed;


    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "taskID")
    private Task task;

    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "objectiveID")
    private Objective objective;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goalID")
    private Goal goal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentID")
    private Student student;

    public int getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(int evaluationID) {
        this.evaluationID = evaluationID;
    }

    public String getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStrategyUsed() {
        return strategyUsed;
    }

    public void setStrategyUsed(String strategyUsed) {
        this.strategyUsed = strategyUsed;
    }

    public String getPositiveScore() {
        return positiveScore;
    }

    public void setPositiveScore(String positiveScore) {
        this.positiveScore = positiveScore;
    }

    public String getNegativeScore() {
        return negativeScore;
    }

    public void setNegativeScore(String negativeScore) {
        this.negativeScore = negativeScore;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
