package br.com.zup.core.port

import br.com.zup.database.entity.ProductEntity
import java.util.Optional
import java.util.UUID

interface ProductRepositoryPort {

    fun save(productEntity: ProductEntity): ProductEntity
    fun findAll(): List<ProductEntity>
    fun findById(id: UUID): Optional<ProductEntity>
    fun update(productEntity: ProductEntity): ProductEntity
    fun delete(productEntity: ProductEntity)

}
