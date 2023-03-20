import java.util.Scanner;

public class Player {
    private int damage;
    private int healty;
    private int originalHealthy;
    private int money;
    private String name;
    private Inventory inventory;

    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }

    void selectChar() {
        System.out.println("Sayın "+this.getName()+" Oyuna hoşgeldiniz.");
        System.out.println("------------------------------------------------------------");
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gamechar : charList
        ) {
            System.out.println("ID: " + gamechar.getId() + " " + gamechar.getName() + " karakterinin  hasarı:" + gamechar.damage + "  sağlığı:" + gamechar.healthy + "   parası:" + gamechar.money);
        }
        System.out.println("------------------------------------------------------------");
        System.out.print("Lütfen karakter seçiniz:");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;

        }
    }

    void initPlayer(GameChar gamechar) {
        this.setDamage(gamechar.getDamage());
        this.setHealty(gamechar.getHealthy());
        this.setOriginalHealthy(gamechar.getHealthy());
        this.setMoney(gamechar.getMoney());
        this.setName(gamechar.getName());
    }

    public void selectLocation() {
        Location lokasyon = null;
        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("***** Bölgeler *****");
            System.out.println("1. Güvenli Ev");
            System.out.println("2. Tool Store");
            System.out.println("3. Nehir");
            System.out.println("4. Mağara");
            System.out.println("5. Orman");
            System.out.println("6. Maden");
            System.out.println("0. Çıkış yap");
            System.out.println("------------------------------------------------------------");

            System.out.print("Bölge seçiniz:");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 1:
                    lokasyon = new SafeHouse(this);
                    break;
                case 2:
                    lokasyon = new ToolStore(this);
                    break;
                case 3:
                    lokasyon=new River(this);
                    break;
                case 4:
                    lokasyon=new Cave(this);
                    break;
                case 5:
                    lokasyon=new Forest(this);
                    break;
                case 6:
                    lokasyon=new Maden(this);
                    break;
                case 0:
                    lokasyon=null;
                    break;
                default:
                    System.out.println("Yanlış değer tekrar gir!");
                    continue;
            }
            if (lokasyon==null){
                System.out.println("Çabuk vazgeçtin.");
                break;
            }
            if(!lokasyon.onLocation()){
                System.out.println("Game over!!");
                break;
            }

        }

    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        if (healty<0)
            healty=0;
        this.healty = healty;
    }

    public int getMoney() {
        return money;
    }
    public int getTotalDamage() {
        return damage + this.getInventory().getWeapen().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealthy() {
        return originalHealthy;
    }

    public void setOriginalHealthy(int originalHealthy) {
        this.originalHealthy = originalHealthy;
    }
}


