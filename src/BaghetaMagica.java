public class BaghetaMagica implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        if(pokemon.getSpecialAttack() != 0) {
            int newSpecialAttack = pokemon.getSpecialAttack() + 3;
            pokemon.setSpecialAttack(newSpecialAttack);
        }

    }

    public String getNume() {
        return "Bagheta Magica";
    }
}
