public class Vesta implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        int newHP = pokemon.getHP() + 10;
        pokemon.setInitialHP(newHP);
    }

    public String getNume() {
        return "Vesta";
    }
}
