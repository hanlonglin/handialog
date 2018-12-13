package com.project.hanlonglin.classsystem;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.project.hanlonglin.classsystem.view.layout.fragment.AboutFragment;
import com.project.hanlonglin.classsystem.view.layout.fragment.ChooseFragment;
import com.project.hanlonglin.classsystem.view.layout.fragment.FirstFragment;

public class MainActivity extends AppCompatActivity {

    RadioGroup ragroup;
    LinearLayout li_container;

    FragmentManager fgManager;
    Fragment fg_first,fg_choose,fg_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fgManager=getFragmentManager();
        initView();
    }

    private void initView() {
        li_container=(LinearLayout)findViewById(R.id.li_container);
        ragroup=(RadioGroup)findViewById(R.id.raGroup);
        ragroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                FragmentTransaction fgTrasaction=fgManager.beginTransaction();
                hideAll(fgTrasaction);
                switch (i) {
                    case R.id.ra_first:
                        if(fg_first==null){
                            fg_first=new FirstFragment();
                            fgTrasaction.add(R.id.li_container,fg_first);
                        }
                        fgTrasaction.show(fg_first);
                        break;
                    case R.id.ra_choose:
                        if(fg_choose==null){
                            fg_choose=new ChooseFragment();
                            fgTrasaction.add(R.id.li_container,fg_choose);
                        }
                        fgTrasaction.show(fg_choose);
                        break;
                    case R.id.ra_about:
                        if(fg_about==null){
                            fg_about=new AboutFragment();
                            fgTrasaction.add(R.id.li_container,fg_about);
                        }
                        fgTrasaction.show(fg_about);
                        break;
                }
                fgTrasaction.commit();
            }
        });
        ragroup.check(R.id.ra_about);
    }

    private void hideAll(FragmentTransaction fgTrasaction) {
        if(fg_first!=null) fgTrasaction.hide(fg_first);
        if(fg_choose!=null) fgTrasaction.hide(fg_choose);
        if(fg_about!=null) fgTrasaction.hide(fg_about);
    }
}
