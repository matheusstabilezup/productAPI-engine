package br.com.zup.database.repository

import br.com.zup.core.port.ProductRepositoryPort
import br.com.zup.database.entity.ProductEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.UUID

@Repository
interface ProductRepository : CrudRepository<ProductEntity, UUID>, ProductRepositoryPort {
}