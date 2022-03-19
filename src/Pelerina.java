public class Pelerina implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon) {

        int newSpecialDef = pokemon.getSpecialDef() + 3;
        pokemon.setSpecialDef(newSpecialDef);
    }

    public String getNume() {
        return "Pelerina";
    }
}
