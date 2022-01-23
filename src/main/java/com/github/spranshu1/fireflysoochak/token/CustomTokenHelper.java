package com.github.spranshu1.fireflysoochak.token;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.Map;

public class CustomTokenHelper {

    /**
     * Creates a custom token;These tokens expire after one hour.
     * <p>To create custom tokens using a separate service account ID.Initialize firebase using service account id</p>
     *
     * @param uid Should uniquely identify the user or device you are authenticating.
     * @return The token string
     * @throws FirebaseAuthException The exception
     * @see com.github.spranshu1.fireflysoochak.config.FirebaseConfig#initializeFirebaseUsingServiceAcc(String)
     */
    public static String createToken(String uid) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().createCustomToken(uid);
    }

    /**
     * Creates a custom token;These tokens expire after one hour.
     * <p>To create custom tokens using a separate service account ID.Initialize firebase using service account id</p>
     *
     * @param uid              Should uniquely identify the user or device you are authenticating.
     * @param additionalClaims Additional claims to be included in the custom token
     * @return The token string
     * @throws FirebaseAuthException The exception
     * @see com.github.spranshu1.fireflysoochak.config.FirebaseConfig#initializeFirebaseUsingServiceAcc(String)
     */
    public static String createToken(String uid, Map<String, Object> additionalClaims) throws FirebaseAuthException {
        return FirebaseAuth.getInstance()
                .createCustomToken(uid, additionalClaims);
    }
}
