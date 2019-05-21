package edu.sjsu.ieptracker.service;

import edu.sjsu.ieptracker.converter.StudentConverter;
import edu.sjsu.ieptracker.dao.StudentDAO;
import edu.sjsu.ieptracker.dto.GuardianDto;
import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Student;
import edu.sjsu.ieptracker.mapper.GuardianMapper;
import edu.sjsu.ieptracker.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    GuardianMapper guardianMapper;

    public StudentDto findById(int studentId) {
        return studentMapper.mapToStudentDto(studentDAO.findById(studentId));
    }

    public String saveOrUpdate(StudentDto studentDto) {
        Student student = studentMapper.mapToStudent(studentDto);



        return studentDAO.saveOrUpdate(student);
    }

    public List<GuardianDto> findGuardiansById(Integer studentId) {
      List<Guardian> guardians = studentDAO.findGuardiansById(studentId);
        return guardians.stream().map(guardianMapper::mapToDto).collect(Collectors.toList());
    }


    public List<StudentDto> getAllStudents() {
        List<Student> students =  studentDAO.getAllStudent();
        return students.stream().map(studentMapper::mapToStudentDto).collect(Collectors.toList());
    }

}
