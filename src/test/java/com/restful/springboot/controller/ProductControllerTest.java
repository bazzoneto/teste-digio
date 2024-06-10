package com.restful.springboot.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.restful.springboot.controllers.ProductController;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.restful.springboot.dtos.ProductRecordDto;
import com.restful.springboot.models.ProductModel;
import com.restful.springboot.services.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        // Configurar comportamento padrão do serviço mockado
        Pageable pageable = Pageable.unpaged();
        when(productService.findAll(pageable)).thenReturn(new PageImpl<>(List.of(new ProductModel())));
        when(productService.findById(any(UUID.class))).thenReturn(Optional.of(new ProductModel()));
    }

    @Test
    public void testGetAllProducts() {
        ResponseEntity<Page<ProductModel>> response = productController.getAllProducts(Pageable.unpaged());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getContent().size());
    }

    @Test
    public void testGetOneProduct() {
        ResponseEntity<Object> response = (ResponseEntity<Object>) productController.getOneProduct(UUID.randomUUID());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateProduct() {
        ProductRecordDto productRecordDto = new ProductRecordDto();
        ResponseEntity<ProductModel> response = productController.createProduct(productRecordDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    // Testes para os métodos updateProduct e deleteProduct podem ser adicionados de forma similar

    @Test
    public void testGetPurchaseYear() {
        UUID productId = UUID.randomUUID();
        ProductModel product = new ProductModel();
        product.setano_compra(2022);
        when(productService.findById(productId)).thenReturn(Optional.of(product));

        ResponseEntity<Integer> response = productController.getPurchaseYear(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Integer.valueOf(2022), response.getBody());
    }
}