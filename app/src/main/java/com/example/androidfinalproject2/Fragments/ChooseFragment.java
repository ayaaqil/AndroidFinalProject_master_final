package com.example.androidfinalproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.databinding.FragmentChooseBinding;
import com.example.androidfinalproject2.fragment_diloge;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class ChooseFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_ANS1 = "answer_1";
    private static final String ARG_ANS2 = "answer_2";
    private static final String ARG_ANS3 = "answer_3";
    private static final String ARG_ANS4 = "answer_4";
    private static final String ARG_TRUE = "true_answer";
    private static final String ARG_POINTS = "points";
    private static final String ARG_DURATION = "duration";
    private static final String ARG_HINT = "hint";
    private  static  final  String ARG_LEVEL="level_no";



    // TODO: Rename and change types of parameters
    private String title;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private String true_answer;
    private  int points;
    private  int duration;
    private  String  hint;
    private int level_no;
    private int count =0;

    public ChooseFragment() {
    }
    public static ChooseFragment newInstance(String title, String answer_1, String answer_2, String answer_3,
                                             String answer_4, String true_answer
            , int points, int duration, String hint, int level_no) {
        ChooseFragment fragment = new ChooseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_ANS1, answer_1);
        args.putString(ARG_ANS2, answer_2);
        args.putString(ARG_ANS3, answer_3);
        args.putString(ARG_ANS4, answer_4);
        args.putString(ARG_TRUE, true_answer);
        args.putInt(ARG_POINTS, points);
        args.putInt(ARG_DURATION, duration);
        args.putString(ARG_HINT, hint);
        args.putInt(ARG_LEVEL,level_no);
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            answer_1 = getArguments().getString(ARG_ANS1);
            answer_2 = getArguments().getString(ARG_ANS2);
            answer_3 = getArguments().getString(ARG_ANS3);
            answer_4 = getArguments().getString(ARG_ANS4);
            true_answer = getArguments().getString(ARG_TRUE);
           points = getArguments().getInt(ARG_POINTS);
           duration = getArguments().getInt(ARG_DURATION);
           hint=getArguments().getString(ARG_HINT);
            level_no=getArguments().getInt(ARG_LEVEL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChooseBinding binding=FragmentChooseBinding.inflate(inflater,container,false);
        binding.tvQ.setText(title);
        binding.button3.setText(answer_1);
        binding.button4.setText(answer_2);
        binding.button5.setText(answer_3);
        binding.button6.setText(answer_4);
        binding.Level.setText(String.valueOf(level_no));
        binding.points.setText(String.valueOf(points));

        CountDownTimer countDownTimer = new CountDownTimer(duration, 2000) {

            @Override
            public void onTick(long millisUntilFinished) {

                binding.Timar.setText(String.valueOf(millisUntilFinished / 1000) + "s");

                NumberFormat f = new DecimalFormat("00");

                long hour = (millisUntilFinished / 3600000) % 24;

                long min = (millisUntilFinished / 60000) % 60;

                long sec = (millisUntilFinished / 1000) % 60;

                binding.Timar.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }

            @Override
            public void onFinish() {
                binding.Timar.setText("00:00:00");
                fragment_diloge fragmentDiloge=
                        fragment_diloge.newInstance(hint,"انتهى الوقت","");
                fragmentDiloge.show(getActivity().getSupportFragmentManager(),"");


            }
        }.start();

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.button3.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge   dialogFragment=
                            fragment_diloge.newInstance("","الاجابة صحيحة","احسنت");
                    dialogFragment.show(getActivity().getSupportFragmentManager(),"");
                }else if (!answer.equals(true_answer)){

                    count-=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge fragmentDiloge=
                            fragment_diloge .newInstance(hint,"الاجابة خاطئة","حظا اوفر");
                    fragmentDiloge.show(getActivity().getSupportFragmentManager(),"");
                }

            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.button4.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge   dialogFragment=
                            fragment_diloge.newInstance("","الاجابة صحيحة","احسنت");
                    dialogFragment.show(getActivity().getSupportFragmentManager(),"");
                }else if (!answer.equals(true_answer)){

                    count-=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge fragmentDiloge=
                            fragment_diloge .newInstance(hint,"الاجابة خاطئة","حظا اوفر");
                    fragmentDiloge.show(getActivity().getSupportFragmentManager(),"");
                }

            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.button5.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge   dialogFragment=
                            fragment_diloge.newInstance("","الاجابة صحيحة","احسنت");
                    dialogFragment.show(getActivity().getSupportFragmentManager(),"");
                }else if (!answer.equals(true_answer)){

                    count-=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge fragmentDiloge=
                            fragment_diloge .newInstance(hint,"الاجابة خاطئة","حظا اوفر");
                    fragmentDiloge.show(getActivity().getSupportFragmentManager(),"");
                }

            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.button6.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge   dialogFragment=
                            fragment_diloge.newInstance("","الاجابة صحيحة","احسنت");
                    dialogFragment.show(getActivity().getSupportFragmentManager(),"");
                }else if (!answer.equals(true_answer)){

                    count-=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge fragmentDiloge=
                            fragment_diloge .newInstance(hint,"الاجابة خاطئة","حظا اوفر");
                    fragmentDiloge.show(getActivity().getSupportFragmentManager(),"");
                }

            }
        });


        return  binding.getRoot();

    }
}