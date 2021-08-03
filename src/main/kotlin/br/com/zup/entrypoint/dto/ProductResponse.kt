package br.com.zup.entrypoint.dto

import java.math.BigDecimal
import java.util.UUID

class ProductResponse(
    val id: UUID?,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val stock: Int
)
