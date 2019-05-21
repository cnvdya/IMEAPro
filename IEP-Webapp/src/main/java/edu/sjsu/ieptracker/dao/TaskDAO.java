package edu.sjsu.ieptracker.dao;

import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Objective;
import edu.sjsu.ieptracker.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TaskDAO {

    final static Logger logger = LoggerFactory.getLogger(GoalDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public TaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String saveOrUpdate(Task task){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(task);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            return null;
        }

        return "SUCCESS";

    }

    public List<Task> getAllTasksForGoal(int goalID) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Task> query = session.getNamedQuery("findTaskByGoalId");
        query.setParameter("id",goalID);

        List<Task> tasks = query.getResultList();
        return tasks;

    }

    public Task findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Task> query = session.getNamedQuery("findTaskById");
        query.setParameter("id", id);
        Task task = query.getSingleResult();
        return task;
    }
}
