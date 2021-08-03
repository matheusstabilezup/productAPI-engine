package br.com.zup.entrypoint.dto

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
data class ProductRequest(
    val id: UUID? = null,
    @field:NotBlank val name: String = "",
    @field:NotBlank val category: String = "",
    @field:Positive val price: BigDecimal = ZERO,
    @field:Positive val stock: Int = 0
)
