package com.example.Blog_model.products.service;

import com.example.Blog_model.exception.NotFoundEx;
import com.example.Blog_model.mapper.ProductMapper;
import com.example.Blog_model.products.dto.ProductDTO;
import com.example.Blog_model.products.entity.Products;
import com.example.Blog_model.products.respository.ProductRepository;

import com.example.Blog_model.store.entity.Store;
import com.example.Blog_model.store.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE.INSTANCE;


    public  Store checkStoreExit(Long idStore) {
        return storeRepository.findById(idStore).orElseThrow(() -> new NotFoundEx("Not found store"));
    }
    @Override
    public ProductDTO createProduct(ProductDTO productDTO, Long idStore) {
        Store store =  checkStoreExit(idStore);
        Products newProduct = productMapper.productDtoToProduct(productDTO);
        newProduct.setStore(store);
        productRepository.save(newProduct);
        return productDTO;
    }
    @Override
    public List<ProductDTO> getListProductAllStore() {

        return productRepository.findAll().stream()
                .map(productMapper::productToProductDTO
                )
                .collect(Collectors.toList());
    }
    @Override
    public List<ProductDTO> getListProductByStoreId(Long idStore) {
       Store store =  checkStoreExit(idStore);

        return productRepository.findByStoreId(idStore).stream()
                .map(productMapper::productToProductDTO
                      )
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductWithId(Long idProduct, Long idStore) {
        Store store =  checkStoreExit(idStore);
        Optional<Products> productDataOpt = productRepository.findById(idProduct);
        Products product = productDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to get detail Store"));

        return productMapper.productToProductDTO(product);
    }

    @Override
    public ProductDTO upDateProduct(Long idProduct, ProductDTO productDTO, Long idStore) {

        Store store =  checkStoreExit(idStore);
        Optional<Products> productDataOpt = productRepository.findById(idProduct);
        Products product = productDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to update Store"));

        productMapper.updateProductFromDTO( productDTO, product);

        productRepository.save(product);
        return productDTO;
    }

    @Override
    public void deleteProduct(Long idProduct,Long idStore) {
        Store store =  checkStoreExit(idStore);
        Optional<Products> productDataOpt = productRepository.findById(idProduct);
        Products product = productDataOpt.orElseThrow(() -> new NotFoundEx("Not Found data correspond to delete Store"));
        productRepository.deleteById(product.getId());
    }
}
