package com.example.kisileruygulamasi

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.viewmodel.AnaSayfaViewModel

class AnaSayfa: Screen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val aramaYapiliyorMu = remember { mutableStateOf(false) }
        val tf = remember { mutableStateOf("") }
        val viewModel = remember { AnaSayfaViewModel() }
        val kisilerListesi = viewModel.kisilerListesi.observeAsState(listOf())  //veri işlemlerinde bunu yapıyoruz


        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        if (aramaYapiliyorMu.value){
                            TextField(
                                value = tf.value,
                                onValueChange = {
                                    tf.value = it
                                    viewModel.ara(it)
                                                },
                                label = { Text(text = "Ara")},
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    focusedTextColor = Color.Blue,
                                    focusedLabelColor = Color.White,
                                    focusedIndicatorColor = Color.Black,
                                    unfocusedLabelColor = Color.White,
                                    unfocusedIndicatorColor = Color.White,
                                ),
                                modifier = Modifier.padding(all = 30.dp)
                                )

                        }else{
                            Text(text = "Kişiler")

                        }
                    },
                    actions = {
                        if (aramaYapiliyorMu.value){
                            IconButton(onClick = {
                                aramaYapiliyorMu.value = false
                                tf.value = ""
                            }) {

                                Icon(painter = painterResource(id = R.drawable.kapat_resim),
                                    contentDescription = "", tint = Color.Black)
                            }


                        }else{
                            IconButton(onClick = {
                                aramaYapiliyorMu.value = true
                            }) {

                                Icon(painter = painterResource(id = R.drawable.arama_resim),
                                    contentDescription = "", tint = Color.Black)
                            }

                        }
                    }
                )

            },
            content = {
                LazyColumn {
                   items(
                       count = kisilerListesi.value!!.count(),    //!!nullable yapıdan korumak için yaptığımız yapı
                       itemContent = {
                           val kisi = kisilerListesi.value!![it]
                           Card(modifier = Modifier
                               .padding(all = 5.dp)
                               .fillMaxWidth()
                           ) {
                               Row(modifier = Modifier.clickable {
                                   navigator?.push(KisiDetaySayfa(gelenKisi = kisi))

                               }) {
                                   Row (modifier = Modifier
                                       .padding(all = 80.dp)
                                       .fillMaxWidth(),
                                       verticalAlignment = Alignment.CenterVertically,
                                       horizontalArrangement = Arrangement.SpaceBetween
                                   ) {
                                       Text(text = "${kisi.kisi_ad} - ${kisi.kisi_tel}")

                                       Icon(painter = painterResource(id = R.drawable.sil_resim),
                                           contentDescription = "", tint = Color.Gray)


                                       IconButton(onClick = {
                                         viewModel.sil(kisi.kisi_id)
                                       }) {
                                           Icon(painter = painterResource(id = R.drawable.sil_resim),
                                               contentDescription = "", tint = Color.Gray)
                                       }



                                   }

                               }

                           }
                       }
                   )

                }

            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator?.push(KisiKayitSayfa())
                    },
                    containerColor = Color.Magenta,
                    content = {
                        Icon(painter = painterResource(id = R.drawable.ekle_resim),
                            contentDescription = "", tint = Color.White)
                    }


                )
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun anasayfaPreview() {
    AnaSayfa().Content()
}