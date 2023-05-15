package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ListView list;
    static ArrayList<String> data = new ArrayList<>();    // リスト項目としてArrayListとして準備
    static ArrayAdapter<String> adapter;

    private void findView(){
        button1 = (Button) findViewById(R.id.button1);
        list = (ListView) findViewById(R.id.colorListView);
    }

    private void addItem() {
        // listに追加するitem
        data.add("red");
        data.add("green");
        data.add("blue");
    }

    private void setAdapter(){
        // 配列adapterを作成&ListViewに登録
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter) ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
        addItem();
        setAdapter();

        button1.setOnClickListener(view -> {
            data.add("black");
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
            list.setAdapter(adapter) ;
        });

        /*参考
        https://androidroid.info/post-30/
         */

        // リスト項目が選択されたときのイベント
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                 * 背景の色を変更する場合、layoutのIDを取得する
                 * i はリストのインデックス
                 */
                RelativeLayout layout = findViewById(R.id.mainActivity);
                switch (i){
                    case 0:
                        layout.setBackgroundColor(Color.rgb(255, 0, 0));
                        break;
                    case 1:
                        layout.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                    default:
                        layout.setBackgroundResource(R.drawable.airplane);
                }
            }
        });
    }
}