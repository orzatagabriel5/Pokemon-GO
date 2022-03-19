public class Sabiuta implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        if(pokemon.getNormalAttack() != 0) {
            int newNormalAttack = pokemon.getNormalAttack() + 3;
            pokemon.setNormalAttack(newNormalAttack);
        }
    }

    public String getNume() {
        return "Sabiuta";
    }
}
