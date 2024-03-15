package br.com.shopping.shoppingapi.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.shopping.shoppingapi.report.ReportRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>,ReportRepository {
    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThan(LocalDateTime date);
}
