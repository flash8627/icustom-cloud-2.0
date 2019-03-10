package com.gwtjs.icustom.security.util;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
	
	/**
     * @param args
     */
    public static void main(String[] args) {
            String password = "abc125";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println(passwordEncoder.encode(password));
    }
    
	@Test
    public void testPass(){
        String pass = "111111";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder(4);
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
        
        pass = "user123";
        hashPass = encode.encode(pass);
        System.out.println(hashPass);
        
    }
	
}
