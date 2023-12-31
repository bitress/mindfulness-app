package com.bitress.thirtydaysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.bitress.thirtydaysapp.ui.theme.Montserrat
import com.bitress.thirtydaysapp.ui.theme.ThirtyDaysAppTheme
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_background
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_onPrimaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_onSecondary
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_onSecondaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_onTertiary
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_onTertiaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_primaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_secondaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_tertiary
import com.bitress.thirtydaysapp.ui.theme.md_theme_dark_tertiaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_light_background
import com.bitress.thirtydaysapp.ui.theme.md_theme_light_onTertiaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_light_primaryContainer
import com.bitress.thirtydaysapp.ui.theme.md_theme_light_tertiary
import com.bitress.thirtydaysapp.ui.theme.md_theme_light_tertiaryContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MindfulnessInThirtyDays()
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MindfulnessInThirtyDays() {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Mindfulness in 30 Days",
                            style = TextStyle(
                                fontFamily = Montserrat,
                                color = md_theme_dark_background,
                                fontSize = 20.sp
                            ))
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = md_theme_light_tertiaryContainer)
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                LazyColumn {
                    items(self_cares) {
                        MindfulnessItem(self_care = it)
                    }
                }
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
                .padding(8.dp)
        ) {
            MindfulnessInformation(self_care.imageResourceId, self_care.wellnessTitle, self_care.wellnessDescription, self_care.timeSpent)
        }

    }

    @Composable
    fun MindfulnessButton(
        expanded: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ){
        IconButton(onClick = onClick, modifier = modifier) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null,
                tint = md_theme_light_background
            )
        }
    }


    @Composable
    fun MindfulnessInformation(
        @DrawableRes imageResource: Int,
        @StringRes wellnessTitle: Int,
        @StringRes wellnessDescription: Int,
        timeSpent: Int,
        modifier: Modifier = Modifier
    ) {

        var expanded by remember { mutableStateOf(false)}

        Card(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = md_theme_dark_secondaryContainer
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(wellnessTitle),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = md_theme_dark_onSecondaryContainer
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(bottom = 8.dp)
                    )

                    MindfulnessButton(expanded = expanded, onClick = { expanded = !expanded })
                }

                if (expanded) {
                    Column (modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = stringResource(wellnessDescription),
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = md_theme_dark_onSecondaryContainer
                            ),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = stringResource(R.string.hours_spent, timeSpent),
                            style = TextStyle(
                                fontStyle = FontStyle.Italic,
                                color = md_theme_dark_onSecondaryContainer,
                                fontSize = 12.sp
                            )
                        )
                    }

                }
            }
        }
    }



    @Preview
    @Composable
    fun WellnessPreview() {
        ThirtyDaysAppTheme(darkTheme = true) {
            MindfulnessInThirtyDays()
        }
    }
}
