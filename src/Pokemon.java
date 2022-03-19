import java.util.ArrayList;

public class Pokemon {

    private String nume;
    private int HP;
    private int initialHP;
    private int normalAttack;
    private int specialAttack;
    private int def;
    private int specialDef;
    private boolean stun;
    private boolean stunNextRound;
    private boolean dodge;
    private int cooldown;
    private Ability ability1;
    private Ability ability2;
    private ArrayList<ObiectSpecial> obiecteSpeciale;

    public void addObiectSpecial(ObiectSpecial obiect) {

        if(obiecteSpeciale == null){
            obiecteSpeciale = new ArrayList<>();
            obiecteSpeciale.add(obiect);
        } else {
            obiecteSpeciale.add(obiect);
        }
        obiect.boost(this);
    }

    public void regenerate(){
        this.HP = this.initialHP;
        this.stun = false;
        this.dodge = false;
        if(this.ability1 != null) {
            this.ability1.restartCooldown();
        }
        if(this.ability2 != null) {
            this.ability2.restartCooldown();
        }
    }

    public void increaseStats() {
        this.initialHP += 1;
        if(this.normalAttack != 0) {
            this.normalAttack += 1;
        }
        if(this.specialAttack != 0){
            this.specialAttack += 1;
        }
        this.def += 1;
        this.specialDef += 1;
    }

    public boolean contineObiect(String nume){
        if(this.getObiecteSpeciale() != null) {
            for (ObiectSpecial o : this.getObiecteSpeciale()) {
                if (nume.compareTo(o.getNume()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateHP(int damage){
        this.HP -= damage;
    }

    public void setStunNextRound(boolean stunNextRound) {
        this.stunNextRound = stunNextRound;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public void setDodge(boolean dodge) {
        this.dodge = dodge;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setInitialHP(int HP) {
        this.initialHP = HP;
        this.HP = HP;
    }

    public void setNormalAttack(int normalAttack) {
        this.normalAttack = normalAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpecialDef(int specialDef) {
        this.specialDef = specialDef;
    }

    public Ability getAbility1() {
        return ability1;
    }

    public Ability getAbility2() {
        return ability2;
    }

    public int getCooldown() {
        return cooldown;
    }

    public String getNume() {
        return nume;
    }

    public boolean isStun() {
        return stun;
    }

    public boolean isStunNextRound() {
        return stunNextRound;
    }

    public boolean isDodge() {
        return dodge;
    }

    public int getHP() {
        return HP;
    }

    public int getNormalAttack() {
        return normalAttack;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getDef() {
        return def;
    }

    public int getSpecialDef() {
        return specialDef;
    }

    public ArrayList<ObiectSpecial> getObiecteSpeciale() {
        return obiecteSpeciale;
    }
}
