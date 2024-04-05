package br.com.shopping.DTOs;

import br.com.shopping.shoppingapi.item.Item;
import br.com.shopping.shoppingapi.item.ItemDTO;
import br.com.shopping.shoppingapi.shop.Shop;
import br.com.shopping.shoppingapi.shop.ShopDTO;

public class DTOConverter {

    public static ItemDTO convert(Item item) {
        return new ItemDTO(item.getProductIdentifier(), item.getPrice());
    }


    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        shopDTO.setDate(shop.getDate());
        return shopDTO;
    }
}
