package com.bitress.thirtydaysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.bitress.thirtydaysapp.R

/**
 * A data class that will be presented in a card
 */
data class Wellness(
    @DrawableRes val imageResourceId: Int,
    @StringRes val wellnessTitle: Int,
    @StringRes val wellnessDescription: Int,
    val timeSpent: Int
)

val self_cares = listOf(
    Wellness(R.drawable.mindful_morning, R.string.wellness_title, R.string.wellness_description, 2),
    Wellness(R.drawable.digital_detox, R.string.wellness_title_2, R.string.wellness_description_2, 24),
    Wellness(R.drawable.emotional_wellness, R.string.wellness_title_3, R.string.wellness_description_3, 8),
    Wellness(R.drawable.healthy_habits, R.string.wellness_title_4, R.string.wellness_description_4, 12),
)