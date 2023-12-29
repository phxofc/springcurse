package br.com.pedro.springcurse.data.vo.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokkenVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private Boolean authenticated;
    private Date created;
    private Date expiration;
    private String accessToken;
    private String refreshToken;

    public TokkenVO() {
    }

    public TokkenVO(String username,
                    Boolean authenticated,
                    Date created,
                    Date expiration,
                    String accessToken,
                    String refreshToken) {
        this.username = username;
        this.authenticated = authenticated;
        this.created = created;
        this.expiration = expiration;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TokkenVO tokkenVO)) return false;
        return Objects.equals(getUsername(), tokkenVO.getUsername()) && Objects.equals(getAuthenticated(), tokkenVO.getAuthenticated()) && Objects.equals(getCreated(), tokkenVO.getCreated()) && Objects.equals(getExpiration(), tokkenVO.getExpiration()) && Objects.equals(getAccessToken(), tokkenVO.getAccessToken()) && Objects.equals(getRefreshToken(), tokkenVO.getRefreshToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getAuthenticated(), getCreated(), getExpiration(), getAccessToken(), getRefreshToken());
    }
}
