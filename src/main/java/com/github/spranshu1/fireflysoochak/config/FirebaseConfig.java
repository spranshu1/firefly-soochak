package com.github.spranshu1.fireflysoochak.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {

    /**
     * Initialize firebase using custom options
     *
     * @param options FirebaseOptions
     * @return FirebaseApp
     */
    public static FirebaseApp initializeFirebase(FirebaseOptions options) {
        return FirebaseApp.initializeApp(options);
    }


    /**
     * Initialize firebase using service account json key
     *
     * @param googleServiceAccPath Path to service account key json
     * @return FirebaseApp
     * @throws IOException The exception
     */
    public static FirebaseApp initializeFirebase(String googleServiceAccPath) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(googleServiceAccPath);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);
    }

    /**
     * Initialize firebase using service account json key and DB url
     *
     * @param googleServiceAccPath Path to service account key json
     * @param dbUrl                The database url eg. https://&lt;DATABASE_NAME&gt;.firebaseio.com/
     * @return FirebaseApp
     * @throws IOException The exception
     */
    public static FirebaseApp initializeFirebase(String googleServiceAccPath, String dbUrl) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream(googleServiceAccPath);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(dbUrl)
                .build();

        return FirebaseApp.initializeApp(options);
    }

    /**
     * Initialize firebase using OAuth 2.0 refresh token
     *
     * @param refreshTokenPath Path to google Oauth2 refresh token
     * @return FirebaseApp
     * @throws IOException The exception
     */
    public static FirebaseApp initializeFirebaseUsingToken(String refreshTokenPath) throws IOException {
        FileInputStream refreshToken = new FileInputStream(refreshTokenPath);

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .build();

        return FirebaseApp.initializeApp(options);
    }

    /**
     * Initialize firebase using service account id
     *
     * @param serviceAccountId The service account id eg. my-client-id@my-project-id.iam.gserviceaccount.com
     * @throws IOException The exception
     */
    public static void initializeFirebaseUsingServiceAcc(String serviceAccountId) throws IOException {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setServiceAccountId(serviceAccountId)
                .build();
        FirebaseApp.initializeApp(options);
    }


}
