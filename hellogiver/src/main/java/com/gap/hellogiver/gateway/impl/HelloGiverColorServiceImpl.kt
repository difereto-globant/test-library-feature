package com.gap.hellogiver.gateway.impl

import com.gap.hellogiver.R
import com.gap.hellogiver.gateway.HelloGiverColorService

internal class HelloGiverColorServiceImpl : HelloGiverColorService {

    override fun getPrimaryColor(): Int = R.color.primary_color
}
