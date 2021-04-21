package com.example.alab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    public static int whatscene = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.fr_place, new LogIn()).commit();
        }
    }

    @Override
    public void onBackPressed()
    {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;
        switch (whatscene)
        {
            case 0:
                finish();
                break;
            case 1:
                fragment = new LogIn();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fr_place, fragment);
                ft.commit();
                whatscene = 0;
                break;
            case 2:
                fragment = fm.findFragmentById(R.id.fr_dad);
                fm.beginTransaction() .remove(fragment) .commit();
                Galery.mojpls = 0;
                whatscene = 1;
                break;
        }
    }

}
