public class Weapen {
   private int id;
  private int damage;
   private int price;
   private String name;


    public Weapen(String name, int id, int damage, int price) {
        this.name=name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }
    public static Weapen[] printWeapen(){
        Weapen[] weapenList=new Weapen[3];
        weapenList[0]=new Weapen("Tabanca",1,2,25);
        weapenList[1]=new Weapen("Kılıç",2,3,35);
        weapenList[2]=new Weapen("Tüfek",3,7,45);

        return weapenList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
