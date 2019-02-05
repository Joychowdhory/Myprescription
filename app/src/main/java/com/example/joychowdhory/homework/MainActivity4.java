package com.example.joychowdhory.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity  implements View.OnClickListener{

    private Button heart,diabetic,kidney,allergies,alzheimer,asthma,cancer,arthritis,
                   eyesight,depression,stroke,tuberculosis,cirrhosis,bloodpressure,
                   hiv,infectiousdisease,lungs,liver;
    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        heart = (Button) findViewById(R.id.heartID);
        diabetic = (Button) findViewById(R.id.diabeticID);
        kidney = (Button) findViewById(R.id.kidneyID);
        allergies = (Button) findViewById(R.id.allergiesID);
        alzheimer = (Button) findViewById(R.id.alzheimerID);
        asthma = (Button) findViewById(R.id.asthmaID);
        cancer = (Button) findViewById(R.id.cancerID);
        arthritis = (Button) findViewById(R.id.arthritisID);
        eyesight = (Button) findViewById(R.id.eyesightID);
        depression = (Button) findViewById(R.id.depressionID);
        stroke = (Button) findViewById(R.id.strokeID);
//        tuberculosis = (Button) findViewById(R.id.tuberculosisID);
//        cirrhosis = (Button) findViewById(R.id.cirrhosisID);
//        bloodpressure = (Button) findViewById(R.id.bloodpressureID);
//        hiv = (Button) findViewById(R.id.hivID);
//        infectiousdisease = (Button) findViewById(R.id.infectiousdiseaseID);
//        lungs = (Button) findViewById(R.id.lungsID);
//        liver = (Button) findViewById(R.id.liverID);

        heart.setOnClickListener (this);
        diabetic.setOnClickListener (this);
        kidney.setOnClickListener(this);
        allergies.setOnClickListener(this);

        alzheimer.setOnClickListener(this);
        asthma.setOnClickListener(this);
        cancer.setOnClickListener(this);

        arthritis.setOnClickListener(this);
        eyesight.setOnClickListener(this);
        depression.setOnClickListener(this);
        stroke.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.heartID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","heart");
            startActivity(intent);
        }
        if(v.getId()==R.id.diabeticID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","diabetic");
            startActivity(intent);
        }
        if(v.getId()==R.id.kidneyID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","kidney");
            startActivity(intent);
        }
        if(v.getId()==R.id.allergiesID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","allergies");
            startActivity(intent);
        }



        if(v.getId()==R.id.alzheimerID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","alzheimer");
            startActivity(intent);
        }
        if(v.getId()==R.id.asthmaID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","asthma");
            startActivity(intent);
        }
        if(v.getId()==R.id.cancerID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","cancer");
            startActivity(intent);
        }
        if(v.getId()==R.id.arthritisID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","arthritis");
            startActivity(intent);
        }
        if(v.getId()==R.id.eyesightID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","eyesight");
            startActivity(intent);
        }
        if(v.getId()==R.id.depressionID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","depression");
            startActivity(intent);
        }
        if(v.getId()==R.id.strokeID){

            intent = new Intent(MainActivity4.this,SymptomDetails.class);
            intent.putExtra("name","stroke");
            startActivity(intent);
        }

    }
}
