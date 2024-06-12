package org.ubis.ubis.domain.product.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.ubis.ubis.domain.product.dto.CreateProductRequest
import org.ubis.ubis.domain.product.dto.ProductResponse
import org.ubis.ubis.domain.product.dto.UpdateProductRequest
import org.ubis.ubis.domain.product.service.ProductService

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getProductList(
    ): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(productService.getProductList())
    }

    @GetMapping("/{productId}")
    fun getProduct(
        @PathVariable productId: Long
    ): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(productService.getProduct(productId))
    }

    @PostMapping
    fun createProduct(
        @RequestBody request: CreateProductRequest
    ): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(productService.createProduct(request))
    }

    @PutMapping("/{productId}")
    fun updateProduct(
        @PathVariable productId: Long, @RequestBody request: UpdateProductRequest
    ): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(productService.updateProduct(productId, request))
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(
        @PathVariable productId: Long
    ): ResponseEntity<Unit> {
        return ResponseEntity.ok(productService.deleteProduct(productId))
    }
}