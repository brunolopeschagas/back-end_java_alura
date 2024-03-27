package br.com.brunochagas;

import br.com.brunochagas.productapi.Category;
import br.com.brunochagas.productapi.CategoryDTO;
import br.com.brunochagas.productapi.Product;
import br.com.brunochagas.productapi.ProductDTO;

public class DTOConverter {

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategory(DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }
}
