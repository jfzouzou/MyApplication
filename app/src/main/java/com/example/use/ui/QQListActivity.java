package com.example.use.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.base.BaseActivity;
import com.util.QQListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zy on 2016/11/1.
 */

public class QQListActivity extends BaseActivity {

    private QQListView mListView;
    private List<String> mDatas;
    private ArrayAdapter<String> mAdapter;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqlist);
        mListView = (QQListView) findViewById(R.id.qqlist);

        // 不要直接Arrays.asList
        mDatas = new ArrayList<String>(Arrays.asList("HelloWorld", "Welcome", "Java", "Android", "Servlet", "Struts",
                "Hibernate", "Spring", "HTML5", "Javascript", "Lucene"));
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas);
        mListView.setAdapter(mAdapter);

       mListView.setDelButtonClickListener(new QQListView.DelButtonClickListener() {
           @Override
           public void clickHappend(int position) {
               Toast.makeText(QQListActivity.this, position + " : " + mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
               mAdapter.remove(mAdapter.getItem(position));
           }
       });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QQListActivity.this, position + " : " + mAdapter.getItem(position), Toast.LENGTH_LONG).show();
            }
        });
    }

//    class DelButtonClickListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//
//        }
//    }
}
