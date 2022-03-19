import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int loggerType;

    public static void main(String[] args) throws IOException, InterruptedException {

        loggerType = Integer.parseInt(args[0]);

        GeneratorPokemoni generatorPokemoni = GeneratorPokemoni.getInstance();

        File file = new File(args[1]);
        Scanner scanner = new Scanner(file);

        Antrenor antrenor1 = creeazaAntrenor(generatorPokemoni, scanner);
        Antrenor antrenor2 = creeazaAntrenor(generatorPokemoni, scanner);

        Aventura aventura = new Aventura(antrenor1, antrenor2,
                generatorPokemoni.pokemons.get("Neutrel1"), generatorPokemoni.pokemons.get("Neutrel2"));

        aventura.start();

    }

    private static Antrenor creeazaAntrenor(GeneratorPokemoni generatorPokemoni, Scanner scanner) {

        Antrenor antrenor = new Antrenor();
        antrenor.setNume(scanner.nextLine());
        antrenor.setVarsta(Integer.parseInt(scanner.nextLine()));

        Pokemon pokemon1 = creeazaPokemon(generatorPokemoni, scanner);
        Pokemon pokemon2 = creeazaPokemon(generatorPokemoni, scanner);
        Pokemon pokemon3 = creeazaPokemon(generatorPokemoni, scanner);

        antrenor.addPokemon(pokemon1);
        antrenor.addPokemon(pokemon2);
        antrenor.addPokemon(pokemon3);

        return antrenor;
    }


    private static Pokemon creeazaPokemon(GeneratorPokemoni generatorPokemoni, Scanner scanner) {

        String[] buffer;
        ObiectSpecialFactory factory = new ObiectSpecialFactory();
        Pokemon pokemon = generatorPokemoni.pokemons.get(scanner.nextLine());
        buffer = scanner.nextLine().split("-");
        for(String obiect : buffer) {
            if(factory.createObiectSpecial(obiect) != null) {
                if(!pokemon.contineObiect(obiect)) {
                    pokemon.addObiectSpecial(factory.createObiectSpecial(obiect));
                }
            }
        }
        return pokemon;
    }

}
