package com.example.administrator.appctct.Model.ModelProfile;

import com.example.administrator.appctct.Entity.PointNameCourse;

import java.util.ArrayList;

public interface ModelGetInformationTestTestedListened {
    void getIndiformationIndividualSuccessed(ArrayList<PointNameCourse> data);
    void informationIndividualNull();
    void connectFailed(String message);
}
