package com.bagustrihandono.recycleview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bagustrihandono.recycleview.adapter.AdapterTeamBola
import com.bagustrihandono.recycleview.databinding.ActivityMainBinding
import com.bagustrihandono.recycleview.model.Pemain


class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain(" Adi Satrio",R.drawable.adisatrio,"kiper","1,79m","tangerang","07 juli 2001"))
        listPemain.add(Pemain(" Ernando Ari",R.drawable.ernandoari,"kiper","1,77 m","Semarang","27 Februari 2002"))
        listPemain.add(Pemain(" Bagas Kaffa",R.drawable.bagaskaffa,"bek","1,79m","Magelang","16 Januari 2002"))
        listPemain.add(Pemain(" Komang Teguh",R.drawable.komangteguh,"bek","1,76 m","bangli","28 April 2002"))
        listPemain.add(Pemain(" Pratama Arhan",R.drawable.pratamaarhan,"bek","1,7 m","Blora","21 December 2002"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.onClickListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtnamapemain)
                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })
    }
}