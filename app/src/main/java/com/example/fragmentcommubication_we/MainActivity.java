package com.example.fragmentcommubication_we;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentListener {
    private FrameLayout frameLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        launchFragmentA();
        fragmentManager=getSupportFragmentManager();
    }


    private void initviews() {
        frameLayout=findViewById(R.id.flContainer);
    }

    private void launchFragmentA() {
        FragmentA fragmentA=new FragmentA();
        fragmentA.setFragmentListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    @Override
    public void onFragmentDataPassed(Bundle bundle) {
        Toast.makeText(this, "Data has to be passed", Toast.LENGTH_SHORT).show();
        /*
          Once the Pass Data button is clicked in Fragment A , we get callback here and here we need to launch fragmentB
         */
        launchFragmentB(bundle);
    }

    private void launchFragmentB(Bundle bundle) {
        FragmentB fragmentB = new FragmentB();
        /*
        Set the data to fragmentB received from FragmentA via the listener
         */
        fragmentB.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, fragmentB, "FragmentB").addToBackStack("FragmentB").commit();
    }
}