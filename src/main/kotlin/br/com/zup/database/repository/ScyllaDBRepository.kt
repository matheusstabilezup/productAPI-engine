package br.com.zup.database.repository

import br.com.zup.core.port.ProductRepositoryPort
import br.com.zup.database.entity.ProductEntity
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.Optional
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ScyllaDBRepository(private val cqlSession: CqlSession) : ProductRepositoryPort {

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

    override fun findById(id: UUID): Optional<ProductEntity> {
        val row = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM product WHERE id = ?",
                    id
                )
        ).firstOrNull() ?: return Optional.empty()

        return Optional.of(
            ProductEntity(
                row.getUuid(CqlIdentifier.fromCql("id"))!!,
                row.getString(CqlIdentifier.fromCql("name"))!!,
                row.getString(CqlIdentifier.fromCql("category"))!!,
                row.getBigDecimal(CqlIdentifier.fromCql("price"))!!,
                row.getInt(CqlIdentifier.fromCql("stock"))!!
            )
        )
    }

}