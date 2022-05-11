package com.epicood.texnodev.domain.model

import androidx.annotation.DrawableRes
import com.epicood.texnodev.R

sealed class OnBoardingPage(

    @DrawableRes
    val image: Int,
    val title: String,
    val description: String

) {

    object First: OnBoardingPage(
        image = R.drawable.greetings_icon,
        title = "Greetings",
        description = "Xos gelmisiniz ......"
    )
    object Second: OnBoardingPage(
        image = R.drawable.explore_icon,
        title = "Explore",
        description = "Xos gelmisiniz Explore ......"
    )
    object Third: OnBoardingPage(
        image = R.drawable.power_icon,
        title = "Power",
        description = "Xos gelmisiniz  Powersssssssssss......"
    )

}