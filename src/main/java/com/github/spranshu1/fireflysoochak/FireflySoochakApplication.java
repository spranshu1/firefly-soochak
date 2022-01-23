package com.github.spranshu1.fireflysoochak;

import com.github.spranshu1.fireflysoochak.config.FirebaseConfig;
import com.github.spranshu1.fireflysoochak.token.CustomTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class FireflySoochakApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(FireflySoochakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var pathToServiceAcc = environment.getProperty("GOOGLE_APPLICATION_CREDENTIALS");
		FirebaseConfig.initializeFirebase(pathToServiceAcc,"");
		CustomTokenHelper.createToken("");
	}
}
