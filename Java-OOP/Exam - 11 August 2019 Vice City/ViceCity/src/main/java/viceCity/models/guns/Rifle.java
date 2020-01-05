package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int BARREL_CAPACITY = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int SHOOT_BULLETS = 5;

    public Rifle(String name) {
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
