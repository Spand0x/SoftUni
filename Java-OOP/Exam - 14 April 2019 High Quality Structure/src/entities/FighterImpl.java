package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double DEFAULT_HEALTH = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50.0;
    private static final double DEFFENCE_POINTS_MODIFIER = 25.0; //todo: maybe its defence;

    private boolean aggressiveMode;


    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints,DEFAULT_HEALTH);
        this.aggressiveMode = false;
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if(aggressiveMode){ //turning off
            aggressiveMode = false;
            super.setAttackPoints(super.getAttackPoints()-ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints()+DEFFENCE_POINTS_MODIFIER);

        }else { //turning on
            aggressiveMode = true;
            super.setAttackPoints(super.getAttackPoints()+ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints()-DEFFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(super.getName()).append(System.lineSeparator());
        sb.append(" *Type: Fighter").append(System.lineSeparator());
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format(" *Aggressive Mode(%s)",this.aggressiveMode?"ON":"OFF"));
        return sb.toString();
    }
}
