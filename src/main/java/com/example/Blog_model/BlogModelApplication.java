package com.example.Blog_model;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;

@SpringBootApplication
public class BlogModelApplication {
	static void createKey() {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		String secretString = Encoders.BASE64.encode(key.getEncoded());
		System.out.println("Secret key: " + secretString);
	}

	public static void main(String[] args) {
		createKey();
		SpringApplication.run(BlogModelApplication.class, args);
	}

}
