package br.com.shopping.shoppingapi.item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @NotBlank
    private String productIdentifier;
    @NotNull
    private Float price;

    public static ItemDTO convert(Item item){
        return new ItemDTO(item.getProductIdentifier(), item.getPrice());
    }
}
