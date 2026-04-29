package com.juandavidbernalsantoyo.exploracolombiaapp.ui.elements

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToAddPlace: () -> Unit){
    Scaffold(
        topBar = {
            TopAppBar(title={
                Text(text = "Explora Colombia")
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {onNavigateToAddPlace()}) {
                Icon(Icons.Default.Add, contentDescription=null)
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding( innerPadding)){

        }
    }
}
