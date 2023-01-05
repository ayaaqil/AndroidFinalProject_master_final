package com.example.androidfinalproject2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfinalproject2.databinding.FragmentDilogeBinding;


public class fragment_diloge extends DialogFragment {
    listiner_daliog listinerDaliog;


    private static final String ARG_message = "message";
    private static final String ARG_hint = "hint";
    private static final String ARG_title = "title";

    // TODO: Rename and change types of parameters
    private String message ;
    private String hint;
    private String title;

    public fragment_diloge() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof listiner_daliog)
            listinerDaliog= (listiner_daliog) context;
    }


    public static fragment_diloge newInstance(String hint, String message,String title ) {
        fragment_diloge fragment = new fragment_diloge();
        Bundle args = new Bundle();
        args.putString(ARG_hint, hint);
        args.putString(ARG_title, title);
        args.putString(ARG_message, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_title);
            message = getArguments().getString(ARG_message);
            hint = getArguments().getString(ARG_hint);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_diloge, container, false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        FragmentDilogeBinding binding= FragmentDilogeBinding.inflate(getLayoutInflater());

        binding.tvMessageDialogF.setText(message);
        binding.tvHint.setText(hint);
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 listinerDaliog.onLisner();
                 dismiss();
            }
        });

        builder.setView(binding.getRoot());
        return builder.create();
    }
}