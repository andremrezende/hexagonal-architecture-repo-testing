package br.com.rezende.budget.budget;

import br.com.rezende.budget.kernel.domain.MultiTenantEntity;
import br.com.rezende.budget.kernel.domain.TenantId;

import java.util.Objects;

public class Company extends MultiTenantEntity {
    private CompanyId companyId;
    private CompanyName companyName;

    public Company(CompanyId companyId, CompanyName companyName, TenantId tenantId, long version, boolean active) {
        super(tenantId, version, active);
        this.companyId = companyId;
        this.companyName = companyName;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public CompanyId getCompanyId() {
        return companyId;
    }

    @Override
    public String aggregateId() {
        return this.companyId.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId);
    }
}
