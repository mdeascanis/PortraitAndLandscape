package edu.dtcc.matt.portraitandlandscape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public double area;

    public double diameter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
             area = savedInstanceState.getDouble("area", area);

             diameter = savedInstanceState.getDouble("diameter", diameter);


            TextView areaText = (TextView) findViewById(R.id.textArea);

            TextView diameterText = (TextView) findViewById(R.id.textCircumference);

            areaText.setText( ""+ area+"");

            diameterText.setText(""+ diameter+ "");
        }

        Button button = (Button) findViewById(R.id.calculateBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText radiusEdit = (EditText) findViewById(R.id.editText2);

                 TextView areaText = (TextView) findViewById(R.id.textArea);

                TextView diameterText = (TextView) findViewById(R.id.textCircumference);

                double radius = Integer.parseInt(radiusEdit.getText().toString());

                 area = radius * radius * 3.14;

                 diameter = 2 * radius * 3.14;

                areaText.setText( ""+ area+"");

                diameterText.setText(""+ diameter+ "");


                //Bundle bundle = new Bundle();

                //savedInstanceState.putDouble("area", area);

                //savedInstanceState.putDouble("diameter", diameter);

                //Intent intent = new Intent();

                //intent.putExtras(bundle);



            }
        });
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("area", area);
        outState.putDouble("diameter", diameter);

    }

}
