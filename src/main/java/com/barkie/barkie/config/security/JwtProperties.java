package com.barkie.barkie.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String url;
    private String secret;
    private String header;
    private String prefix;
    private String type;
    private String issuer;
    private String audience;

    public String getUrl() {
        return url;
    }

    public String getSecret() {
        return secret;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getType() {
        return type;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
