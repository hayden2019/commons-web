package com.github.commonweb.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    public static Map<String, Object> HEADER  = new HashMap<String, Object>();
    public static Key SIGN_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static String SUBJECT = "SUBJECT";
    public static int EXPIRE_MINUTES = 24 * 60;

    static {
        HEADER.put("type", "JWT");
        HEADER.put("alg", "HS256");
    }

    public static String sign(Map<String, Object> payload){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, EXPIRE_MINUTES);
        return Jwts.builder()
                .setSubject(SUBJECT)
                .setHeader(HEADER)
                .setExpiration(cal.getTime()).addClaims(payload)
                // .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SIGN_KEY).compact();

    }

    public static Map<String,Object> checkTokenValid(String token){
        // 解析 jwt, 如果解析失败，说明token不合法
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token);
        return claimsJws.getBody();
    }

    public static void main(String[] args) {
        int i = 10 ;
        while ( i > 0){
            i = i - 1;
            Map<String, Object> payload = new HashMap<String, Object>();
            payload.put("userName", "zhangsan");
            payload.put("userId", "zhangsan");
            long t1 = System.currentTimeMillis();
            String token =  sign(payload);
            System.out.println(token);
            Map<String, Object> stringObjectMap = checkTokenValid(token);
            System.out.println(stringObjectMap);
            System.out.println(System.currentTimeMillis()-t1);
        }
    }

}
