package services;

public interface passwordEncoder {

    String encode(String password);

    boolean matches(String plaintext , String hashPassword);
}
