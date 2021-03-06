//Matthew DeAscanis
//CIS 282-401

package edu.dtcc.matt.portraitandlandscape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //
    public float area;

    public float diameter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Load and display information each time activity is redrawn
        if (savedInstanceState != null) {
             area = savedInstanceState.getFloat("area", area);

             diameter = savedInstanceState.getFloat("diameter", diameter);


            TextView areaText = (TextView) findViewById(R.id.textArea);

            TextView diameterText = (TextView) findViewById(R.id.textDiameter);

            areaText.setText( ""+ area+ "");

            diameterText.setText(""+ diameter+ "");
        }

        //define a button object
        Button button = (Button) findViewById(R.id.calculateBtn);

        //set listener for the button object we defined
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText radiusEdit = (EditText) findViewById(R.id.editText2);

                 TextView areaText = (TextView) findViewById(R.id.textArea);

                TextView diameterText = (TextView) findViewById(R.id.textDiameter);

                float radius = Integer.parseInt(radiusEdit.getText().toString());

                 area = (float) (radius * radius * 3.14);

                 diameter = (float) (2 * radius * 3.14);

                areaText.setText( ""+ area+"");

                diameterText.setText(""+ diameter+ "");


            }
        });
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        //save area and diameter to the outStat bundle
        outState.putFloat("area", area);
        outState.putFloat("diameter", diameter);

    }

}
