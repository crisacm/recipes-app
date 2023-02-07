package com.gitlab.crisacm.recipes.ui.screens

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.gitlab.crisacm.recipes.R


@Composable
fun MainScreen() {
    MainContent()
}

@Composable
fun MainContent() {
    val constrains = ConstraintSet {
        val image = createRefFor("img")
        val title = createRefFor("txt_title")
        val desc = createRefFor("txt_desc")
        val button = createRefFor("btn")

        constrain(image) {
            top.linkTo(parent.top)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(title) {
            top.linkTo(image.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(desc) {
            top.linkTo(title.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(button) {
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
    }

    ConstraintLayout(constrains, modifier = Modifier.fillMaxSize()) {
        ImageElement(
            modifier = Modifier
                .fillMaxWidth()
                .padding(56.dp)
                .layoutId("img")
        )
        Text(
            text = LocalContext.current.resources.getString(R.string.txt_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(56.dp, 0.dp, 56.dp, 0.dp)
                .layoutId("txt_title"),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )
        Text(
            text = LocalContext.current.resources.getString(R.string.txt_desc),
            modifier = Modifier
                .fillMaxWidth()
                .padding(56.dp, 12.dp, 56.dp, 12.dp)
                .layoutId("txt_desc"),
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center
        )
        ButtonElement(
            modifier = Modifier
                .fillMaxWidth()
                .padding(56.dp)
                .layoutId("btn")
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainContent()
}


@Composable
fun ImageElement(modifier: Modifier) {
    val bitmapOptions = BitmapFactory.Options()
    val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources,
        R.drawable.cooking,
        bitmapOptions
    )

    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Background image",
        modifier = modifier
    )
}


@Composable
fun ButtonElement(modifier: Modifier) {
    val btnColor = Color(android.graphics.Color.parseColor("#E67E22"))

    Button(
        onClick = { /*TODO*/ },
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = btnColor)
    ) {
        Text(text = "A COCINAR", fontSize = 18.sp)
    }
}