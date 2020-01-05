package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BARREL_CAPACITY = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int SHOOT_BULLETS = 1;

    public Pistol(String name) {
        super(name, BARREL_CAPACITY, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if(super.getBulletsPerBarrel()==0){
            super.reload();
        }
        super.setBulletsPerBarrel(super.getBulletsPerBarrel()-SHOOT_BULLETS);
        return SHOOT_BULLETS;
    }
}
