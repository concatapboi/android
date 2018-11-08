package com.example.hien.ot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends Activity {
    TextView txtName, txtPhone, txtCMND;
    Button btAdd, btUpdate;
    RadioGroup radioGroup;
    ListView lv;
    MyAdapter adap;
    ArrayList<Prisoner> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ot2);
        addControlls();
        String[] val = getResources().getStringArray(R.array.ds);
        adap = new MyAdapter(this, arr);
        lv.setAdapter(adap);
        addEvents();
    }

    private void addEvents() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten, phone;
                int gt, cmnd;
                ten = txtName.getText().toString();
                phone = txtPhone.getText().toString();
                gt = (radioGroup.getCheckedRadioButtonId() == R.id.rad1) ? 1 : 0;
                if (ten.isEmpty() || phone.isEmpty() || txtCMND.getText().toString().isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Chua nhap lieu day du", Toast.LENGTH_LONG).show();
                } else {
                    cmnd = Integer.parseInt(txtCMND.getText().toString());
                    Prisoner tam = new Prisoner(ten, gt, cmnd, phone);
                    arr.add(tam);
                    adap.notifyDataSetChanged();
                }
                txtName.setText("");
                txtCMND.setText("");
                txtPhone.setText("");
                txtName.requestFocus();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                btUpdate.setEnabled(true);
                Prisoner tam;
                tam = arr.get(position);
                txtName.setText(tam.getName());
                txtPhone.setText(tam.getPhone());
                txtCMND.setText(String.valueOf(tam.getCmnd()));
                if (tam.getGt() == 1)
                    radioGroup.check(R.id.rad1);
                else if (tam.getGt() == 1)
                    radioGroup.check(R.id.rad1);
                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ten, phone;
                        int gt, cmnd;
                        ten = txtName.getText().toString();
                        phone = txtPhone.getText().toString();
                        gt = (radioGroup.getCheckedRadioButtonId() == R.id.rad1) ? 1 : 0;
                        if (ten.isEmpty() || phone.isEmpty() || txtCMND.getText().toString().isEmpty()) {
                            Toast.makeText(Main2Activity.this, "Chua nhap lieu day du", Toast.LENGTH_LONG).show();
                        } else {
                            cmnd = Integer.parseInt(txtCMND.getText().toString());
                            Prisoner tam = new Prisoner(ten, gt, cmnd, phone);
                            arr.set(position, tam);
                            adap.notifyDataSetChanged();
                        }
                        txtName.setText("");
                        txtCMND.setText("");
                        txtPhone.setText("");
                        txtName.requestFocus();
                        btUpdate.setEnabled(false);

                    }
                });
            }

        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder buil = new AlertDialog.Builder(Main2Activity.this);
                buil.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this, "Cancel!", Toast.LENGTH_LONG).show();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arr.remove(position);
                        adap.notifyDataSetChanged();
                        Toast.makeText(Main2Activity.this, "Done!", Toast.LENGTH_LONG).show();
                    }
                });
                buil.setTitle("Delete?");
                buil.create();
                buil.show();
                return false;
            }
        });
    }

    private void addControlls() {
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtCMND = findViewById(R.id.txtCMND);
        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        lv = findViewById(R.id.list);
        radioGroup = findViewById(R.id.radGr);
        arr = new ArrayList<Prisoner>();
        btUpdate.setEnabled(false);
    }
}
