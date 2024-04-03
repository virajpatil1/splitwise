package services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class BcryptEncoder implements passwordEncoder{


    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matches(String plaintext, String hashPassword) {
        return bCryptPasswordEncoder.matches(plaintext,hashPassword);
    }
}
