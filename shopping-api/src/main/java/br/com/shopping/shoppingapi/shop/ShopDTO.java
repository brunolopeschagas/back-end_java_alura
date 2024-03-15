package br.com.shopping.shoppingapi.shop;

import java.time.LocalDateTime;
import java.util.List;

import br.com.shopping.shoppingapi.item.ItemDTO;
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
public class ShopDTO {
    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private List<ItemDTO> items;

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        return shopDTO;
    }
}
