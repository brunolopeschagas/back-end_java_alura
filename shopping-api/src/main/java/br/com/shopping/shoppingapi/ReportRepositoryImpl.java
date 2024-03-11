package br.com.shopping.shoppingapi;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO melhorar este método, separa responsabilidades
    @Override
    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT s ");
        sb.append("FROM shop s ");
        sb.append("WHERE s.date >= :dataInicio ");

        if (dataFim != null) {
            sb.append("and s.date <= :dataFim ");
        }

        if (valorMinimo != null) {
            sb.append("and s.total <= :valorMinimo");
        }

        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio.atTime(0, 0));

        if (dataFim != null) {
            query.setParameter("dataFim", dataFim.atTime(23, 59));
        }

        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }

    @Override
    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(sp.id), SUM(sp.total), AVG(sp.total) ");
        sb.append("FROM shopping.shop sp ");
        sb.append("WHERE sp.data >= :dataInicio ");
        sb.append("AND sp.data <= :dataFim");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio.atTime(0, 0));
        query.setParameter("dataFim", dataFim.atTime(23, 59));

        Object[] result = (Object[]) query.getSingleResult();
        ShopReportDTO shopReportDTO = new ShopReportDTO();
        shopReportDTO.setCount(((BigInteger) result[0]).intValue());
        shopReportDTO.setTotal((Double) result[1]);
        shopReportDTO.setMean((Double) result[2]);
        return shopReportDTO;
    }

}
