package br.com.shopping.shoppingapi.shop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.shopping.DTOs.DTOConverter;
import br.com.shopping.shoppingapi.report.ShopReportDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return getShopsDTO(shops);
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return getShopsDTO(shops);
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThan(shopDTO.getDate());
        return getShopsDTO(shops);
    }

    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if (shop.isPresent()) {
            return DTOConverter.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setTotal(
                shopDTO.getItems()
                        .stream()
                        .map(x -> x.getPrice())
                        .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(LocalDateTime.now());
        shop = shopRepository.save(shop);
        return DTOConverter.convert(shop);
    }

    private List<ShopDTO> getShopsDTO(List<Shop> shops) {
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

     public List<ShopDTO> getShopsByFilter(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo) {
        List<Shop> shops = shopRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(LocalDate dataInicio,
            LocalDate dataFim) {
        return shopRepository.getReportByDate(dataInicio, dataFim);

    }
}
