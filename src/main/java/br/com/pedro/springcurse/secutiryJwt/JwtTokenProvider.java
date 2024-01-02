package br.com.pedro.springcurse.secutiryJwt;

import br.com.pedro.springcurse.data.vo.security.TokkenVO;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.List;


@Service
public class JwtTokenProvider {

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-lenght:3600000}")
    private long validityInMilliSeconds = 3600000;

    @Autowired
    private UserDetailsService userDetailsService;

    Algorithm algorithm = null;

    @PostConstruct
    protected void init(){
        
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());

    }
    public TokkenVO createAccessToken(String username, List<String> roles){
        Date now  = new Date();
        Date validity = new Date(now.getTime() + validityInMilliSeconds) ;
        var accessToken = getAcessToken(username, roles, now, validity);
        var refreshToken = getRefreshToken(username, roles, now);
        return  new TokkenVO(username, true, now, validity, accessToken, refreshToken);
    }

    private String getRefreshToken(String username, List<String> roles, Date now) {
    }

    private String getAcessToken(String username, List<String> roles, Date now, Date validity) {
    }
    
}