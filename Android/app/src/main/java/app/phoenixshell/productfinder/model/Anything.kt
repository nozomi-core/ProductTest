package app.phoenixshell.productfinder.model

import app.phoenixshell.productfinder.BigDecimalSerializer
import kotlinx.serialization.Serializable
import java.math.BigDecimal

//TODO:: Move this
@Serializable
data class Anything(
    val name: String,
    @Serializable(with = BigDecimalSerializer::class)
    val cost: BigDecimal)