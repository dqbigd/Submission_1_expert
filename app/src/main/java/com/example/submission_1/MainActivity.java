package com.example.submission_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FilmAdapter filmAdapter;
    private String[] data_nama;
    private String[] data_desc;
    private TypedArray data_photo;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lvList);

        filmAdapter = new FilmAdapter(this);
        lv.setAdapter(filmAdapter);

        persiapan();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentDetail = new Intent(MainActivity.this, DetailActivity.class);
                Film film = new Film();

                //film.setName(data_nama[i]);
                //film.setDesc(data_desc[i]);
                //film.setPhoto(data_photo.getResourceId(i, -1));

                //untuk mengurangu boilerplate code maka dari intentDetail.putExtra(DetailActivity.EXTRA_FILM, film);
                intentDetail.putExtra(DetailActivity.EXTRA_FILM, films.get(i));
                startActivity(intentDetail);
            }
        });
    }

    private void persiapan() {
        data_nama = getResources().getStringArray(R.array.data_name);
        data_desc = getResources().getStringArray(R.array.data_description);
        data_photo = getResources().obtainTypedArray(R.array.data_photo);

        films = new ArrayList<>();

        for (int i = 0 ; i<data_nama.length; i++){
            Film film = new Film();

            film.setName(data_nama[i]);
            film.setDesc(data_desc[i]);
            film.setPhoto(data_photo.getResourceId(i, -1));
            films.add(film);
        }
        filmAdapter.setFilms(films);
    }
}
