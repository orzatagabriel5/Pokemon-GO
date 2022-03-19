public class BradDeCraciun implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        if(pokemon.getNormalAttack() != 0) {
            int newNormalAttack = pokemon.getNormalAttack() + 3;
            pokemon.setNormalAttack(newNormalAttack);
        }

        int newDef = pokemon.getDef() + 1;
        pokemon.setDef(newDef);

    }

    public String getNume() {
        return "Brad de Craciun";
    }
}
