package com.example.submission_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    public Context context;
    private ArrayList<Film> films = new ArrayList<>();

    public void setFilms(ArrayList<Film> films){
        this.films = films;
    }

    public FilmAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);

        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Film film = (Film) getItem(i);
        viewHolder.bind(film);

        return itemView;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtDesc;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txtJudul);
            txtDesc = view.findViewById(R.id.txtDesc);
            imgPhoto = view.findViewById(R.id.imgPhoto);
        }

        void bind(Film film){
            txtName.setText(film.getName());
            txtDesc.setText(film.getDesc());
            Glide.with(context).load(film.getPhoto()).into(imgPhoto);
        }

    }
}
