package edu.sjsu.ieptracker.entity;

import javax.persistence.*;

@Entity
@Table (name="OBJECTIVE")
@NamedQueries({
        @NamedQuery(
                name = "findObjectiveById",
                query = "from Objective o where o.objectiveID = :id"
        ),
        @NamedQuery(
                name="findAllObjectivesForStudent",
                query = "from Objective o where o.student.studentID = :id"
        ),
        @NamedQuery(
                name="getObjectivesForGoalId",
                query = "from Objective o where o.goal.goalID = :id"
        ),
})

public class Objective {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int objectiveID;

    @Column(name = "objectiveDescription") private String objectiveDescription;
    @Column(name = "startDate") private String startDate;
    @Column(name = "completionDate") private String completionDate;
    @Column(name = "actualCompetionDate") private String actualCompetionDate;
    @Column(name = "isCompleted") private int isCompleted;
    @Column(name = "inProgress") private int inProgress;
    @Column(name = "notStarted") private int notStarted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentID")
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goalID")
    private Goal goal;

    public int getObjectiveID() {
        return objectiveID;
    }

    public void setObjectiveID(int objectiveID) {
        this.objectiveID = objectiveID;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
