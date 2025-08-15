package com.turkcell;

import java.util.Scanner;

public class Menu {
    public static void showMenu(Scanner scanner) {
        MiniATM miniATM = new MiniATM();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n---------------------------- MENU ----------------------------");
            System.out.println("1 - Para Yatır");
            System.out.println("2 - Para Çek");
            System.out.println("3 - Bakiye Görüntüle");
            System.out.println("4 - Fatura Öde (Elektrik/Su/İnternet) ");
            System.out.println("5 - Çıkış");
            System.out.println("--------------------------------------------------------------");
            System.out.print("\n Lütfen bir seçim yapınız: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Yatırılacak Tutarı Giriniz: ");
                    double deposit = scanner.nextDouble();
                    miniATM.deposit(deposit);
                    break;
                case 2:
                    System.out.print("Çekilecek Tutarı Giriniz: ");
                    double withdraw = scanner.nextDouble();
                    miniATM.withDraw(withdraw);
                    break;
                case 3:
                    System.out.println(" Güncel Bakiye: " + miniATM.getBalance());
                    break;
                case 4:
                    System.out.println("------------------------- FATURA -----------------------------");
                    System.out.println("\nFatura türünü seçiniz :");
                    System.out.println("1 - Elektrik");
                    System.out.println("2 - Su");
                    System.out.println("3 - İnternet");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Lütfen bir seçim yapınız : ");
                    int billType = scanner.nextInt();

                    System.out.print("Fatura Tutarını Giriniz: ");
                    double amount = scanner.nextDouble();

                    miniATM.payBill(billType, amount);
                    break;
                case 5:
                    System.out.println("\n Çıkıs Yapılıyor....");
                    miniATM.printSummary();
                    isRunning = false; // Döngüyü sonlandırılır.
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar Deneyiniz.");

            }
        }

    }

}
