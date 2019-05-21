package edu.sjsu.ieptracker.mapper;

import edu.sjsu.ieptracker.dto.GuardianDto;
import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {
    @Autowired
    GuardianMapper guardianMapper;

    public Student mapToStudent(StudentDto studentDto){
        Student student = new Student();
        student.setStudentID(studentDto.getStudentID());
        student.setGender(studentDto.getGender());
        student.setGrade(studentDto.getGrade());
        student.setDob(studentDto.getDob());
        student.setLastName(studentDto.getLastName());
        student.setFirstName(studentDto.getFirstName());
        student.setDistrict(studentDto.getDistrict());
        student.setSchool(studentDto.getSchool());

        List<Guardian> guardians = new ArrayList<>();
        studentDto.getGuardians().forEach(guardiandto->{
            Guardian guardian = guardianMapper.mapToGuardian(guardiandto);
            guardian.setStudent(student);

            guardians.add(guardian);
             });

        student.setGuardians(guardians);

        return student;
    }


    public  StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();

        studentDto.setStudentID(student.getStudentID());
        studentDto.setGender(student.getGender());
        studentDto.setGrade(student.getGrade());
        studentDto.setDob(student.getDob());
        studentDto.setLastName(student.getLastName());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setDistrict(student.getDistrict());
        studentDto.setSchool(student.getSchool());

        List<Guardian> guardians = student.getGuardians();

        List<GuardianDto> guardianDtos =  guardians.stream().map(guardianMapper::mapToDto).collect(Collectors.toList());

        studentDto.setGuardians(guardianDtos);

        return studentDto;
    }
}
