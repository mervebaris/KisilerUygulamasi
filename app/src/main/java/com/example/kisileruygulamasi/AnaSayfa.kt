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

class AnaSayfa: Screen {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val aramaYapiliyorMu = remember { mutableStateOf(false) }
        val tf = remember { mutableStateOf("") }
        val kisilerListesi = remember { mutableStateListOf<Kisiler>() }
        
        LaunchedEffect(key1 = true) {
            val k1 = Kisiler(1,"Ahmet","11111")
            val k2 = Kisiler(1,"Zeynep","22222")

            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
        }

        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        if (aramaYapiliyorMu.value){
                            TextField(
                                value = tf.value,
                                onValueChange = {
                                    tf.value = it
                                    Log.e("Kişi arama", it)
                                                },
                                label = { Text(text = "Ara")},
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    focusedTextColor = Color.Black,
                                    focusedLabelColor = Color.White,
                                    focusedIndicatorColor = Color.White,
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
<<<<<<< HEAD

=======
>>>>>>> 27c197c (Initial commit)
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
                       count = kisilerListesi.count(),
                       itemContent = {
                           val kisi = kisilerListesi[it]
                           Card(modifier = Modifier
                               .padding(all = 5.dp)
                               .fillMaxWidth()
                           ) {
                               Row(modifier = Modifier.clickable {
                                   navigator?.push(KisiDetaySayfa(gelenKisi = kisi))

                               }) {
                                   Row (modifier = Modifier
                                       .padding(all = 10.dp)
                                       .fillMaxWidth(),
                                       verticalAlignment = Alignment.CenterVertically,
                                       horizontalArrangement = Arrangement.SpaceBetween
                                   ) {
                                       Text(text = "${kisi.kisi_ad} - ${kisi.kisi_tel}")
<<<<<<< HEAD
                                       Icon(painter = painterResource(id = R.drawable.sil_resim),
                                           contentDescription = "", tint = Color.Gray)
=======

                                       IconButton(onClick = {
                                         Log.e("Kişi Sil", "${kisi.kisi_id}")
                                       }) {
                                           Icon(painter = painterResource(id = R.drawable.sil_resim),
                                               contentDescription = "", tint = Color.Gray)
                                       }

>>>>>>> 27c197c (Initial commit)

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