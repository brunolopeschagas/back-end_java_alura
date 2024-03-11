package br.com.shopping.shoppingapi;

import java.time.LocalDate;
import java.util.List;

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
