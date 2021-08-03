package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.model.Product
import br.com.zup.core.port.ProductRepositoryPort
import br.com.zup.core.port.ProductServicePort
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductService(private val productRepository: ProductRepositoryPort) : ProductServicePort {
    override fun create(product: Product) =
        ProductConverter.toProduct(productRepository.save(ProductConverter.toEntity(product)))

    override fun findAll() = ProductConverter.toProductList(productRepository.findAll())

    override fun findById(id: UUID) = ProductConverter.toProduct(productRepository.findById(id).orElseThrow())

    override fun update(id: UUID, product: Product): Product {
        val dbProduct = findById(id)

        return ProductConverter.toProduct(productRepository.update(ProductConverter.toEntity(id, product)))
    }

    override fun delete(id: UUID) {
        val dbProduct = findById(id)
        productRepository.delete(ProductConverter.toEntity(dbProduct))
    }

}
