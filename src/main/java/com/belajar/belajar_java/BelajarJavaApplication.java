package com.belajar.belajar_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BelajarJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarJavaApplication.class, args);
		Person person = new Person("Budi", 10);
		System.out.println(person.getNama());
		System.out.println(person.getUmur());
		person.ulangTahun();
		System.out.println(person.getUmur());
		System.out.println(person.sapa());
	}

}
