package com.example.userinput

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDaftar(modifier: Modifier) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var statusPk by remember { mutableStateOf("") }

    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textNama by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status: List<String> = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(Color(0xFF673AB7))
        ) {
            Text(
                "Formulir Pendaftaran",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_small)
                    ),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = dimensionResource(R.dimen.padding_small))
        ) {
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(dimensionResource(R.dimen.padding_small_medium))) {
                    Text(text = "NAMA LENGKAP")
                    OutlinedTextField(
                        value = textNama,
                        onValueChange = { textNama = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                bottom = dimensionResource(R.dimen.padding_small_medium)
                            ),
                        placeholder = { Text("tulis nama lengkap") },
                        singleLine = true
                    )

                    Text(text = "JENIS KELAMIN")
                    Column {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = {
                                        textJK = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }


                    Text(text = "STATUS PERKAWINAN")
                    Column {
                        status.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = {
                                        textStatus = item
                                    }
                                )
                                Text(item)
                            }
                        }
                    }

                    Text(text = "ALAMAT")
                    OutlinedTextField(
                        value = textAlamat,
                        onValueChange = { textAlamat = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = dimensionResource(R.dimen.padding_small),
                                bottom = dimensionResource(R.dimen.padding_small)
                            ),
                        placeholder = { Text("Alamat") },
                        singleLine = true
                    )

                    Button(
                        modifier = Modifier.fillMaxWidth(1f),

                        onClick = {
                            nama = textNama
                            jenis = textJK
                            statusPk = textStatus
                            alamat = textAlamat
                        }

                    ) {
                        Text(stringResource(R.string.submit))
                    }
                }
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .height(115.dp)
                    .padding(top = dimensionResource(R.dimen.padding_small))
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp)) {
                    Text(text = "NAMA : " + nama)
                    Text(text = "JENIS KELAMIN : " + jenis)
                    Text(text = "STATUS PERKAWINAN : " + statusPk)
                    Text(text = "ALAMAT : " + alamat)
                }
            }
        }

    }
}