package com.nekodst.majalahsport.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.DataMajalah;
import com.nekodst.majalahsport.model.Majalah;
import com.nekodst.majalahsport.ui.fragment.ReadFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    List<Majalah> majalahs;
    TextView judul, detail, rilis, harga, kategori;
    ImageView foto;
    Button share, read;
    FloatingActionButton fab_fav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();

        Intent intent = getIntent();
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        if (appLinkData != null){
            intent.putExtra("id", appLinkData.getQueryParameter("id"));
        }
        final int id = Integer.parseInt(intent.getStringExtra("id"));

        initArrays();

        setViewComponent(id);

        buttonAction(id);
    }

    private void buttonAction(final int id) {
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadFragment fragment = new ReadFragment();

                fragment.setId(id);

//                FragmentManager fm = getSupportFragmentManager();
//                fm.beginTransaction().add(R.id.layout_cons_id,fragment).commit();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.layout_cons_id, fragment).commit();

            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/link");
                String shareBody = "Share via";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share to...");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, "Visit this link to read the megazine http://majalah-sport.co/detail?id="+id);
                sharingIntent.putExtra("Id", id);
                startActivity(Intent.createChooser(sharingIntent, shareBody));
            }
        });

        fab_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(majalahs.get(id).getIsFavorite()).equals("0")){
                    Glide.with(getApplicationContext())
                            .load(R.drawable.ic_action_favset)
                            .into(fab_fav);
                    majalahs.get(id).setIsFavorite("1");
                }
                else {
                    Glide.with(getApplicationContext())
                            .load(R.drawable.ic_action_fav)
                            .into(fab_fav);
                    majalahs.get(id).setIsFavorite("0");
                }
            }
        });
    }

    private void setViewComponent(int id) {
        judul.setText("Title\t: "+majalahs.get(id).getJudul());
        detail.setText(majalahs.get(id).getDetail());
        harga.setText("Price\t\t\t: Rp "+majalahs.get(id).getHarga());
        kategori.setText("Category\t: "+majalahs.get(id).getKategori());
        rilis.setText("Release\t: "+majalahs.get(id).getTgl_rilis());

        Glide.with(getApplicationContext())
                .load(majalahs.get(id).getFoto())
                .apply(new RequestOptions())
                .into(foto);

        if (String.valueOf(majalahs.get(id).getIsFavorite()).equals("1")){
            Glide.with(getApplicationContext())
                    .load(R.drawable.ic_action_favset)
                    .into(fab_fav);
        }
        else {
            Glide.with(getApplicationContext())
                    .load(R.drawable.ic_action_fav)
                    .into(fab_fav);
        }
    }

    private void initArrays() {
        majalahs = new ArrayList<>();
        majalahs = DataMajalah.getListMajalah();
    }

    private void initView() {
        foto = findViewById(R.id.foto);

        detail = findViewById(R.id.detail);
        judul = findViewById(R.id.judul);
        harga = findViewById(R.id.harga);
        kategori = findViewById(R.id.kategori);
        rilis = findViewById(R.id.tgl_rilis);

        share = findViewById(R.id.share);
        read = findViewById(R.id.read);
        fab_fav = findViewById(R.id.fab_fav);
    }
}
