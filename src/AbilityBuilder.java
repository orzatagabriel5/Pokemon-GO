public class AbilityBuilder {


    Ability ability = new Ability();

    public AbilityBuilder dmg(int newDmg){
        ability.setDmg(newDmg);
        return this;
    }

    public AbilityBuilder stun(boolean newStun){
        ability.setStun(newStun);
        return this;
    }

    public AbilityBuilder dodge(boolean newDodge){
        ability.setDodge(newDodge);
        return this;
    }

    public AbilityBuilder cooldown(int newCooldown){
        ability.setInitialCooldown(newCooldown);
        return this;
    }

    public Ability build() {
        return ability;
    }

}
