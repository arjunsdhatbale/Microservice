//package com.main.Security;
//
//import java.util.Date;
//
//public class JWT {
//
//	public boolean isTokenValid(String token) {
//	    try {
//	        claims claims = Jwts.parser()
//	            .setSigningKey("yourSecretKey") // should match the one used in Teacher Service
//	            .parseClaimsJws(token)
//	            .getBody();
//
//	        String username = claims.getSubject();
//	        Date expiration = claims.getExpiration();
//
//	        return username != null && expiration.after(new Date());
//	    } catch (Exception e) {
//	        return false;
//	    }
//	}
//
//}
 

