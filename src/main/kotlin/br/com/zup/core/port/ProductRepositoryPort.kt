package br.com.zup.core.port

import br.com.zup.database.entity.ProductEntity
import java.util.UUID

interface ProductRepositoryPort {
    fun findAll(): List<ProductEntity>
    fun findById(id: UUID): ProductEntity
}
