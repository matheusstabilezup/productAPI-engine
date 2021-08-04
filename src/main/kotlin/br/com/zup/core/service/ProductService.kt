package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.port.ProductRepositoryPort
import br.com.zup.core.port.ProductServicePort
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductService(private val productRepository: ProductRepositoryPort) : ProductServicePort {

    override fun findAll() = ProductConverter.toProductList(productRepository.findAll())

    override fun findById(id: UUID) = ProductConverter.toProduct(productRepository.findById(id).orElseThrow())


}
