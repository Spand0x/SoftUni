package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double DEFAULT_HEALTH = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40.0;
    private static final double DEFFENCE_POINTS_MODIFIER = 30.0; //todo: maybe its defence;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints,DEFAULT_HEALTH);
        this.defenseMode = false;
        this.toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if(defenseMode){
            this.defenseMode = false;
            super.setAttackPoints(super.getAttackPoints()+ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints()-DEFFENCE_POINTS_MODIFIER);
        }else {
            this.defenseMode = true;
            super.setAttackPoints(super.getAttackPoints()-ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints()+DEFFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(super.getName()).append(System.lineSeparator());
        sb.append(" *Type: Tank").append(System.lineSeparator());
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format(" *Defense Mode(%s)",this.defenseMode?"ON":"OFF"));
        return sb.toString();
    }
}
