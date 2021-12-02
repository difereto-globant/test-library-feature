package com.gap.hellogiver.gateway.impl

import com.gap.hellogiver.R
import com.gap.hellogiver.gateway.HelloGiverThemeService
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme.PrimaryTheme

class HelloGiverPrimaryThemeServiceImpl : HelloGiverThemeService {

    override fun getTheme(theme: HelloTheme): Int? {
        return if (theme is PrimaryTheme) {
            return R.style.AppThemeGap
        } else {
            null
        }
    }
}
