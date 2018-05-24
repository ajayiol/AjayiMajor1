package edu.mnstate.bv9599fk.ajayimajor1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class questions extends AppCompatActivity {
    private SeekBar seekBar4;
    private TextView txtValue;
    private ToggleButton toggleButton4;
    private RadioButton rb1;
    private Spinner spinTeam;
    Integer count;
    CheckBox checkBox3;
    String msg;
    ArrayAdapter<CharSequence> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        txtValue = (TextView) findViewById(R.id.txtValue);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        toggleButton4 = (ToggleButton) findViewById(R.id.toggleButton4);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        spinTeam = (Spinner) findViewById(R.id.spinTeam);

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            Integer value =seekBar4.getProgress();
                String tmp = String.valueOf(value);
                txtValue.setText(tmp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Integer value =seekBar4.getProgress();
                String tmp = String.valueOf(value);
                txtValue.setText(tmp);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Integer value =seekBar4.getProgress();
                String tmp = String.valueOf(value);
                txtValue.setText(tmp);
            }
        });

        spinTeam = (Spinner) findViewById(R.id.spinTeam);
        myAdapter = ArrayAdapter.createFromResource(this,R.array.team_number,android.R.layout.simple_spinner_item);
        spinTeam.setAdapter(myAdapter);
        spinTeam.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                         msg = parent.getSelectedItem().toString();



                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                }
        );

    }

    public void mySubmitQuiz(View v) {
        {
            count = 0;
            Integer value =seekBar4.getProgress();
            if(value == 3){
                count++;
            }
            if(checkBox3.isChecked()){
                count++;
            }
            if(toggleButton4.isChecked()){
                count++;
            }
            if(rb1.isChecked()){
                count++;
            }
            if(msg.equals("11")){
                count++;
            }
            Intent next = new Intent(this,result.class);
            Intent myIntent = getIntent();
            Bundle b1 = myIntent.getExtras();
            String nameStr = b1.getString("Name");
            Bundle b2 = new Bundle();
            b2.putString("Name",nameStr);
            b2.putInt("Count",count);
            next.putExtras(b2);
            startActivity(next);
        }
    }
}
