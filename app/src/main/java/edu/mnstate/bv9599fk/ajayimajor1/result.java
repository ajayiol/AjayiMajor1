package edu.mnstate.bv9599fk.ajayimajor1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class result extends AppCompatActivity {
    private TextView txtIntro;
    private TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent myIntent = getIntent();
        Bundle b2 = myIntent.getExtras();
        String nameStr = b2.getString("Name");
        Integer count = b2.getInt("Count");
        txtIntro = (TextView) findViewById(R.id.txtIntro);
        txtScore = (TextView) findViewById(R.id.txtScore);
        txtIntro.setText(nameStr+" Scored: ");
        String score = "0%";

        if(count == 1){
            score = "20%";
        }
        else if(count ==2){
            score = "40%";

        }
        else if(count == 3){
            score = "60%";
        }
        else if(count == 4){
            score = "80%";
        }
        else if(count == 5){
            score = "100%";
        }
        txtScore.setText(score);
    }
    public void handleRestart(View v){
        Intent next = new Intent(this,MainActivity.class);
        startActivity(next);
    }
    public void handleHistory(View v){
        Intent next = new Intent(this,history.class);
        startActivity(next);
    }

}
