package edu.sjsu.ieptracker.dao;


import edu.sjsu.ieptracker.entity.Evaluation;
import edu.sjsu.ieptracker.entity.Goal;
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
public class GoalDAO {

    final static Logger logger = LoggerFactory.getLogger(GoalDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public GoalDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Goal> getAllGoalsForStudent(int studentID) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Goal> query = session.getNamedQuery("findAllGoalsForStudent");
        query.setParameter("id",studentID);

        List<Goal> goals = query.getResultList();
        return goals;

    }

    public Goal findByGoalId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Goal> query = session.getNamedQuery("findGoalById");
        query.setParameter("id", id);
        Goal goal = query.getSingleResult();
        return goal;
    }


    public String saveOrUpdate(Goal goal){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(goal);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            return null;
        }

        return "SUCCESS";
    }




}
