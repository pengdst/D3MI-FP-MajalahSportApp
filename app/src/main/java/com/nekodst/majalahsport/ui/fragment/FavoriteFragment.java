package com.nekodst.majalahsport.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nekodst.majalahsport.R;
import com.nekodst.majalahsport.model.DataMajalah;
import com.nekodst.majalahsport.ui.adapter.MajalahAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    RecyclerView recyclerView;
    MajalahAdapter majalahAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        String[][] favorite = new String[][]{
                {"BollaVaganza"
                        , "Sebagai majalah khusus seputar sepakbola, Bolavaganza beredar dengan tagline “Pesona Sepak Bola”. Buat penggemar info dengan penyampaian yang ringan, tak salah kalau kamu memilih majalah Bolavaganza. Meskipun bahasanya ringan, tapi majalah ini tetap padat informasi. Baik mengenai manajeman klub, sampai persiapan atlet sebelum turun ke lapangan.\n" +
                        "\n" +
                        "Mulai November 2016 lalu, majalah yang terbit bulanan ini memperluas bahasannya. Tidak hanya membahas persepakbolaan, tapi juga konten MotoGP dan F1 yang juga sangat digemari oleh generasi muda. Majalah Bolavaganza edisi Oktober 2017 bisa juga kamu beli di blibli.com dengan harga Rp 30.000."
                        , "16.000"
                        , "Bola"
                        , "21 November 2016"
                        , "https://ds393qgzrxwzn.cloudfront.net/resize/m720x480/cat1/img/images/0/w3BNaqUAWp.jpg"},
                {"Multisport"
                        , "Sebagai majalah khusus seputar sepakbola, Bolavaganza beredar dengan tagline “Pesona Sepak Bola”. Buat penggemar info dengan penyampaian yang ringan, tak salah kalau kamu memilih majalah Bolavaganza. Meskipun bahasanya ringan, tapi majalah ini tetap padat informasi. Baik mengenai manajeman klub, sampai persiapan atlet sebelum turun ke lapangan.\n" +
                        "\n" +
                        "Mulai November 2016 lalu, majalah yang terbit bulanan ini memperluas bahasannya. Tidak hanya membahas persepakbolaan, tapi juga konten MotoGP dan F1 yang juga sangat digemari oleh generasi muda. Majalah Bolavaganza edisi Oktober 2017 bisa juga kamu beli di blibli.com dengan harga Rp 30.000."
                        , "16.000"
                        , "Bike"
                        , "21 November 2016"
                        , "https://s3-ap-southeast-1.amazonaws.com/ebook-previews/16146/61899/1.jpg"}
        };
        recyclerView = view.findViewById(R.id.rv_items);

        initRecyclerView();
        return view;
    }

    private void initRecyclerView() {
        majalahAdapter = new MajalahAdapter(getContext());
        majalahAdapter.setMajalahs(DataMajalah.getListMajalah());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(majalahAdapter);
    }

}
