package com.gap.hellogiver.gateway

import androidx.annotation.ColorRes

interface HelloGiverColorService {

    @ColorRes
    fun getPrimaryColor(): Int
}
