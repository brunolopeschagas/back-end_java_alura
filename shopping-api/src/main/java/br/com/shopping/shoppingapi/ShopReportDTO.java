package br.com.shopping.shoppingapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopReportDTO {
    private Integer count;
    private Double total;
    privaet Double mean;
}