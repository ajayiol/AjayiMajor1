package edu.mnstate.bv9599fk.ajayimajor1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONException;

import java.util.List;

public class history extends AppCompatActivity {
    RecyclerView rvStudent;
    private StudentAdapter adapter;
    private LinearLayoutManager myLinearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        rvStudent = (RecyclerView) findViewById(R.id.rvStudent);
        myLinearLayoutManager = new LinearLayoutManager(this);
        rvStudent.setLayoutManager(myLinearLayoutManager);
        try {
            List<info> teamList = info.createData("soccerHistory.json",this);
            adapter = new StudentAdapter(teamList);
            rvStudent.setAdapter(adapter);

        }catch(JSONException e){
            e.printStackTrace();
        }
    }

}
