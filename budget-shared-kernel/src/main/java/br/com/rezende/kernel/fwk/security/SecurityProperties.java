package br.com.rezende.kernel.fwk.security;

import lombok.Data;

@Data
public class SecurityProperties {

    private String jwtSecretKey;
    private long jwtTtl;

}
