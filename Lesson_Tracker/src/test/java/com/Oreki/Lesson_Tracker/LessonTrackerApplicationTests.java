package com.Oreki.Lesson_Tracker;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

@SpringBootTest
@ComponentScan(basePackages = "com.Oreki.Lesson_Tracker")
class LessonTrackerApplicationTests {

	@Test
	public void genKey(){
		SecretKey sk = Jwts.SIG.HS512.key().build();
		String key = DatatypeConverter.printHexBinary(sk.getEncoded());
		System.out.println("key: "+ key);

	}

}
