/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static java.lang.System.out;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.QuestionPossibleAnswers;
import models.Result;
import models.User;
import models.UserAnswers;

/**
 *
 * @author user
 */
public class ExamDaoImpl implements IExamDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    //constructor 
    public ExamDaoImpl() {
        emf = Persistence.createEntityManagerFactory("CB10_APPPU2");  //name of persistence unit 
        em = emf.createEntityManager();
    }

    @Override
    public int saveUser(User user) {
        em.getTransaction().begin();
        user.setUsername("ggg");
        em.persist(user);
        em.getTransaction().commit();
        return 1;

    }

    @Override
    public boolean saveSelectedAnswers(UserAnswers answer) {
        em.getTransaction().begin();
        em.persist(answer);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers() {

        em.getTransaction().begin();
        List<QuestionPossibleAnswers> questionsPossibleAnswers = em.createQuery("SELECT `questions.text`, answers.text_ans` FROM questions q, answers a", QuestionPossibleAnswers.class).getResultList();

        for (QuestionPossibleAnswers qpa : questionsPossibleAnswers) {
            System.out.println(qpa.getQuestions() + "\n" + qpa.getAnswers());
        }

        /*  // @Override
  //  public Result getResult(User user) {
    //    Result result;
        // em.createQuery(SELECT) 
        //    = em.find(Result.class, user);
        //    return result;
        //  }
      //  return null;
    //} */
