package com.aniketkadam.wordcross

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Border
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.SolidColor
import androidx.ui.layout.*
import androidx.ui.layout.RowScope.gravity
import androidx.ui.material.Card
import androidx.ui.text.ParagraphStyle
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp
import com.aniketkadam.wordcross.ui.AppTheme


class WordGridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WordGridScreen(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
        }
    }
}

@Composable
fun WordGridScreen(letterList: List<Char>) {
    AppTheme {
        EntireWordGrid(letterList, "wordGrid")
    }
}

@Composable
fun EntireWordGrid(letterList: List<Char>, tag: String) {
    Column(modifier = Modifier.padding(3.dp)) {
        for (i in (0..8) step 3) {
            Row {
                letterList.subList(i, i + 3).forEach {
                    WordCard(name = it)
                }
            }
        }
    }
}

@Composable
fun WordCard(name: Char) {
    Card(
        border = Border(Dp.Hairline, SolidColor(Color.Black)),
        modifier = Modifier.padding(3.dp)
    ) {
        Text(
            text = name.toString(),
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WordGridScreen(listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
}