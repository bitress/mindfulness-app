package com.bitress.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bitress.thirtydaysapp.data.Wellness
import com.bitress.thirtydaysapp.data.self_cares
import com.bitress.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MindfulnessInThirtyDays()
                }
            }
        }
    }

    @Composable
    fun MindfulnessInThirtyDays() {
        LazyColumn {
            items(self_cares) {
                MindfulnessItem (self_care = it)
            }
        }
    }

     @Composable
    fun MindfulnessItem(
         self_care: Wellness,
         modifier: Modifier = Modifier
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            MindfulnessImage(self_care.imageResourceId)
            MindfulnessInformation(self_care.wellnessTitle, self_care.wellnessDescription, self_care.timeSpent)
        }

    }

    @Composable
    fun MindfulnessInformation(
        @StringRes wellnessTitle: Int,
        @StringRes wellnessDescription: Int,
        timeSpent: Int,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(wellnessTitle),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(wellnessDescription),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.hours_spent, timeSpent),
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 14.sp
                    )
                )
            }
        }
    }




    @Composable
    fun MindfulnessImage(@DrawableRes mindfulnessImage: Int, modifier: Modifier = Modifier) {

        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(
                    dimensionResource(R.dimen.padding_small)
                ),
            painter = painterResource(mindfulnessImage),
        contentDescription = null
        )
    }

    @Preview
    @Composable
    fun WoofPreview() {
        ThirtyDaysAppTheme(darkTheme = false) {
            MindfulnessInThirtyDays()
        }
    }
}
