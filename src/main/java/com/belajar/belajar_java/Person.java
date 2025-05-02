package com.belajar.belajar_java;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String nama;
    private int umur;
    public Person(){

    }
    public Person(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return this.nama;
    }

    public void setUmur(int umur){
        this.umur = umur;
    }

    public int getUmur(){
        return this.umur;
    }

    public String sapa(){
        return "Halo saya " + this.nama + ", Umur saya " + umur;
    }

    public void ulangTahun(){
        this.umur++;
    }
}
