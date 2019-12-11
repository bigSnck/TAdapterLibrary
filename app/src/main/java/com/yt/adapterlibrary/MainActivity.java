package com.yt.adapterlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRlv = findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();

        for(int i=0;i<30;i++){
            data.add("男男女女"+i);
        }
        mRlv.setAdapter(new ContentAdaper(this, data));

    }
}
