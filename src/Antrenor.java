import java.util.ArrayList;

public class Antrenor {

    String nume;
    int varsta;
    ArrayList<Pokemon> pokemons = new ArrayList<>(3);

    public Antrenor() {}

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public Pokemon getPokemons(int index) {

        return pokemons.get(index);
    }
}
