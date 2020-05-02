package dao;

import java.util.List;
import models.QuestionPossibleAnswers;
import models.Result;
import models.User;
import models.UserAnswers;

public interface IExamDao {

    int saveUser(User user);

    List<QuestionPossibleAnswers> getQuestionsWithPossibleAnswers();

    boolean saveSelectedAnswers(UserAnswers answer);
}
