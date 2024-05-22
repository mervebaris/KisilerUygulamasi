package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import cafe.adriel.voyager.core.model.ScreenModel
import com.example.kisileruygulamasi.repo.KisilerDaoRepository

class KisiDetayViewModel : ScreenModel {

    var krepo = KisilerDaoRepository()  //AnaSayfadaki butona bastığımızda repo içerisindeki fonksiyonu çalıştıracağız bunun için bir nesneye ihtiyacımız var --> krepo = KisilerDaoRepository() diyerek nesneyi çağırdık

    fun guncelleme(kisi_id:Int, kisi_adi:String, kisi_tel:String){ //Kişi Güncelleme için bir fonksiyonumuz olacak --> kisi_id:Int, kisi_adi:String, kisi_tel:String parametrelerini alacak güncelleme için dışarıdan veri alıyoruz bu şekilde
        krepo.kisiGuncelleme(kisi_id,kisi_adi,kisi_tel)
    }
}