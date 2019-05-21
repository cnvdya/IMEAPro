package edu.sjsu.ieptracker.dao;



import edu.sjsu.ieptracker.dto.StudentDto;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class StudentDAO {

    final static Logger logger = LoggerFactory.getLogger(StudentDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Student> query = session.getNamedQuery("findStudentById");
        query.setParameter("id", id);
        Student student = query.getSingleResult();
        return student;
    }

    public String saveOrUpdate(Student student){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            return null;
        }

        return "SUCCESS";

    }

    public List<Guardian> findGuardiansById(Integer studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Guardian> query = session.getNamedQuery("findGuardianByStudentId");
        query.setParameter("id", studentId);

        List<Guardian> guardians = query.getResultList();
        return guardians;
    }

    public List<Student> getAllStudent() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Student> query = session.getNamedQuery("findAllStudents");


        List<Student> students = query.getResultList();
        return students;
    }
}
