package com.gap.hellogiver.gateway.impl

import com.gap.hellogiver.R
import com.gap.hellogiver.gateway.HelloGiverThemeService
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme.SecondaryTheme

class HelloGiverSecondaryThemeServiceImpl : HelloGiverThemeService {

    override fun getTheme(theme: HelloTheme): Int? {
        return if (theme is SecondaryTheme) {
            return R.style.AppThemeBananaRepublic
        } else {
            null
        }
    }
}
