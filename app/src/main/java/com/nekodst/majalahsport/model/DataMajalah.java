package com.nekodst.majalahsport.model;

import java.util.ArrayList;
import java.util.List;

public class DataMajalah {
    public static String[][] data = new String[][]{
            {"BollaVaganza"
                    , "Sebagai majalah khusus seputar sepakbola, Bolavaganza beredar dengan tagline “Pesona Sepak Bola”. Buat penggemar info dengan penyampaian yang ringan, tak salah kalau kamu memilih majalah Bolavaganza. Meskipun bahasanya ringan, tapi majalah ini tetap padat informasi. Baik mengenai manajeman klub, sampai persiapan atlet sebelum turun ke lapangan.\n" +
                    "\n" +
                    "Mulai November 2016 lalu, majalah yang terbit bulanan ini memperluas bahasannya. Tidak hanya membahas persepakbolaan, tapi juga konten MotoGP dan F1 yang juga sangat digemari oleh generasi muda. Majalah Bolavaganza edisi Oktober 2017 bisa juga kamu beli di blibli.com dengan harga Rp 30.000."
                    , "16.000"
                    , "Bola"
                    , "21 November 2016"
                    , "https://ds393qgzrxwzn.cloudfront.net/resize/m720x480/cat1/img/images/0/w3BNaqUAWp.jpg"
                    , "0"},
            {"Multisport"
                    , "Sebagai majalah khusus seputar sepakbola, Bolavaganza beredar dengan tagline “Pesona Sepak Bola”. Buat penggemar info dengan penyampaian yang ringan, tak salah kalau kamu memilih majalah Bolavaganza. Meskipun bahasanya ringan, tapi majalah ini tetap padat informasi. Baik mengenai manajeman klub, sampai persiapan atlet sebelum turun ke lapangan.\n" +
                    "\n" +
                    "Mulai November 2016 lalu, majalah yang terbit bulanan ini memperluas bahasannya. Tidak hanya membahas persepakbolaan, tapi juga konten MotoGP dan F1 yang juga sangat digemari oleh generasi muda. Majalah Bolavaganza edisi Oktober 2017 bisa juga kamu beli di blibli.com dengan harga Rp 30.000."
                    , "16.000"
                    , "Bike"
                    , "21 November 2016"
                    , "https://s3-ap-southeast-1.amazonaws.com/ebook-previews/16146/61899/1.jpg"
                    , "1"},
            {"Skate X Roll"
                    , "Nggak hanya sepak bola atau motor racing yang jadi pilihan industri majalah, karena sebenarnya banyak sekali olahraga dengan pangsa pasar yang jelas, dan perkembangannya. Seperti skateboarding yang mendorong penerbit mempublikasikan majalah Skate X Roll.\n" +
                    "\n" +
                    "Skateboarding, alias olahraga menggunakan papan skateboard ini juga terdapat dinamika yang menarik, sejak ditemukannya olahraga ini sekitar dekade 40-an sampai dengan 60-an. Skaters alias pemain skateboard memainkan papan skateboard sebagaimana surfer yang memainkan papan surfing di laut. Dan skateboard memang bentuk improvisasi olahraga selancar air.\n" +
                    "\n" +
                    "Buat kaum muda yang menyukai tantangan menjadi skaters, majalah Skate X Roll bisa jadi sumber info yang lengkap. Di majalah ini bukan hanya info mengenai produk skateboard rancangan terbaru, tapi juga berbagai info kejuaraan skateboarding nasional dan internasional, dan pendapat para atlet yang inspiratif buat penggemar olahraga ini.\n" +
                    "\n" +
                    "Nah, buat kamu yang penasaran dengan majalahnya, kamu bisa memesannya segera di Skaterollmagz dengan harga Rp 35.000."
                    , "15.000"
                    , "Skateboard"
                    , "21 November 2016"
                    , "https://ds393qgzrxwzn.cloudfront.net/resize/m720x480/cat1/img/images/0/aASuYmOSPi.jpg"
                    , "0"}
    };

    

    public static List<Majalah> getListMajalah(){
        Majalah majalah = null;
        List<Majalah> majalahs = new ArrayList<>();

        for (String[] aData:data) {
            majalah = new Majalah();
            majalah.setJudul(aData[0]);
            majalah.setDetail(aData[1]);
            majalah.setHarga(aData[2]);
            majalah.setKategori(aData[3]);
            majalah.setTgl_rilis(aData[4]);
            majalah.setFoto(aData[5]);
            majalah.setIsFavorite(aData[6]);

            majalahs.add(majalah);
        }

        return majalahs;
    }

}
