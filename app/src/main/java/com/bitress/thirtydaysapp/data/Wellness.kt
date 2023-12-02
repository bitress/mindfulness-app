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
    Wellness(R.drawable.creativity_boost, R.string.wellness_title_5, R.string.wellness_description_5, 15),
    Wellness(R.drawable.relaxation_techniques, R.string.wellness_title_6, R.string.wellness_description_6, 7),
    Wellness(R.drawable.mindful_walking, R.string.wellness_title_7, R.string.wellness_description_7, 19),
    Wellness(R.drawable.gratitude_journaling, R.string.wellness_title_8, R.string.wellness_description_8, 3),
    Wellness(R.drawable.deep_breathing_exercises, R.string.wellness_title_9, R.string.wellness_description_9, 22),
    Wellness(R.drawable.stretching_and_yoga, R.string.wellness_title_10, R.string.wellness_description_10, 14),
    Wellness(R.drawable.no_social_media_day, R.string.wellness_title_11, R.string.wellness_description_11, 5),
    Wellness(R.drawable.read_a_physical_book, R.string.wellness_title_12, R.string.wellness_description_12, 20),
    Wellness(R.drawable.outdoor_nature_walk, R.string.wellness_title_13, R.string.wellness_description_13, 9),
    Wellness(R.drawable.no_social_media_day, R.string.wellness_title_14, R.string.wellness_description_14, 17),
    Wellness(R.drawable.gratitude_journaling, R.string.wellness_title_15, R.string.wellness_description_15, 11),
    Wellness(R.drawable.relaxation_techniques, R.string.wellness_title_16, R.string.wellness_description_16, 4),
    Wellness(R.drawable.practice_self_compassion, R.string.wellness_title_17, R.string.wellness_description_17, 23),
    Wellness(R.drawable.connect_with_loved_ones, R.string.wellness_title_18, R.string.wellness_description_18, 16),
    Wellness(R.drawable.relaxation_techniques, R.string.wellness_title_19, R.string.wellness_description_19, 8),
    Wellness(R.drawable.gratitude_jar, R.string.wellness_title_20, R.string.wellness_description_20, 21),
    Wellness(R.drawable.hydration_day, R.string.wellness_title_21, R.string.wellness_description_21, 10),
    Wellness(R.drawable.balanced_nutrition_day, R.string.wellness_title_22, R.string.wellness_description_22, 6),
    Wellness(R.drawable.eight_hours_of_sleep, R.string.wellness_title_23, R.string.wellness_description_23, 18),
    Wellness(R.drawable.mindful_eating, R.string.wellness_title_24, R.string.wellness_description_24, 13),
    Wellness(R.drawable.emotional_wellness, R.string.wellness_title_25, R.string.wellness_description_25, 2),
    Wellness(R.drawable.hot_bath_or_spa_day, R.string.wellness_title_26, R.string.wellness_description_26, 24),
    Wellness(R.drawable.listen_to_calming_music, R.string.wellness_title_27, R.string.wellness_description_27, 1),
    Wellness(R.drawable.guided_imagery_meditation, R.string.wellness_title_28, R.string.wellness_description_28, 25),
    Wellness(R.drawable.aromatherapy, R.string.wellness_title_29, R.string.wellness_description_29, 7),
    Wellness(R.drawable.reflection_and_goal_setting, R.string.wellness_title_30, R.string.wellness_description_30, 12),
)