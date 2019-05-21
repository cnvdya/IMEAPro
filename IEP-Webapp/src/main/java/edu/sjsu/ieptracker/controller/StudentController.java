package edu.sjsu.ieptracker.controller;

import edu.sjsu.ieptracker.dto.GuardianDto;
import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Student;
import edu.sjsu.ieptracker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static edu.sjsu.ieptracker.utils.IEPTrackerConstants.*;

@RequestMapping(path="/student")
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value= GET_STUDENT_BY_ID, method=RequestMethod.GET)
    public @ResponseBody
    StudentDto getStudentById(@RequestParam Integer studentId) {
        return  studentService.findById(studentId);
    }
    @RequestMapping(GET_ALL_STUDENTS)
    public List< StudentDto > getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = SAVE_STUDENT, method = RequestMethod.POST)
    public void saveStudent(@RequestBody StudentDto studentDto) {
        studentService.saveOrUpdate(studentDto);
    }

    @RequestMapping(value= TEST_CONTROLLER, method=RequestMethod.GET)
    public @ResponseBody String testController(){
        return "controller working";
    }

    @RequestMapping(value= "/guardiansByStudenID", method=RequestMethod.GET)
    public @ResponseBody
    List<GuardianDto> getGuardiansByStudentId(@RequestParam Integer studentId) {
        return  studentService.findGuardiansById(studentId);
    }
}
