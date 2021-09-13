package com.example.fragmentcommubication_we;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {
    private EditText mEtGrade;
    private EditText mEtPercentage;
    private Button mBtnNext;
    String name;
    String age;
    private FragmentListener mFragmentListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initviews(view);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.getString("data") != null) {
            name=(bundle.getString("Name"));
            age=(bundle.getString("Age")).toString();
        }
    }

    public void initviews(View view) {
        mEtGrade=view.findViewById(R.id.etGrade);
        mEtPercentage=view.findViewById(R.id.etPercentage);
        mBtnNext=view.findViewById(R.id.btnNext);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( mFragmentListener != null) {
                    String grade=mEtGrade.getText().toString();
                    String percentage= mEtPercentage.getText().toString();
                    Model model=new Model(name,age,grade,percentage);
                    Intent intent=new Intent(getContext(),PreviewActivity.class);
                    intent.putExtra("model",model);
                    startActivity(intent);
                }
            }
        });
    }

    public void setFragmentListener(FragmentListener fragmentListener) {
        mFragmentListener = fragmentListener;
    }
}