public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

@Override
public boolean onLocation(){
    System.out.println("Güvenli evdesiniz.\n Canınız yenilendi.");
    System.out.println("Önceki can:"+this.getPlayer().getHealty());
    this.getPlayer().setHealty(this.getPlayer().getOriginalHealthy());
    System.out.println("Sonraki can:"+this.getPlayer().getHealty());
    return  true;
    }
}
