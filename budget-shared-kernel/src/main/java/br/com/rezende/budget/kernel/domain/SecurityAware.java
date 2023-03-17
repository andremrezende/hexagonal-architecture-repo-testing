package br.com.rezende.budget.kernel.domain;

interface SecurityAware {

    void setUserInfo(DomainUser domainUser);
    DomainUser extractUserInfo();
    void setSecurityToken(String securityToken);
    String getSecurityToken();

}
