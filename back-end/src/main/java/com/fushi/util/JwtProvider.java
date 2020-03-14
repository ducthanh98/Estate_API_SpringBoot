package com.fushi.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fushi.dto.auth.ro.UserRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.io.IOException;
import java.util.Date;

public class JwtProvider {


        // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
        private static final String JWT_SECRET = "bimatkothebatmi";
        private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

        //Thời gian có hiệu lực của chuỗi jwt
        private static final long JWT_EXPIRATION = 604800000L;

        // Tạo ra jwt từ thông tin user
        public static String generateToken(UserRO userRO) throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);


            return Jwts.builder()
                    .setSubject(mapper.writeValueAsString(userRO))
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                    .compact();
        }

        // Lấy thông tin user từ jwt
        public static UserRO getUserROFromJWT(String token) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            return mapper.readValue(claims.getSubject(),UserRO.class);
        }

        public static boolean validateToken(String authToken) {
            try {
                Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
                return true;
            } catch (MalformedJwtException ex) {
                logger.error("Invalid JWT token");
            } catch (ExpiredJwtException ex) {
                logger.error("Expired JWT token");
            } catch (UnsupportedJwtException ex) {
                logger.error("Unsupported JWT token");
            } catch (IllegalArgumentException ex) {
                logger.error("JWT claims string is empty.");
            }
            return false;
        }
}
