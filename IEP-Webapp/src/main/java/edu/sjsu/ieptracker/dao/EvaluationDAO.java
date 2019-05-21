package edu.sjsu.ieptracker.dao;

import edu.sjsu.ieptracker.entity.Evaluation;
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
public class EvaluationDAO {

    final static Logger logger = LoggerFactory.getLogger(EvaluationDAO.class);
    private SessionFactory sessionFactory;

    @Autowired
    public EvaluationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String saveOrUpdate(Evaluation evaluation){
        try {

            Session session = this.sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(evaluation);
            session.flush();
            session.getTransaction().commit();
        }catch (Exception ex){
            return null;
        }

        return "SUCCESS";
    }

    public List<Evaluation> getAllEvaluationsForTask(int taskID) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Evaluation> query = session.getNamedQuery("findEvaluationByTaskId");
        query.setParameter("id",taskID);
        List<Evaluation> evaluations = query.getResultList();
        return evaluations;

    }





}
