package com.fanfy.listviewcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lv_main)
    ListView mListView;

    List<Person> datas = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        for(int i = 0;i<20;i++){
            datas.add(new Person("张三"+i));
        }

        final MyAdapter myAdapter = new MyAdapter(this);
        myAdapter.setDatas(datas);
        mListView.setAdapter(myAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(Person person : datas){
                    person.setChecked(false);
                }

                if(currentNum == -1){ //选中
                    datas.get(position).setChecked(true);
                    currentNum = position;
                }else if(currentNum == position){ //同一个item选中变未选中
                    for(Person person : datas){
                        person.setChecked(false);
                    }
                    currentNum = -1;
                }else if(currentNum != position){ //不是同一个item选中当前的，去除上一个选中的
                    for(Person person : datas){
                        person.setChecked(false);
                    }
                    datas.get(position).setChecked(true);
                    currentNum = position;
                }

                Toast.makeText(parent.getContext(),datas.get(position).getTitle(),Toast.LENGTH_SHORT).show();
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
