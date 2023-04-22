package com.gs.bbs.aspect;

import com.gs.bbs.jwt.TokenProvider;
import com.gs.bbs.util.StringUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.SignatureException;

@RequiredArgsConstructor
@Aspect
@Slf4j
@Component
public class AuthAspect {

    private final HttpServletRequest httpServletRequest;

    private final TokenProvider tokenProvider;

    @Around("@annotation(com.gs.bbs.annotation.Auth)")
    public Object accessToken(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            String accessToken = parseBearerToken(httpServletRequest);

            if (StringUtil.isNotEmpty(accessToken)) {

                String userId = tokenProvider.validateAndGetUserId(accessToken);

                AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userId,
                        null,
                        AuthorityUtils.NO_AUTHORITIES
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authentication); // 인증 정보 넣기
                SecurityContextHolder.setContext(securityContext); // 다시 등록
            } else {
                throw new Exception("유효하지 않은 토큰");
            }
            return pjp.proceed();
        } catch (
                Exception e
        ) {
            throw new JwtException(e.getMessage());
        }
    }

    private String parseBearerToken(HttpServletRequest request) {
        // Http 요청의 헤더를 파싱해 Bearer 토큰을 리턴한다.
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
