package br.com.zup.database.entity

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.util.UUID

data class ProductEntity(
    var id: UUID? = null,
    val name: String = "",
    val category: String = "",
    val price: BigDecimal = ZERO,
    val stock: Int = Int.MIN_VALUE
)
