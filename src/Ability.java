public class Ability{

    private int dmg;
    private boolean stun;
    private boolean dodge;
    private int cooldown;
    private int initialCooldown;


    public Ability() {}

    public void run(Pokemon attackingPokemon , Pokemon defensingPokemon){

        defensingPokemon.updateHP(dmg);

        defensingPokemon.setStunNextRound(this.stun);
        defensingPokemon.setStun(this.stun);

        attackingPokemon.setDodge(this.dodge);

        attackingPokemon.setCooldown(initialCooldown);

    }

    public void resetCooldown(){
        this.cooldown = initialCooldown;
    }

    public void updateCooldown() {
        if(this.cooldown > 0) {
            this.cooldown -= 1;
        }
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

    public void setInitialCooldown(int cooldown) {
        this.initialCooldown = cooldown;
    }

    public void restartCooldown(){
        this.cooldown = 0;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean isStun() {
        return stun;
    }

    public boolean isDodge() {
        return dodge;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getInitialCooldown() {
        return initialCooldown;
    }
}
