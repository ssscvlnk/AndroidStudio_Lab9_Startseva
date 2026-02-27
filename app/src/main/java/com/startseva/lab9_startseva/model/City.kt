package com.startseva.lab9_startseva.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class City (
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId: Int
)