/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moscaville.orderapp;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author moscac
 */
@Service
public class FirebaseConnection {

    private FirebaseOptions options;
    private String databaseName;
    private String serviceAccountFile;

    public final String FIREBASE_DATABASE_NAME = "FIREBASE_DATABASE_NAME";
    public final String FIREBASE_SECRET = "FIREBASE_SECRET";

    public FirebaseConnection() {
    }

    public FirebaseOptions getOptions() {
        return options;
    }

    @PostConstruct
    private void init() {
        try {
            getEnv();
            options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream(serviceAccountFile))
                    .setDatabaseUrl("https://" + databaseName + ".firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception ex) {
            Logger.getLogger(FirebaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getEnv() throws Exception {
        serviceAccountFile = System.getProperty("user.home") +
                File.separator + "firebase/orderappdata/orderappdata.json";
        databaseName = System.getenv(FIREBASE_DATABASE_NAME);
    }
}
