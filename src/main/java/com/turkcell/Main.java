package com.turkcell;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        int count = 3;

        while (count > 0){
            System.out.print("Kullanıcı Adı: ");
            String username = scanner.nextLine();

            System.out.print("Şifre: ");
            String password = scanner.nextLine();

            isLoggedIn = Login.login(username, password);

            if (isLoggedIn) {
                System.out.println("Giriş başarılı!");
                Menu.showMenu(scanner);
                break; // Menüden çıkınca program biter
            }else{
                count --;
                if(count == 0){
                    System.out.println("3 kez deneme yapıldı. Çıkış yapılıyor.");

                }else {
                    System.out.println("Hatalı kullanıcı adı veya şifre. Kalan deneme hakkı: " + count);
                }
            }
        }

    }

}






