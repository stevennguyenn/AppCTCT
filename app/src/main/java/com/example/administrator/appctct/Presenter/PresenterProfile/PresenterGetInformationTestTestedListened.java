package com.example.administrator.appctct.Presenter.PresenterProfile;

import com.example.administrator.appctct.Entity.PointNameCourse;
import java.util.ArrayList;

public interface PresenterGetInformationTestTestedListened {
    void getIndiformationIndividualSuccessed(ArrayList<PointNameCourse> data);
    void informationIndividualNull();
    void connectFailed(String message);
}
