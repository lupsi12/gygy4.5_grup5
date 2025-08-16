package com.turkcell;


public class Login {
    // final ile bir değişkenin değeri bir kez atandıktan sonra değiştirilemez.
    // static tanımlanan değişken, tüm sınıf örnekleri için paylaşılır
    private static final String username = "user";
    private static final String password = "1234";

    // Giriş yapmak için oluşturulan metot
    public static boolean login(String inputName, String inputPassword){

       if (username.equals(inputName) && password.equals(inputPassword)) {
               return true; // Giriş doğru
           } else {
               return false; // Giriş yanlış
           }
       }

}

