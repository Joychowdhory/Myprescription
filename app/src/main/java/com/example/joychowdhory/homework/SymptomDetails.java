package com.example.joychowdhory.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SymptomDetails extends AppCompatActivity {

    private ImageView imageview;
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_details);

        imageview = (ImageView) findViewById(R.id.imageviewID);
        textview = (TextView) findViewById(R.id.textviewID);


        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            String medicineName = bundle.getString("name");
            showDetails(medicineName);
        }
    }

    void showDetails(String medicineName)    {

        if(medicineName.equals("heart")) {

            imageview.setImageResource(R.drawable.heartattack);
            textview.setText(R.string.heart_text);
        }
        if(medicineName.equals("diabetic")) {

            imageview.setImageResource(R.drawable.diabetes);
            textview.setText(R.string.diabetic_text);
        }

        if(medicineName.equals("kidney")) {

            imageview.setImageResource(R.drawable.kidney);
            textview.setText(R.string.kidney_text);
        }
        if(medicineName.equals("allergies")) {

            imageview.setImageResource(R.drawable.allergies);
            textview.setText(R.string.allergies_text);
        }
        if(medicineName.equals("alzheimer")) {

            imageview.setImageResource(R.drawable.alzheimer);
            textview.setText(R.string.alzheimer_text);
        }
        if(medicineName.equals("asthma")) {

            imageview.setImageResource(R.drawable.asthma);
            textview.setText(R.string.asthma_text);
        }



        if(medicineName.equals("cancer")) {

            imageview.setImageResource(R.drawable.cancer);
            textview.setText(R.string.cancer_text);
        }
        if(medicineName.equals("arthritis")) {

            imageview.setImageResource(R.drawable.arthritis);
            textview.setText(R.string.arthritis_text);
        }

        if(medicineName.equals("eyesight")) {

            imageview.setImageResource(R.drawable.eyesight);
            textview.setText(R.string.eyesight_text);
        }
        if(medicineName.equals("depression")) {

            imageview.setImageResource(R.drawable.depression);
            textview.setText(R.string.depression_text);
        }
        if(medicineName.equals("stroke")) {

            imageview.setImageResource(R.drawable.stroke);
            textview.setText(R.string.stroke_text);
        }





    }
}
