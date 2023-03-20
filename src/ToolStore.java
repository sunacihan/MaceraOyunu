public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    public boolean onLocation() {
        boolean showMenu=true;
        while (showMenu) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Mağazaya hoşgeldiniz.");
            System.out.println("1.Silahlar\n2.Zırhlar\n3.Çıkış yap");
            System.out.println("------------------------------------------------------------");
            System.out.print("Seçiminiz:");
            int sayi = scanner.nextInt();

            System.out.println("------------------------------------------------------------");
            switch (sayi) {
                case 1:
                    printWeapen();
                    buyWeapen();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu=false;
            }

        }
        return true;
    }

    public void printWeapen() {
        System.out.println("***** Silahlar *****");
        for (Weapen w : Weapen.printWeapen()
        ) {
            System.out.println(" İd :" + w.getId() + " " + w.getName() + "  hasarı:" + w.getDamage() + "  parası:" + w.getPrice());
        }
        System.out.println("------------------------------------------------------------");

    }


    public void buyWeapen() {
        System.out.print("Silah seçiniz:");
        int selectWeapen = scanner.nextInt();
        while (selectWeapen < 1 || selectWeapen > Weapen.printWeapen().length) {
            System.out.print("Yanlış seçim, bir daha deneyiniz:");
            selectWeapen = scanner.nextInt();
        }
        for (Weapen w : Weapen.printWeapen()
        ) {
            if (selectWeapen == w.getId()) {
                if (this.getPlayer().getMoney() < w.getPrice()) {
                    System.out.println("Bakiye yetersiz.");
                } else {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - w.getPrice());
                    System.out.println("Kalan para :" + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapen(w);
                    System.out.println(this.getPlayer().getName()+" karakteri "+this.getPlayer().getInventory().getWeapen().getName()+" hasarı:"+this.getPlayer().getTotalDamage()+" parası:"+this.getPlayer().getMoney());
                    break;
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("***** Zırhlar *****");
        for (Armor a : Armor.printArmors()
        ) {
            System.out.println(a.getId() + " " + a.getName() + "  engellemesi:" + a.getBlock() + "  parası:" + a.getMoney());
        }
        System.out.println("------------------------------------------------------------");

    }
    public  void buyArmor(){
        System.out.print("Zırh seçiniz:");
        int selectArmor = scanner.nextInt();
        while (selectArmor< 1 || selectArmor > Armor.printArmors().length) {
            System.out.print("Yanlış seçim, bir daha deneyiniz:");
            selectArmor = scanner.nextInt();
        }
        for (Armor a : Armor.printArmors()
        ) {
            if (selectArmor == a.getId()) {
                if (this.getPlayer().getMoney() < a.getMoney()) {
                    System.out.println("Bakiye yetersiz.");
                } else {
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - a.getMoney());
                    System.out.println("Kalan para :" + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(a);
                    System.out.println(this.getPlayer().getName()+" karakterinin silahı "+this.getPlayer().getInventory().getWeapen().getName()+" hasarı:"+this.getPlayer().getDamage()+" parası:"+this.getPlayer().getMoney()+" zırhı:"+this.getPlayer().getInventory().getArmor().getName());
                    break;
                }
            }
        }
    }

}
