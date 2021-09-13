package com.example.fragmentcommubication_we;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private EditText mEtName;
    private EditText mEtAge;
    private Button mBtnNext;
    private FragmentListener mFragmentListener;
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
     mEtName=view.findViewById(R.id.etName);
     mEtAge=view.findViewById(R.id.etAge);
     mBtnNext=view.findViewById(R.id.btnNext);
     mBtnNext.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Bundle bundle = new Bundle();
             if ( mFragmentListener != null) {
                 bundle.putString("Name", mEtName.getText().toString());
                 bundle.putString("Age", mEtAge.getText().toString());
                 mFragmentListener.onFragmentDataPassed(bundle);
             }
         }
     });
    }
    public void setFragmentListener(FragmentListener fragmentListener) {
        mFragmentListener = fragmentListener;
    }
}