import java.util.HashMap;

public class GeneratorPokemoni {
    public static GeneratorPokemoni generator;
    HashMap<String, Pokemon> pokemons = new HashMap<>();

    private GeneratorPokemoni() {
        generatePokemons();
    }

    public static GeneratorPokemoni getInstance() {
        if (generator == null)
            generator = new GeneratorPokemoni();
        return generator;
    }

    public void generatePokemons() {


        Pokemon Neutrel1 = new PokemonBuilder().withName("Neutrel1").withInitialHP(10)
                .withNormalAttack(3).withDefense(1).withSpecialDefense(1).build();
        pokemons.put("Neutrel1", Neutrel1);

        Pokemon Neutrel2 = new PokemonBuilder().withName("Neutrel2").withInitialHP(20)
                .withNormalAttack(4).withDefense(1).withSpecialDefense(1).build();
        pokemons.put("Neutrel2", Neutrel2);

        Pokemon Pikachu = new PokemonBuilder().
                withName("Pikachu")
                .withInitialHP(35)
                .withSpecialAttack(4).
                withDefense(2)
                .withSpecialDefense(3)
                .withAbility1(new AbilityBuilder()
                        .dmg(6)
                        .stun(false)
                        .dodge(false)
                        .cooldown(4)
                        .build())
                .withAbility2(new AbilityBuilder()
                        .dmg(4)
                        .stun(true)
                        .dodge(true)
                        .cooldown(5)
                        .build())
                .build();

        pokemons.put("Pikachu", Pikachu);

        Pokemon Bulbasaur = new PokemonBuilder().withName("Bulbasaur").withInitialHP(42)
                .withSpecialAttack(5).withDefense(3).withSpecialDefense(1)
                .withAbility1(new AbilityBuilder().dmg(6).stun(false).dodge(false).cooldown(4).build())
                .withAbility2(new AbilityBuilder().dmg(5).stun(false).dodge(false).cooldown(3).build()).build();
        pokemons.put("Bulbasaur", Bulbasaur);

        Pokemon Charmander = new PokemonBuilder().withName("Charmander").withInitialHP(50)
                .withNormalAttack(4).withDefense(3).withSpecialDefense(2)
                .withAbility1(new AbilityBuilder().dmg(4).stun(true).dodge(false).cooldown(4).build())
                .withAbility2(new AbilityBuilder().dmg(7).stun(false).dodge(false).cooldown(6).build()).build();
        pokemons.put("Charmander", Charmander);

        Pokemon Squirtle = new PokemonBuilder().withName("Squirtle").withInitialHP(60)
                .withSpecialAttack(3).withDefense(5).withSpecialDefense(5)
                .withAbility1(new AbilityBuilder().dmg(4).stun(false).dodge(false).cooldown(3).build())
                .withAbility2(new AbilityBuilder().dmg(2).stun(true).dodge(false).cooldown(2).build()).build();
        pokemons.put("Squirtle", Squirtle);

        Pokemon Snorlax = new PokemonBuilder().withName("Snorlax").withInitialHP(62)
                .withNormalAttack(3).withDefense(6).withSpecialDefense(4)
                .withAbility1(new AbilityBuilder().dmg(4).stun(true).dodge(false).cooldown(5).build())
                .withAbility2(new AbilityBuilder().dmg(0).stun(false).dodge(true).cooldown(5).build()).build();
        pokemons.put("Snorlax", Snorlax);

        Pokemon Vulpix = new PokemonBuilder().withName("Vulpix").withInitialHP(36)
                .withNormalAttack(5).withDefense(2).withSpecialDefense(4)
                .withAbility1(new AbilityBuilder().dmg(8).stun(true).dodge(false).cooldown(6).build())
                .withAbility2(new AbilityBuilder().dmg(2).stun(false).dodge(true).cooldown(7).build()).build();
        pokemons.put("Vulpix", Vulpix);

        Pokemon Eevee = new PokemonBuilder().withName("Eevee").withInitialHP(39)
                .withSpecialAttack(4).withDefense(3).withSpecialDefense(3)
                .withAbility1(new AbilityBuilder().dmg(5).stun(false).dodge(false).cooldown(3).build())
                .withAbility2(new AbilityBuilder().dmg(3).stun(true).dodge(false).cooldown(3).build()).build();
        pokemons.put("Eevee", Eevee);

        Pokemon Jigglypuff = new PokemonBuilder().withName("Jigglypuff").withInitialHP(34)
                .withNormalAttack(4).withDefense(2).withSpecialDefense(3)
                .withAbility1(new AbilityBuilder().dmg(4).stun(true).dodge(false).cooldown(4).build())
                .withAbility2(new AbilityBuilder().dmg(3).stun(true).dodge(false).cooldown(4).build()).build();
        pokemons.put("Jigglypuff", Jigglypuff);

        Pokemon Meowth = new PokemonBuilder().withName("Meowth").withInitialHP(41)
                .withNormalAttack(3).withDefense(4).withSpecialDefense(2)
                .withAbility1(new AbilityBuilder().dmg(5).stun(false).dodge(true).cooldown(4).build())
                .withAbility2(new AbilityBuilder().dmg(1).stun(false).dodge(true).cooldown(3).build()).build();
        pokemons.put("Meowth", Meowth);

        Pokemon Psyduck = new PokemonBuilder().withName("Psyduck").withInitialHP(43)
                .withNormalAttack(3).withDefense(3).withSpecialDefense(3)
                .withAbility1(new AbilityBuilder().dmg(2).stun(false).dodge(false).cooldown(4).build())
                .withAbility2(new AbilityBuilder().dmg(2).stun(true).dodge(false).cooldown(5).build()).build();
        pokemons.put("Psyduck", Psyduck);

    }
}
