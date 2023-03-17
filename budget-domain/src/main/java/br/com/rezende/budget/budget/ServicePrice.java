package br.com.rezende.budget.budget;

import java.util.Date;

public class ServicePrice extends Price {
    public ServicePrice(Date updated, Double sellPrice) {
        super(updated, sellPrice);
    }

    static ServicePrice with(Date updated, Double sellPrice) {
        return new ServicePrice(updated, sellPrice);
    }
}
