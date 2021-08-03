package br.com.zup.core.port

import br.com.zup.core.model.Product
import java.util.UUID

interface ProductServicePort {

    fun create(product: Product): Product
    fun findAll(): List<Product>
    fun findById(id: UUID): Product
    fun update(id: UUID, product: Product): Product
    fun delete(id: UUID)


}
