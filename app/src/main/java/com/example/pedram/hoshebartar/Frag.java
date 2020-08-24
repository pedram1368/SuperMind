package com.example.pedram.hoshebartar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.zip.Inflater;



public class Frag extends Fragment {


    public interface onSomeEventListener {
        public void someEvent(String s);

    }

    public interface clean{
        public void cleanNumber(String clean);
    }

    public interface check{
        public void checkNumber(String check);
    }
    clean c;
    onSomeEventListener someEventListener;
    check ch;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ch=(check) activity;
            c = (clean) activity;
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_view,container,false);
        Button one=v.findViewById(R.id.one);
        Button two=v.findViewById(R.id.two);
        Button three=v.findViewById(R.id.three);
        Button four=v.findViewById(R.id.four);
        Button five=v.findViewById(R.id.five);
        Button six=v.findViewById(R.id.six);
        Button seven=v.findViewById(R.id.seven);
        Button eight=v.findViewById(R.id.eight);
        Button nine=v.findViewById(R.id.nine);
        Button zero=v.findViewById(R.id.zero);
        ImageView check=v.findViewById(R.id.frag_check);
        Button clear=v.findViewById(R.id.clear);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.checkNumber("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.cleanNumber("");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("0");
            }
        });
        
        return v;

    }
}







