package com.example.administrator.appctct.Presenter.PresenterTest;
import com.example.administrator.appctct.Entity.QuestionTestTested;

import java.util.ArrayList;

public interface PresenterGetQuestionTestTestedListened {
    void getQuestionSuccessedTestTested(ArrayList<QuestionTestTested> listQuestion);
    void connectFailed(String message);
}
