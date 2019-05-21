package edu.sjsu.ieptracker.dto;

import edu.sjsu.ieptracker.entity.Guardian;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable{
    Integer studentID;
    String firstName;
    String lastName;
    String school;
    String district;
    String parent;
    String dob;
    String grade;
    String gender;
    List<GuardianDto> guardians;


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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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

    public List<GuardianDto> getGuardians() {
        return guardians;
    }

    public void setGuardians(List<GuardianDto> guardians) {
        this.guardians = guardians;
    }
}
