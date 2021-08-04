package br.com.zup.entrypoint.controller

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.port.ProductServicePort
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.validation.Validated
import java.util.UUID

@Controller("/v1/productAPI/products")
@Validated
class ProductController(private val productService: ProductServicePort) {

    @Get
    fun getAll() = HttpResponse.ok(ProductConverter.toResponseList(productService.findAll()))

    @Get("/{id}")
    fun getById(@PathVariable id: UUID) = HttpResponse.ok(ProductConverter.toResponse(productService.findById(id)))

}