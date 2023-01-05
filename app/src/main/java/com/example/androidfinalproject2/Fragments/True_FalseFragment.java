package com.example.androidfinalproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.R;
import com.example.androidfinalproject2.databinding.FragmentTrueFalseBinding;
import com.example.androidfinalproject2.fragment_diloge;


public class True_FalseFragment extends Fragment {

    private static final String PUZZLES_TITLE = "title";
    private static final String PUZZLES_TRUE = "true_answer";
    private static final String PUZZLES_POINTS = "points";
    private static final String PUZZLES_DURATION = "duration";
    private static final String PUZZLES_HINT = "hint";
    private  static  final  String PUZZLES_LEVEL_NO="level_no";

    private String title;
    private String true_answer;
    private  int points;
    private  int duration;
    private  String  hint;
    private int level_no;
    private  int count=0;

    public True_FalseFragment() {

    }


    public static True_FalseFragment newInstance(String title, String true_answer, int points, int duration, int level_no, String hint) {
        True_FalseFragment fragment = new True_FalseFragment();
        Bundle args = new Bundle();
        args.putString(PUZZLES_TITLE, title);
       args.putString(PUZZLES_TRUE,true_answer);
       args.putInt(PUZZLES_POINTS,points);
        args.putInt(PUZZLES_DURATION,duration);
        args.putInt(PUZZLES_LEVEL_NO,level_no);
        args.putString(PUZZLES_HINT,hint);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(PUZZLES_TITLE);
            true_answer = getArguments().getString(PUZZLES_TRUE);
            points = getArguments().getInt(PUZZLES_POINTS);
            duration = getArguments().getInt(PUZZLES_DURATION);
            hint=getArguments().getString(PUZZLES_HINT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentTrueFalseBinding binding=FragmentTrueFalseBinding.inflate(inflater,container,false);
        binding.tvQ1.setText(title);
        binding.Level.setText(String.valueOf(level_no));
        binding.points.setText(String.valueOf(points));

        binding.rbTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.rbTrue.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge dialogFragment=
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
        binding.rbFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.rbFalse.getText().toString();
                if (answer.equals(true_answer)){

                    count+=points;
                    binding.points.setText(String.valueOf(count));
                    fragment_diloge dialogFragment=
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
       return binding.getRoot();

    }
  //  return inflater.inflate(R.layout.fragment_true__false, container, false);
}