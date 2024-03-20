package br.com.shopping.shoppingapi.report;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.shopping.shoppingapi.shop.Shop;
import br.com.shopping.shoppingapi.shop.ShopDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    public List<ShopDTO> getShopsByFilter(
            LocalDate dataInicio,
            LocalDate dataFim,
            Float valorMinimo) {
        List<Shop> shops = this.reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(LocalDate dataInicio,
            LocalDate dataFim) {
        return this.reportRepository.getReportByDate(dataInicio, dataFim);

    }
}
