package br.com.shopping.shoppingapi.item;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Item {
    private String productIdentifier;
    private Float price;

    public static Item convert(ItemDTO itemDTO){
        return new Item(itemDTO.getProductIdentifier(), itemDTO.getPrice());
    }
}
