package com.gitlab.crisacm.recipes.ui.splash

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gitlab.crisacm.recipes.R
import com.gitlab.crisacm.recipes.ui.navigation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(key1 = true) {
        // Mientras se realizan los servicios se implement el delay para hacer la simulación de datos
        delay(1000)
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }

    Splash()
}


@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_cooking),
            contentDescription = "icon",
            modifier = Modifier.size(100.dp, 100.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}