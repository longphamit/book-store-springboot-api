package com.web.bookstore.util;

import java.util.Calendar;
import java.util.Date;



import com.google.gson.Gson;
import com.web.bookstore.dto.AuthenticateDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	public static final long JWT_EXPIRATION_DATE = 604800000L;
	public static final String SECRET_KEY = "meomeomeo";

	public static String createJWT(AuthenticateDTO authenticateDTO) {
		Gson gson= new Gson();
		String subject=gson.toJson(authenticateDTO);
		String jwt = Jwts.builder().setSubject(subject).setIssuedAt(Calendar.getInstance().getTime())
				.setExpiration(new Date(Calendar.getInstance().getTime().getTime() + JWT_EXPIRATION_DATE))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
		return jwt;
	}

	public static String verifyToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}
	
	
}
