package edu.mnstate.bv9599fk.ajayimajor1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtMsg;
    private EditText editName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.editName);
    }

    public void myStartQuiz(View v) {
        {
            String username = editName.getText().toString();
            if(username.matches("")) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("ERROR");
                alertDialog.setMessage("No name, Press OK and enter a name");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
            else {
                Intent myIntent = new Intent(this, questions.class);
                Bundle b1 = new Bundle();
                b1.putString("Name",username);
                myIntent.putExtras(b1);
                startActivity(myIntent);
            }
        }
    }
}
