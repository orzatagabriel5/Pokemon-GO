public class Vitamine implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        int newHP = pokemon.getHP() + 2;
        pokemon.setInitialHP(newHP);

        if(pokemon.getNormalAttack() != 0) {
            int newNormalAttack = pokemon.getNormalAttack() + 2;
            pokemon.setNormalAttack(newNormalAttack);
        }

        if(pokemon.getSpecialAttack() != 0) {
            int newSpecialAttack = pokemon.getSpecialAttack() + 2;
            pokemon.setSpecialAttack(newSpecialAttack);
        }

    }
    public String getNume() {
        return "Vitamine";
    }

}
