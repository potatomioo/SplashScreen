package com.example.splashscreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController : NavHostController
) {
    var checked by remember {
        mutableStateOf(false)
    }
    val animateBlur by animateDpAsState(targetValue = if(checked) 4.dp else 0.dp)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Home Screen",
            modifier = Modifier.blur(
                radius = animateBlur,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
            style = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        ))
        Spacer(modifier = Modifier.height(50.dp))
        Switch(checked = checked, onCheckedChange = {checked = !checked})
    }
}