package br.com.zup.core.model

import java.math.BigDecimal
import java.util.UUID

data class Product(
    var id: UUID?,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val stock: Int
)
