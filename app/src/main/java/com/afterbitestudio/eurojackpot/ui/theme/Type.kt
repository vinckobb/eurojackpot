package com.afterbitestudio.eurojackpot.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.afterbitestudio.eurojackpot.R

val Dosis = FontFamily(
    Font(R.font.dosis_regular, FontWeight.Normal),
    Font(R.font.dosis_semi_bold, FontWeight.SemiBold),
    Font(R.font.dosis_bold, FontWeight.Bold),
    Font(R.font.dosis_extra_bold, FontWeight.ExtraBold),
    Font(R.font.dosis_light, FontWeight.Light),
    Font(R.font.dosis_extra_light, FontWeight.ExtraLight),
    Font(R.font.dosis_medium, FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Dosis,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)