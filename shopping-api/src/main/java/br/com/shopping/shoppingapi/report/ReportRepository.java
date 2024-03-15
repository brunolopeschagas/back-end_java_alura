package br.com.shopping.shoppingapi.report;

import java.time.LocalDate;
import java.util.List;

import br.com.shopping.shoppingapi.shop.Shop;

public interface ReportRepository {
    List<Shop> getShopByFilters(
        LocalDate dataInicio,
        LocalDate dataFim,
        Float valorMinimo
    );

    ShopReportDTO getReportByDate(
        LocalDate dataInicio,
        LocalDate dataFim
    );
}
