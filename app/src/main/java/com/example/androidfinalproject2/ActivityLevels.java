package com.example.androidfinalproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidfinalproject2.Fragments.ChooseFragment;
import com.example.androidfinalproject2.Fragments.CompletFragment;
import com.example.androidfinalproject2.Fragments.True_FalseFragment;
import com.example.androidfinalproject2.RoomDataBase.Puzzles;
import com.example.androidfinalproject2.RoomDataBase.ViewModel;
import com.example.androidfinalproject2.databinding.ActivityLevelsBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ActivityLevels extends AppCompatActivity implements listiner_daliog {
    ActivityLevelsBinding binding;
    AdapterViewPager adapterViewPager;
    ArrayList<Fragment>fragmentArrayList=new ArrayList<>();
    ViewModel viewModel;
    ArrayList<Puzzles>puzzelsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentArrayList.add(new ChooseFragment());
        fragmentArrayList.add(new True_FalseFragment());
        fragmentArrayList.add(new CompletFragment());
         puzzelsArrayList=new ArrayList<>();


// اه
     viewModel= new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getAllPuzzles().observe(this, new Observer<List<Puzzles>>() {
            @Override
            public void onChanged(List<Puzzles> puzzles) {
                puzzelsArrayList= (ArrayList<Puzzles>) puzzles;
                //puzzles=puzzelsArrayList;
                for (int i = 1; i < puzzles.size(); i++) {
                    int pattern_id = puzzles.get(i).getPattern_id();
                    String title = puzzles.get(i).getTitle();
                    String answer1 = puzzles.get(i).getAns1();
                    String answer2 =puzzles.get(i).getAns2();
                    String answer3 = puzzles.get(i).getAns3();
                    String answer4 = puzzles.get(i).getAns4();
                    String trueans = puzzles.get(i).getAns_ture();
                    String hint = puzzles.get(i).getHint();
                    int ponits = puzzles.get(i).getPoints();
                    int level_no =puzzles.get(i).getLevel_id();
                    int  duration = puzzles.get(i).getDuration();
//                    Toast.makeText(getApplicationContext(), ""+title+trueans+ponits+duration+level_no+hint, Toast.LENGTH_SHORT).show();

                    if (pattern_id == 1) {
                      fragmentArrayList.add(  True_FalseFragment.newInstance(title, trueans,ponits,duration,level_no,hint));
                    } else if (pattern_id == 2) {
                       fragmentArrayList.add(ChooseFragment.newInstance(title,answer1,answer2,answer3,answer4,trueans,ponits,duration,hint,level_no));
                    } else if (pattern_id == 3) {
                       fragmentArrayList.add(CompletFragment.newInstance(title,trueans,ponits,level_no,duration));
                    } } }});
         adapterViewPager=new AdapterViewPager(ActivityLevels.this,fragmentArrayList);

        binding.VP.setAdapter(adapterViewPager);
//        Toast.makeText(getApplicationContext(), ""+adapterViewPager.fragmentArrayList, Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onLisner() {
        int vb=binding.VP.getCurrentItem();
        binding.VP.setCurrentItem(vb+1);
    }
}