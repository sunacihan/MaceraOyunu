import java.awt.font.TextHitInfo;
import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int randomObstacle = randomObstacleNumber();
        System.out.println("Şuan buradasın :" + this.getName() + ", " + randomObstacle + " tane " + this.getObstacle().getName() + " çıkabilir !  Dikkatli ol !!!");
        System.out.print("<S>avaş veya <K>aç :");
        String selectCase = scanner.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(randomObstacle) && this.getPlayer().getHealty() > 0) {

                System.out.println(this.getName() + ": tüm canavarları öldürdünüz.");

                this.getPlayer().getInventory().setAward(this.award);
                System.out.println("Ödülünüz :" + this.getPlayer().getInventory().getAward());

                return true;
            }
        }
        if (this.getPlayer().getHealty() <= 0) {
            System.out.println("Öldünüz!!");
            return false;
        }

        return true;
    }
// 
    public boolean combat(int obsNumber) {
        int r = randomVurma();
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealthy(this.getObstacle().getOriginalHealthy());
            if (this.getObstacle().getName().equals("Yılan")){
                int d=randomDamage();
                this.getObstacle().setDamage(d);

            }
            while (this.getPlayer().getHealty() > 0 && this.getObstacle().getHealthy() > 0) {
                printPlayerStats();
                printObstacleStats(i);
                System.out.print("<V>ur veya <K>aç :");
                String selectCombat = scanner.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {

                    if (r == 1) {
                        this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getTotalDamage());
                        System.out.println("Siz vurdunuz.");
                        if (this.getObstacle().getHealthy() > 0) {
                            System.out.println("Canavarda size vurdu.");
                            int zirh = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (zirh < 0)
                                zirh = 0;
                            this.getPlayer().setHealty(this.getPlayer().getHealty() - zirh);
                        }
                    }
                    if (r == 2) {

                        System.out.println("Canavar size vurdu.");
                        int zirh = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (zirh < 0)
                            zirh = 0;
                        this.getPlayer().setHealty(this.getPlayer().getHealty() - zirh);
                        if (this.getPlayer().getHealty() > 0) {
                            this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getTotalDamage());
                            System.out.println("Sizde canavara vurdunuz.");
                        } else {
                            return false;
                        }


                    }

                }


            }

        }
        if (this.getObstacle().getHealthy() <= 0) {
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Canavarı yendiniz. Para ödülü kazandınız..");
            System.out.println("Paranız:" + this.getPlayer().getMoney());

        }


        return true;
    }

    public void printPlayerStats() {
        System.out.println("----------------------------------------------------");
        System.out.println("Oyuncunun Adı:" + this.getPlayer().getName()
                + "\nCanı :" + this.getPlayer().getHealty()
                + "\nParası :" + this.getPlayer().getMoney()
                + "\nHasarı :" + this.getPlayer().getTotalDamage()
                + "\nZırhı :" + this.getPlayer().getInventory().getArmor().getBlock());

    }

    public void printObstacleStats(int obsNumber) {
        System.out.println("--------------------------------------------------");
        System.out.println(obsNumber + ". Canavarın Adı:" + this.getObstacle().getName()
                + "\nCanı :" + this.getObstacle().getHealthy()
                + "\nHasarı :" + this.getObstacle().getDamage());

    }

    public int randomObstacleNumber() {
        Random r = new Random();

        return r.nextInt(this.maxObstacle) + 1;
    }

    public int randomVurma() {
        Random r = new Random();

        return r.nextInt(2) + 1;
    }
    public int randomDamage() {
        Random r = new Random();

        return r.nextInt(4) + 3;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
