package br.com.zup.core.port

import br.com.zup.core.model.Product
import java.util.UUID

interface ProductServicePort {

    fun findAll(): List<Product>
    fun findById(id: UUID): Product

}
