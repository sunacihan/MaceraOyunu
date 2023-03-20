import java.util.PrimitiveIterator;

public class Inventory {
    private Weapen weapen;
    private Armor armor;
    private String award;


    public Inventory() {
        this.weapen = new Weapen("Yumruk",0,0,0);
        this.armor=new Armor("Paçavra",0,0,0);

    }


    public Weapen getWeapen() {
        return weapen;
    }

    public void setWeapen(Weapen weapen) {
        this.weapen = weapen;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
