package com.example.springboot.demoreactor;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.springboot.demoreactor.model.Persona;


import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	// --> subscribe -- indicamos la loguica adecuada para enterarnos que es lo que sucede dentro del flujo
	
	public void reactor() {
        Mono.just(new Persona(1, "richard", 23))
            .subscribe(p -> log.info("[reactor]"+p));
	}

	
	public void rxjava() {

	  Observable.just(new Persona(1, "richard", 25))
	            .subscribe(p -> log.info("[rxjava]"+ p));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	

	@Override
	public void run(String... args) throws Exception {

	reactor();
	rxjava();
	
		
	}

}
