package com.example.hien.ot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    TextView txtName;
    Button btAdd,btUpdate;
    ListView lv;
    ArrayAdapter<String > adap;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName=findViewById(R.id.txtName);
        btAdd=findViewById(R.id.btAdd);
        btUpdate=findViewById(R.id.btUpdate);
        lv=findViewById(R.id.list);
        arr = new ArrayList<String>();
        String[] val = getResources().getStringArray(R.array.ds);
        for (String tam: val
             ) {
            arr.add(tam);
        }
        adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(adap);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
                txtName.setText(lv.getItemAtPosition(position).toString());
                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ten =txtName.getText().toString();
                        arr.set(position,ten);
                        adap.notifyDataSetChanged();
                    }
                });
            }

        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder buil = new AlertDialog.Builder(MainActivity.this);
                buil.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Cancel!",Toast.LENGTH_LONG).show();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arr.remove(position);
                        adap.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"Done!",Toast.LENGTH_LONG).show();
                    }
                });
                buil.setTitle("Delete?");
                buil.create();
                buil.show();
                return false;
            }
        });
    }
}
