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

/**
 * Created by pedram on 8/19/2020.
 */

public class Frag2 extends Fragment {


    public interface onSomeEventListener2 {
        public void someEvent2(String s);

    }

    public interface clean2{
        public void cleanNumber2(String clean);
    }

    public interface check2{
        public void checkNumber2(String check);
    }
    clean2 c;
    onSomeEventListener2 someEventListener;
    check2 ch;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            ch=(check2) activity;
            c = (clean2) activity;
            someEventListener = (onSomeEventListener2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment2,container,false);
        Button one=v.findViewById(R.id.one2);
        Button two=v.findViewById(R.id.two2);
        Button three=v.findViewById(R.id.three2);
        Button four=v.findViewById(R.id.four2);
        Button five=v.findViewById(R.id.five2);
        Button six=v.findViewById(R.id.six2);
        Button seven=v.findViewById(R.id.seven2);
        Button eight=v.findViewById(R.id.eight2);
        Button nine=v.findViewById(R.id.nine2);
        Button zero=v.findViewById(R.id.zero2);
        ImageView check=v.findViewById(R.id.frag_check2);
        Button clear=v.findViewById(R.id.clear2);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.checkNumber2("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.cleanNumber2("");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent2("0");
            }
        });

        return v;

    }
}

