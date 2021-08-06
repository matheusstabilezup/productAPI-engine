package br.com.zup.database.service

import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.database.repository.ProductRepository
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductEntityService(private val productRepository: ProductRepository) : ProductEntityServicePort {
    override fun findAll() = productRepository.findAll()
    override fun findById(id: UUID) = productRepository.findById(id)
}