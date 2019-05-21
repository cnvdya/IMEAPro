package edu.sjsu.ieptracker.converter;

import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Student;

public class StudentConverter {

    public static Student dtoToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentID(studentDto.getStudentID());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setSchool(studentDto.getSchool());
        student.setDistrict(studentDto.getDistrict());
//        student.setParent(studentDto.getParent());
        student.setDob(studentDto.getDob());
        student.setGrade(studentDto.getGrade());
        student.setGender(studentDto.getGender());
        return student;
    }
    public static StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentID(student.getStudentID());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setSchool(student.getSchool());
        studentDto.setDistrict(student.getDistrict());
        //studentDto.setParent(student.getParent());
        studentDto.setDob(student.getDob());
        studentDto.setGrade(student.getGrade());
        studentDto.setGender(student.getGender());
        return studentDto;
    }
}
