public class PokemonBuilder {

    Pokemon pokemon = new Pokemon();

    public Pokemon build(){
        return pokemon;
    }

    public PokemonBuilder withName(String name){
        pokemon.setNume(name);
        return this;
    }

    public PokemonBuilder withInitialHP(int initialHP){
        pokemon.setInitialHP(initialHP);
        return this;
    }
    public PokemonBuilder withNormalAttack(int normalAttack){
        pokemon.setNormalAttack(normalAttack);
        return this;
    }
    public PokemonBuilder withSpecialAttack(int specialAttack){
        pokemon.setSpecialAttack(specialAttack);
        return this;
    }
    public PokemonBuilder withDefense(int defense){
        pokemon.setDef(defense);
        return this;
    }
    public PokemonBuilder withSpecialDefense(int specialDefense){
        pokemon.setSpecialDef(specialDefense);
        return this;
    }
    public PokemonBuilder withAbility1(Ability ability1){
        pokemon.setAbility1(ability1);
        return this;
    }
    public PokemonBuilder withAbility2(Ability ability2){
        pokemon.setAbility2(ability2);
        return this;
    }
}
