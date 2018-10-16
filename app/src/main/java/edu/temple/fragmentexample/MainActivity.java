package edu.temple.fragmentexample;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ColorFragment.ColorInterface {

    ColorFragment colorFragment1, colorFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create instances of the Fragment
        colorFragment1 = ColorFragment.newInstance(1, Color.GREEN);

        /*
        //Passing Arguments && Creating Bundle
        Bundle bundle = new Bundle();
        bundle.putInt(ColorFragment.COLOR_KEY, Color.RED);
        colorFragment.setArguments(bundle);
        */

        //Get Fragment Manager
        FragmentManager fm = getSupportFragmentManager();

        //Start Transaction then describe what you want to do
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container_1, colorFragment1);

        ft.addToBackStack(null);

        ft.commit();

        //Another way of doing it
        /*
        fm.beginTransaction()
                .add(R.id.container_1, colorFragment)
                .commit();
        */
        colorFragment2 = ColorFragment.newInstance(2, Color.YELLOW);
        fm.beginTransaction().add(R.id.container_2, colorFragment2).addToBackStack(null).commit();

        /*
        //Button to frag
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorFragment.changeColor(Color.GRAY);
            }
        });
        */

    }

    @Override
    public void userClick(int id) {

        int color = (new Random()).nextInt() % 2 == 0? Color.MAGENTA : Color.RED;

        if (id==1){
            colorFragment2.changeColor(color);
        } else {
            colorFragment1.changeColor(color);
        }
    }
}
