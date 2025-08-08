package com.example.icecreamproject;

package com.example.icecreamproject;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
21
public class MainActivity extends AppCompatActivity
{
    //declare objects
    RadioGroup flavorRG;
    //define a logical RadioButton
    RadioButton selectflavorRB;
    CheckBox pbCB, rpCB, caCB, orCB, rsCB, hfCB;
    Button submitBTN;
    //declare and initiate the string that will be sent to the
//second screen with all the choices
    String choices = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//define object(s)
        flavorRG = findViewById(R.id.flavorrgID);
        pbCB = findViewById(R.id.pbcbID);
        rpCB = findViewById(R.id.rpcbID);
        caCB = findViewById(R.id.cacbID);
        orCB = findViewById(R.id.orcbID);
        rsCB = findViewById(R.id.rscbID);
        hfCB = findViewById(R.id.hfcbID);
        submitBTN = findViewById(R.id.buttonID);
//setup a Listener to the submitBTN
        submitBTN.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
//define the selected radio button: first its ID
                int selectFlavorID = flavorRG.getCheckedRadioButtonId();
//checking if the user select any of the radio buttons
                if (selectFlavorID != -1)
                {
//now we can define the logical radio button selectflavorRB
                    selectflavorRB = findViewById(selectFlavorID);
                    String selectFlavor = selectflavorRB.getText().toString();
                    22
                    choices += selectFlavor;
                    if (pbCB.isChecked()) choices += ","+"Peanut Butter";
                    if (rpCB.isChecked()) choices += ","+"Reese's Pieces";
                    if (caCB.isChecked()) choices += ","+"Caramel";
                    if (orCB.isChecked()) choices += ","+"Oreo";
                    if (rsCB.isChecked()) choices += ","+"Rainbow Sprinkles";
                    if (hfCB.isChecked()) choices += ","+"Hot Fudge";
//now let's pass string choices to the second screen
                    Intent gotoScreen2 = new Intent(MainActivity.this, Screen2.class);
//pack the Intent object with values to be sent to the second screen
                    gotoScreen2.putExtra("choiceKey", choices);
                    choices = "";
                    startActivity(gotoScreen2);
                }
                else
                    Toast.makeText(MainActivity.this,
                            "Please select a flavor",
                            Toast.LENGTH_LONG).show();
            }
        });
    }//end of onCreate()