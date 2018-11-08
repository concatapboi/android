package com.example.hien.ot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context con;
    private ArrayList<Prisoner> arr;

    public MyAdapter(Context con, ArrayList<Prisoner> arr) {
        this.con = con;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView = LayoutInflater.from(con).inflate(R.layout.list,null);
            holder.txtName=convertView.findViewById(R.id.txtname);
            holder.txtPhone=convertView.findViewById(R.id.txtphone);
            holder.txtCMND=convertView.findViewById(R.id.txtcmnd);
            holder.img=convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();}
            Prisoner tam ;
            tam = arr.get(position);
            holder.txtName.setText(tam.getName());
            holder.txtPhone.setText(tam.getPhone());
            holder.txtCMND.setText(String.valueOf(tam.getCmnd()));
            if(tam.getGt()==1){
                holder.img.setImageResource(R.drawable.boy);
            }else if(tam.getGt()==0) {
                holder.img.setImageResource(R.drawable.girl);
            }

        return convertView;
    }
    class ViewHolder{
        TextView txtName,txtPhone,txtCMND;
        ImageView img;
    }
}
