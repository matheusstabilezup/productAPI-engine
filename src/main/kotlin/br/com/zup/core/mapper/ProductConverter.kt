package br.com.zup.core.mapper

import br.com.zup.core.model.Product
import br.com.zup.database.entity.ProductEntity
import br.com.zup.entrypoint.dto.ProductRequest
import br.com.zup.entrypoint.dto.ProductResponse
import java.util.UUID

class ProductConverter {
    companion object {
        fun toProduct(request: ProductRequest) =
            Product(null, request.name, request.category, request.price, request.stock)

        fun toProduct(productEntity: ProductEntity) = Product(
            productEntity.id,
            productEntity.name,
            productEntity.category,
            productEntity.price,
            productEntity.stock
        )

        fun toResponse(product: Product) =
            ProductResponse(product.id, product.name, product.category, product.price, product.stock)

        fun toEntity(product: Product) =
            ProductEntity(product.id, product.name, product.category, product.price, product.stock)

        fun toEntity(id: UUID, product: Product) =
            ProductEntity(id, product.name, product.category, product.price, product.stock)

        fun toProductList(productEntityList: List<ProductEntity>) = productEntityList.map { toProduct(it) }

        fun toResponseList(productList: List<Product>) = productList.map { toResponse(it) }

    }
}


