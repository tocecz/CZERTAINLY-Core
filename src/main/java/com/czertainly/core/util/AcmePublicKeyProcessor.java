package com.czertainly.core.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class AcmePublicKeyProcessor {

    public static String publicKeyPemStringFromObject(PublicKey publicKey){
        byte[] pubKeyBytes = publicKey.getEncoded();
        String pubKeyString = Base64.getEncoder().encodeToString(pubKeyBytes);
        return pubKeyString;
    }

    public static PublicKey publicKeyObjectFromString(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] pubKeyBytes = Base64.getDecoder().decode(publicKey);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PublicKey publicKeyObject = factory.generatePublic(new X509EncodedKeySpec(pubKeyBytes));
        return publicKeyObject;
    }


}
