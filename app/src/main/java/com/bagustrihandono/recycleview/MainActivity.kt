package com.bagustrihandono.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

            }

        })
    }
}