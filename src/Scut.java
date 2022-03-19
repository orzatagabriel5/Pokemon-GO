public class Scut implements ObiectSpecial{

    @Override
    public void boost(Pokemon pokemon){

        int newDef = pokemon.getDef() + 2;
        pokemon.setDef(newDef);

        int newSpecialDef = pokemon.getSpecialDef() + 2;
        pokemon.setSpecialDef(newSpecialDef);
    }

    public String getNume(){
        return "Scut";
    }
}
