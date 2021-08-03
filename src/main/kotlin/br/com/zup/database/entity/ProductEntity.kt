package br.com.zup.database.entity

import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tb_Product")
data class ProductEntity(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val name: String = "",
    val category: String = "",
    val price: BigDecimal = ZERO,
    val stock: Int = Int.MIN_VALUE

)
