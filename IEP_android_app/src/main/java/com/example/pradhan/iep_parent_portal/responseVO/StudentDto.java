package com.example.pradhan.iep_parent_portal.responseVO;

import java.util.List;

public class StudentDto {

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

}
