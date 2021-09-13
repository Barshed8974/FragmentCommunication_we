package com.example.fragmentcommubication_we;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private TextView name;
    private TextView age;
    private TextView grade;
    private TextView percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initviews();
        getData();
    }
    private void initviews() {
        name=findViewById(R.id.tvName);
        age=findViewById(R.id.tvAge);
        grade=findViewById(R.id.tvGrade);
        percentage=findViewById(R.id.tvPercentage);
    }
    private void getData() {
        Model model=(Model) getIntent().getSerializableExtra("model");
        name.setText(model.getName());
        age.setText(model.getAge());
        grade.setText(model.getGrade());
        percentage.setText(model.getPercentage());
    }
}