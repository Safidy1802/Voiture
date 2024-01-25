package com.voiture.gasicar.Dao;


public class Main {
    public static void main(String[] args) {
        try {
            Personne pres=new Personne();
            pres.setName("Iza oa");
            Personne vavao=(Personne)pres.insert(null);
            System.out.println(vavao.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}