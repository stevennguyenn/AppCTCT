package com.example.administrator.appctct.View.Test;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.appctct.Adapter.QuestionApdater.CheckBoxClick;
import com.example.administrator.appctct.Adapter.QuestionApdater.QuestionAdapter;
import com.example.administrator.appctct.Adapter.QuestionApdater.ItemClick;
import com.example.administrator.appctct.Entity.IdAndResult;
import com.example.administrator.appctct.Entity.ModelQuestion;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.Service.Retrofit.APIUtils;
import com.example.administrator.appctct.Service.Retrofit.DataClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClick,CheckBoxClick,View.OnClickListener{

    RecyclerView rcQuestion;
    ArrayList<ModelQuestion> listQuestion;
    QuestionAdapter adapter;
    Button btCTCT;
    ArrayList<IdAndResult> listIdandResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setID();
        setData();
        getData();
    }

    private void getData(){
        DataClient client = APIUtils.getData();
        Call<ArrayList<ModelQuestion>> call = client.getQuestion();
        call.enqueue(new Callback<ArrayList<ModelQuestion>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Response<ArrayList<ModelQuestion>> response) {
                if (response.body() != null) {
                    listQuestion.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ModelQuestion>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setID(){
        rcQuestion = findViewById(R.id.rcMain);
        btCTCT = findViewById(R.id.btCTCT);
        btCTCT.setOnClickListener(this);
    }

    private void setData(){
        rcQuestion.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcQuestion.setLayoutManager(layoutManager);
        listQuestion = new ArrayList<>();
        adapter = new QuestionAdapter(listQuestion,MainActivity.this);
        adapter.setCheckBoxClickListened(this);
        adapter.setClickListned(this);
        rcQuestion.setAdapter(adapter);
        listIdandResult = new ArrayList<>();
    }

    @Override
    public void click(View v, int position) {
        //Toast.makeText(MainActivity.this,listQuestion.get(position).getQuestion_a()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkboxListened(int position, String result) {
        if (listIdandResult.size() > 0) {
            for (IdAndResult x : listIdandResult) {
                if (x.getId().equals(listQuestion.get(position).getId())) {
                    Integer index = listIdandResult.indexOf(x);
                    listIdandResult.get(index).setResult(result);
                    return;
                }
            }
            listIdandResult.add(new IdAndResult(listQuestion.get(position).getId(), result));
            return;
        }
        listIdandResult.add(new IdAndResult(listQuestion.get(position).getId(), result));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btCTCT:
                showResult();
                break;
        }
    }

    private void showResult(){
        if (listIdandResult.size() == 0){
            Toast.makeText(MainActivity.this,"Please choice result",Toast.LENGTH_SHORT).show();
            return;
        }
        String[] arrid = new String[listIdandResult.size()];
        String[] arrresult = new String[listIdandResult.size()];

        for (int i = 0 ;i<listIdandResult.size();i++){
            arrid[i] = listIdandResult.get(i).getId();
            arrresult[i] = listIdandResult.get(i).getResult();
        }

        DataClient client = APIUtils.getData();
        Call<Integer> callback = client.getResult(arrid,arrresult);
        callback.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(@NonNull  Call<Integer> call,@NonNull Response<Integer> response) {
                if (response.body() != null){
                    Toast.makeText(MainActivity.this,response.body()+"",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull  Call<Integer> call,@NonNull Throwable t) {
                Log.d("AAAB",t.getLocalizedMessage());
            }
        });
    }
}
