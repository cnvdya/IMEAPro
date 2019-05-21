package edu.sjsu.ieptracker.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STUDENT")
@NamedQueries({
        @NamedQuery(
                name = "findStudentById",
                query = "from Student s where s.studentID = :id"
        ),
        @NamedQuery(
                name="findAllStudents",
                query = "from Student"
        )
})
public class Student {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer studentID;

    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String school;
    @Column
    String district;
    @Column
    String dob;
    @Column
    String grade;
    @Column
    String gender;
    @Column
    String startDate;
    @Column
    String specialEdEntryDate;
    @Column
    String currentIEPStartDate;
    @Column
    String nextAnnualIEPDate;
    @Column
    String lastEvaluationDate;
    @Column
    String nextEvaluationDate;

    public List<Guardian> getGuardians() {
        return guardians;
    }

    public void setGuardians(List<Guardian> guardians) {
        this.guardians = guardians;
    }

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "studentID")
    private List<Guardian> guardians =new ArrayList<>();



    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSpecialEdEntryDate() {
        return specialEdEntryDate;
    }

    public void setSpecialEdEntryDate(String specialEdEntryDate) {
        this.specialEdEntryDate = specialEdEntryDate;
    }

    public String getCurrentIEPStartDate() {
        return currentIEPStartDate;
    }

    public void setCurrentIEPStartDate(String currentIEPStartDate) {
        this.currentIEPStartDate = currentIEPStartDate;
    }

    public String getNextAnnualIEPDate() {
        return nextAnnualIEPDate;
    }

    public void setNextAnnualIEPDate(String nextAnnualIEPDate) {
        this.nextAnnualIEPDate = nextAnnualIEPDate;
    }

    public String getLastEvaluationDate() {
        return lastEvaluationDate;
    }

    public void setLastEvaluationDate(String lastEvaluationDate) {
        this.lastEvaluationDate = lastEvaluationDate;
    }

    public String getNextEvaluationDate() {
        return nextEvaluationDate;
    }

    public void setNextEvaluationDate(String nextEvaluationDate) {
        this.nextEvaluationDate = nextEvaluationDate;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}
