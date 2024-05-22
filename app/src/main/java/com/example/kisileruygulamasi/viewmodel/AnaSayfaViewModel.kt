package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import cafe.adriel.voyager.core.model.ScreenModel
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class AnaSayfaViewModel : ScreenModel{
    var krepo = KisilerDaoRepository() //AnaSayfadaki butona bastığımızda repo içerisindeki fonksiyonu çalıştıracağız bunun için bir nesneye ihtiyacımız var --> krepo = KisilerDaoRepository() diyerek nesneyi çağırdık
    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()

    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()

    }

    fun ara(aramaKelimesi:String){
        krepo.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)
    }

}