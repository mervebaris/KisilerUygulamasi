package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import cafe.adriel.voyager.core.model.ScreenModel
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class KisiKayitViewModel :ScreenModel {
    var krepo = KisilerDaoRepository()  //AnaSayfadaki butona bastığımızda repo içerisindeki fonksiyonu çalıştıracağız bunun için bir nesneye ihtiyacımız var --> krepo = KisilerDaoRepository() diyerek nesneyi çağırdık

    fun Kayit(kisi_adi:String, kisi_tel:String){
        krepo.kisiKayit(kisi_adi,kisi_tel)
    }


}