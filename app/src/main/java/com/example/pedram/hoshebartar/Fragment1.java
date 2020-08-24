package com.example.pedram.hoshebartar;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment1 extends Fragment {

    public interface onSomeEventListener1 {
        public void someEvent1(String s);

    }

    public interface clean1{
        public void cleanNumber1(String clean);
    }

    public interface check1{
        public void checkNumber1(String check);
    }
    Fragment1.clean1 c;
    Fragment1.onSomeEventListener1 someEventListener;
    Fragment1.check1 ch;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ch=(Fragment1.check1) activity;
            c = (Fragment1.clean1) activity;
            someEventListener = (Fragment1.onSomeEventListener1) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.activity_fragment1,container,false);
        Button one=v.findViewById(R.id.one1);
        Button two=v.findViewById(R.id.two1);
        Button three=v.findViewById(R.id.three1);
        Button four=v.findViewById(R.id.four1);
        Button five=v.findViewById(R.id.five1);
        Button six=v.findViewById(R.id.six1);
        Button seven=v.findViewById(R.id.seven1);
        Button eight=v.findViewById(R.id.eight1);
        Button nine=v.findViewById(R.id.nine1);
        Button zero=v.findViewById(R.id.zero1);
        ImageView check=v.findViewById(R.id.frag_check1);
        Button clear=v.findViewById(R.id.clear1);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.checkNumber1("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.cleanNumber1("");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent1("0");
            }
        });

        return v;

    }
}
