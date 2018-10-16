package edu.temple.fragmentexample;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    public static String COLOR_KEY = "color";
    public static String ID_KEY = "id";

    ColorInterface parent;

    View v;

    Context context;

    int color, id;

    public ColorFragment() {
        // Required empty public constructor
    }


    //Getting context
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        parent = (ColorInterface) context;
    }

    //Get the passed bundle data
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get resources with context
        //String[] values = context.getResources().getStringArray();
        //Get Bundle
        Bundle bundle = getArguments();
        //Set to this color
        this.color = bundle.getInt(COLOR_KEY);
        this.id = bundle.getInt(ID_KEY);
    }

    //Factory method of providing arguments to this fragment but not having to write it in your main
    public static ColorFragment newInstance(int id, int color){
        //Create instances of the Fragment
        ColorFragment colorFragment = new ColorFragment();
        //Passing Arguments && Creating Bundle
        Bundle bundle = new Bundle();
        bundle.putInt(ColorFragment.COLOR_KEY, color);
        bundle.putInt(ColorFragment.ID_KEY, id);
        colorFragment.setArguments(bundle);
        return colorFragment;
    }

    //Public method to allow activity to pass message to fragment
    public void changeColor(int color){
        v.setBackgroundColor(color);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Button button;

        // grad a hold of view then return it
        v = inflater.inflate(R.layout.fragment_color, container, false);

        button = v.findViewById(R.id.changeColorButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //v.setBackgroundColor((new Random()).nextInt() % 2 == 0? Color.BLACK : Color.BLUE);
                parent.userClick(id);
            }
        });

        v.setBackgroundColor(color);

        return v;
    }

    interface ColorInterface{
        public void userClick(int id);
    }

}
