package com.example.kisileruygulamasi.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisileruygulamasi.entity.Kisiler

class KisilerDaoRepository {
    var kisilerListesi = MutableLiveData<List<Kisiler>>() //Livedata özelliğine sahip liste yaptık Arayüzde güncelleme yapacağız. (Bu bize Liste getirecek içerisinde kişiler sınıfından nesneler olacak --> <List<Kisiler>>())

    init {
        kisilerListesi = MutableLiveData<List<Kisiler>>()
    }

    fun kisileriGetir():MutableLiveData<List<Kisiler>>{ //BAĞLANTI FONKSİYONU !!!!!!!!!! --- Bu fonksiyon işelemi ile AnaSayfaViewModel içerisindeki Livedataya bağlıyoruz. AnaSayfadaki LiveDatada arayüzdeki livedatayı (state özelliği olan değişkeni) tetikleyecek bu şekilde arayüze verileri iletmiş olacağız
        return kisilerListesi
    }

    fun tumKisileriAl(){
        val liste = mutableListOf<Kisiler>() //Liste tanımlıyoruz kisiler sınıfından nesneleri sana aktaracağız diyoruz --> mutableListOf<Kisiler>

        val k1 = Kisiler(1,"Ahmet","11111")
        val k2 = Kisiler(1,"Zeynep","22222")

        liste.add(k1)
        liste.add(k2)
        kisilerListesi.value = liste //Bu yukarıdaki listemizi kisilerListesi Livedataya aktaracağız bu arayüze bu listeyi iletiçek Livedata state gibi çalıştığından --> kisilerListesi.value diyoruz
    }

    fun kisiAra(aramaKelimesi:String){  //Arama işlemi için bir fonksiyonumuz olacak dışarıdanda --> aramaKelimesi:String türünden bir veri gelecek
        Log.e("Kişi arama", aramaKelimesi) //it yerine aramaKelimesi olacak --> Log.e("Kişi arama", it)
    }

    fun kisiKayit(kisi_adi:String, kisi_tel:String){ //Kişi Kayıt için bir fonksiyonumuz olacak --> kisi_ad:String, kisi_tel:String parametresi giriyoruz - veri türü istiyoruz bunlarla kayıt yapcağız
        Log.e("Kişi Kayıt", "$kisi_adi - $kisi_tel")
    }

    fun kisiGuncelleme(kisi_id:Int, kisi_adi:String, kisi_tel:String){ //Kişi Güncelleme için bir fonksiyonumuz olacak --> kisi_id:Int, kisi_adi:String, kisi_tel:String parametrelerini alacak güncelleme için dışarıdan veri alıyoruz bu şekilde
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_adi - $kisi_tel")
    }

    fun kisiSil(kisi_id:Int){
        Log.e("Kişi Sil", "$kisi_id") //Kişi silme için bir fonksiyonumuz olacak --> kisi_id:Int parametresini alarak kisi_id:Int türden veri istiyoruz
    }

}