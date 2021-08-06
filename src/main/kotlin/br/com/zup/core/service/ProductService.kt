package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.core.port.ProductServicePort
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductService(private val productEntityService: ProductEntityServicePort) : ProductServicePort {
    override fun findAll() = ProductConverter.toProductList(productEntityService.findAll())
    override fun findById(id: UUID) = ProductConverter.toProduct(productEntityService.findById(id))
}
