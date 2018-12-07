package com.example.administrator.appctct.Presenter.PresenterTest;

import com.example.administrator.appctct.Entity.QuestionTestTested;
import com.example.administrator.appctct.Model.ModelTest.ModelGetQuestionTestTested;
import com.example.administrator.appctct.Model.ModelTest.ModelGetQuestionTestTestedListened;
import java.util.ArrayList;

public class PresenterGetQuestionTestTested implements ModelGetQuestionTestTestedListened{
    private ModelGetQuestionTestTested model = new ModelGetQuestionTestTested(this);
    private PresenterGetQuestionTestTestedListened listened;

    public PresenterGetQuestionTestTested(PresenterGetQuestionTestTestedListened listened){
        this.listened = listened;
    }

    public void getQuestion(int typeSection,String token,String testCode){
        model.getQuestion(typeSection,token,testCode);
    }

    @Override
    public void getQuestionSuccessed(ArrayList<QuestionTestTested> listQuestion) {
        listened.getQuestionSuccessedTestTested(listQuestion);
    }

    @Override
    public void connectFailed(String message) {
        listened.connectFailed(message);
    }
}
