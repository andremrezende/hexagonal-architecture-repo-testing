package br.com.rezende.kernel.domain;

interface SecurityAware {

    void setUserInfo(DomainUser domainUser);
    DomainUser extractUserInfo();
    void setSecurityToken(String securityToken);
    String getSecurityToken();

}
