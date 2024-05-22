package com.example.kisileruygulamasi

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.viewmodel.KisiDetayViewModel
import com.example.kisileruygulamasi.viewmodel.KisiKayitViewModel

class KisiDetaySayfa(private val gelenKisi:Kisiler): Screen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val tfKisiAd = remember { mutableStateOf("") }
        val tfKisiTel = remember { mutableStateOf("") }
        val localFocusManager = LocalFocusManager.current // geri tuşuna bastığımızda tek seferde textfielddaki seçimi kaldıracağız (normalde 2 kere basarak geri dönmek zorundayız bu kod ile tek seferde geri döneceğiz)

        val viewModel = rememberScreenModel { KisiDetayViewModel() }

        LaunchedEffect(key1 = true) {
            tfKisiAd.value = gelenKisi.kisi_ad
            tfKisiTel.value = gelenKisi.kisi_tel
            
        }
        
        Scaffold (
            topBar = {
                TopAppBar(title = { Text(text = "Kişi Detay") })

            },
            content = {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = tfKisiAd.value,
                        onValueChange = {tfKisiAd.value = it},
                        label = { Text(text = "Kişi Adı")})

                    TextField(
                        value = tfKisiTel.value,
                        onValueChange = {tfKisiTel.value = it},
                        label = { Text(text = "Kişi Tel")})
                    Button(onClick = {
                        val kisi_adi = tfKisiAd.value
                        val kisi_tel = tfKisiTel.value
                        viewModel.guncelleme(gelenKisi.kisi_id, kisi_adi, kisi_tel)

                        localFocusManager.clearFocus()

                    }, modifier = Modifier.size(250.dp, 50.dp)) {
                        Text(text = "Güncelle")

                    }

                }

            }
        )
    }

}