package com.example.androidfinalproject2.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.R;
import com.example.androidfinalproject2.databinding.FragmentCompletBinding;
import com.example.androidfinalproject2.fragment_diloge;


public class CompletFragment extends Fragment {
    private static final String PUZZLES_TITLE = "title";
    private static final String PUZZLES_TRUE = "true_answer";
    private static final String PUZZLES_POINTS = "points";
    private static final String PUZZLES_DURATION = "duration";
    private static final String PUZZLES_HINT = "hint";
    private  static  final  String PUZZLES_LEVEL_NO="level_no";
    // TODO: Rename and change types of parameters
    private String title;
    private String true_answer;
    private  int points;
    private  int duration;
    private  String  hint;
    private int level_no;
    private  int count=0;

    public CompletFragment() {

    }


    public static CompletFragment newInstance( String title, String true_answer, int ponits, int level_no, int duration) {
        CompletFragment fragment = new CompletFragment();
        Bundle args = new Bundle();
        args.putString(PUZZLES_TITLE, title);
        args.putString(PUZZLES_TITLE, true_answer);
        args.putInt(PUZZLES_POINTS, ponits);
        args.putInt(PUZZLES_TITLE, level_no);
        args.putInt(PUZZLES_DURATION, duration);
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
            level_no = getArguments().getInt(PUZZLES_LEVEL_NO);
            duration = getArguments().getInt(PUZZLES_DURATION);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentCompletBinding binding=FragmentCompletBinding.inflate(inflater,container,false);
        binding.textView3.setText(title);
        binding.Level.setText(String.valueOf(level_no));
        binding.points.setText(String.valueOf(points));

        binding.editTextTextPersonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=binding.editTextTextPersonName.getText().toString();
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
}