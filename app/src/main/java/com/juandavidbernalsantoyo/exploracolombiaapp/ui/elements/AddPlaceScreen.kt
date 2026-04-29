package com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colores del tema
private val OrangePrimary = Color(0xFFD95A2B)
private val OrangeLight = Color(0xFFE8724A)
private val BackgroundColor = Color(0xFFF2F2F7)
private val CardBackground = Color(0xFFFFFFFF)
private val FieldBackground = Color(0xFFE8E8ED)
private val LabelColor = Color(0xFF8E8E93)
private val TextColor = Color(0xFF1C1C1E)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPlaceScreen(
    onBackClick: () -> Unit = {}
) {
    var nombreLugar by remember { mutableStateOf("") }
    var departamento by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Place",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = OrangePrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = OrangePrimary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                )
            )
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Banner superior con gradiente naranja
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(OrangeLight, OrangePrimary)
                        )
                    )
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Comparte tu\ndescubrimiento",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Ayuda a otros viajeros a encontrar los tesoros\nescondidos de nuestra tierra.",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )
                }
            }

            // Card del formulario
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    // Campo: Nombre del lugar
                    FormField(
                        label = "NOMBRE DEL LUGAR",
                        value = nombreLugar,
                        onValueChange = { nombreLugar = it },
                        placeholder = "Ej: Cascada del Fin del Mundo"
                    )

                    // Campo: Departamento
                    FormField(
                        label = "DEPARTAMENTO",
                        value = departamento,
                        onValueChange = { departamento = it },
                        placeholder = "Ej: Putumayo"
                    )

                    // Campo: Ciudad
                    FormField(
                        label = "CIUDAD",
                        value = ciudad,
                        onValueChange = { ciudad = it },
                        placeholder = "Ej: Mocoa"
                    )

                    // Campo: Descripción (multilinea)
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "DESCRIPCIÓN",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = LabelColor,
                            letterSpacing = 0.8.sp
                        )
                        TextField(
                            value = descripcion,
                            onValueChange = { descripcion = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            placeholder = {
                                Text(
                                    text = "Cuéntanos por qué este lugar es especial...",
                                    color = Color(0xFFAEAEB2),
                                    fontSize = 14.sp
                                )
                            },
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = FieldBackground,
                                focusedContainerColor = FieldBackground,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                cursorColor = OrangePrimary
                            ),
                            shape = RoundedCornerShape(10.dp),
                            maxLines = 5
                        )
                    }
                }
            }

            // Botón Publicar
            Button(
                onClick = { /* TODO: lógica de publicar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = OrangePrimary
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Publicar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = LabelColor,
            letterSpacing = 0.8.sp
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFFAEAEB2),
                    fontSize = 14.sp
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = FieldBackground,
                focusedContainerColor = FieldBackground,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = OrangePrimary
            ),
            shape = RoundedCornerShape(10.dp),
            singleLine = true
        )
    }
}