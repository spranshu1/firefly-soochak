package com.github.spranshu1.fireflysoochak.users;

import com.google.firebase.auth.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class UserHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserHelper.class);

    public static UserRecord getUser(String uid) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().getUser(uid);
    }

    public static UserRecord getUserByEmail(String email) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().getUserByEmail(email);
    }

    public static UserRecord getUserByPhone(String phoneNumber) throws FirebaseAuthException {
        return FirebaseAuth.getInstance().getUserByPhoneNumber(phoneNumber);
    }

    public static Set<UserRecord> getBulkUserData(List<UserIdentifier> identifiers) throws ExecutionException, InterruptedException {
        var result = FirebaseAuth.getInstance().getUsersAsync(identifiers).get();
        LOGGER.warn("Unable to find users corresponding to these identifiers:");
        for (UserIdentifier uid : result.getNotFound()) {
            LOGGER.info(uid.toString());
        }
        return result.getUsers();
    }



}
