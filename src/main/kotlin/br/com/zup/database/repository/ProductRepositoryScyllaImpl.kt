package br.com.zup.database.repository

import br.com.zup.database.entity.ProductEntity
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductRepositoryScyllaImpl(private val cqlSession: CqlSession) : ProductRepository {

    override fun findAll(): List<ProductEntity> {
        val rows = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM product"
                )
        ).toList()

        val products: MutableList<ProductEntity> = mutableListOf()

        for (row in rows) {
            products.add(
                ProductEntity(
                    row.getUuid(CqlIdentifier.fromCql("id"))!!,
                    row.getString(CqlIdentifier.fromCql("name"))!!,
                    row.getString(CqlIdentifier.fromCql("category"))!!,
                    row.getBigDecimal(CqlIdentifier.fromCql("price"))!!,
                    row.getInt(CqlIdentifier.fromCql("stock"))!!
                )
            )
        }

        return products
    }

    override fun findById(id: UUID): ProductEntity {
        val row = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM product WHERE id = ?",
                    id
                )
        ).firstOrNull() ?: throw HttpStatusException(HttpStatus.NOT_FOUND, "Product not found")

        return ProductEntity(
            row.getUuid(CqlIdentifier.fromCql("id"))!!,
            row.getString(CqlIdentifier.fromCql("name"))!!,
            row.getString(CqlIdentifier.fromCql("category"))!!,
            row.getBigDecimal(CqlIdentifier.fromCql("price"))!!,
            row.getInt(CqlIdentifier.fromCql("stock"))!!
        )
    }
}