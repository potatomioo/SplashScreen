package com.example.splashscreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.splashscreen.ui.theme.Purple40
import kotlinx.coroutines.delay

@Composable
fun splash(
    navController :NavHostController
) {
    var isActive by remember {
        mutableStateOf(false)
    }
    val animatedstate = animateFloatAsState(
        targetValue = if(isActive) 1f else 0f,
        animationSpec = tween(
            durationMillis = 5000
        )
    )
    
    //when it is launched this effect will work
    LaunchedEffect(key1 = true) {
        isActive = true
        delay(4000)
        navController.navigate("HomeScreen")
    }
    splashScreen(alpha = animatedstate.value)
}

@Composable
fun splashScreen(
    alpha : Float
) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Purple40),
        contentAlignment = Alignment.Center
    ){
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Mail",
            modifier = Modifier
                .size(50.dp)
                .alpha(alpha = alpha),
            tint = Color.White
        )
    }
}