package edu.sjsu.ieptracker.dao;

import edu.sjsu.ieptracker.entity.Goal;
import edu.sjsu.ieptracker.entity.Objective;
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
public class ObjectiveDAO {

    final static Logger logger = LoggerFactory.getLogger(GoalDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public ObjectiveDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public List<Objective> getAllObjectivesForGoal(int goalID) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Objective> query = session.getNamedQuery("getObjectivesForGoalId");
        query.setParameter("id",goalID);

        List<Objective> objectives = query.getResultList();
        return objectives;

    }

    public Objective findObjectiveById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Objective> query = session.getNamedQuery("findObjectiveById");
        query.setParameter("id", id);
        Objective objective = query.getSingleResult();
        return objective;
    }

    public String saveOrUpdate(Objective objective){
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(objective);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            return null;
        }

        return "SUCCESS";
    }


}
