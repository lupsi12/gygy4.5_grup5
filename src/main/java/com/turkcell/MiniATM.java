package com.turkcell;


public class MiniATM {

    // Başlangıç bakiye miktarı
    private double balance = 25000;

    //Toplam yatırılan, çekilen ve ödenen fatura bilgileri
    private double totalDeposit = 0, totalWithdraw = 0;
    private double totalBillsPaidAmount = 0;
    private int totalBillsPaidCount = 0;

    // Güncel bakiyeyi almak için kullanılır.
    //deneme
    public double getBalance(){
        return balance;
    }

    // Para Yatırma İşlemi
    public void deposit(double amount){
        if (amount <= 0){
            System.out.println("Negatif/0 tutarlara izin verilmiyor.");
            return;
        }
        balance += amount;
        totalDeposit += amount;
        System.out.println("Yatırılan tutar: " + amount);
    }

    // Para Çekme İşlemi
    public void withDraw(double amount){

        if (amount <= 0){
            System.out.println("Negatif/0 tutarlara izin verilmiyor.");
            return;
        }

        // 5000 TL üzeri çekimlerde %2 komisyon
        double commission = 0;
        commission = amount > 5000 ? amount * 0.02 : 0;
        amount += commission;
        totalWithdraw += amount;

        if (amount > balance){
            System.out.println("Bakiye Yetersiz. Miktarı kontrol ediniz.");
            return;     // Metodu durdurur.
        }
        balance -= amount;
        System.out.println("Çekilen tutar " + amount);
        System.out.println("Komisyon: " + commission);
//        System.out.println("Güncel Bakiye: " + balance);

    }

    // Fatura Ödeme İşlemi
    public void payBill(int billType, double amount){

        if (amount <= 0 ){
            System.out.println("Hatalı fatura tutarı!");
            return;
        }
        if (amount > balance){
            System.out.println("Bakiye yetersiz!");
            return;
        }
        // Ödeme
        balance -= amount;
        totalBillsPaidCount++;
        totalBillsPaidAmount += amount;

        // Fatura Tipine Göre İndirim Oranı Uygulama
        double discountRate;
        if (billType == 1){         // Elektrik
            discountRate = 0.05;
        }else if (billType == 2){   //Su
            discountRate = 0.03;
        }else if (billType == 3){   //İnternet
            discountRate = 0.02;
        }else {
            discountRate = 0.0;
        }

        // İndirim varsa bakiyeye eklenir
        if (discountRate > 0){
            double discount = discountRate * amount;
            balance += discount;
            System.out.println(discount + " TL İndirim Uygulandı.");
        }

        System.out.println("Fatura ödendi:  " + amount);
    }

    // İşlemlerin Özetini Yazdırma

    public void printSummary(){

        double netMove = totalDeposit - totalWithdraw - totalBillsPaidAmount;

        System.out.println("\n================ İşlem Özeti ================");
        System.out.printf("%-30s : %.2f%n", "Toplam yatırılan", totalDeposit);
        System.out.printf("%-30s : %.2f%n", "Toplam çekilen", totalWithdraw);
        System.out.printf("%-30s : %d%n", "Toplam ödenen fatura adedi", totalBillsPaidCount);
        System.out.printf("%-30s : %.2f%n", "Toplam ödenen fatura tutarı", totalBillsPaidAmount);
        System.out.printf("%-30s : %.2f%n", "Net hareket", netMove);
        System.out.printf("%-30s : %.2f%n", "Güncel bakiye", balance);
        System.out.println("==============================================");
    }


}
