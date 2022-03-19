import java.io.IOException;
import java.util.Random;

public class Aventura {


    private Antrenor antrenor1;
    private Antrenor antrenor2;
    private Pokemon neutrel1;
    private Pokemon neutrel2;
    private int pokemonAttacked = 0;
    private int attackType1;
    private int attackType2;
    private int contor = 1;

    private final StringBuffer logger1 = new StringBuffer();
    private final StringBuffer logger2 = new StringBuffer();
    private final StringBuffer logger3 = new StringBuffer();
    private final StringBuffer finalLogger = new StringBuffer();

    public Aventura(Antrenor antrenor1, Antrenor antrenor2, Pokemon neutrel1, Pokemon neutrel2) {
        this.antrenor1 = antrenor1;
        this.antrenor2 = antrenor2;
        this.neutrel1 = neutrel1;
        this.neutrel2 = neutrel2;
        this.pokemonAttacked = 0;
    }

    public void setNeutrel1(Pokemon neutrel1) {
        this.neutrel1 = neutrel1;
    }

    public void setNeutrel2(Pokemon neutrel2) {
        this.neutrel2 = neutrel2;
    }

    public void setAntrenor1(Antrenor antrenor1) {
        this.antrenor1 = antrenor1;
    }

    public void setAntrenor2(Antrenor antrenor2) {
        this.antrenor2 = antrenor2;
    }

    public Pokemon getNeutrel1() {
        return neutrel1;
    }

    public Pokemon getNeutrel2() {
        return neutrel2;
    }

    public Antrenor getAntrenor1() {
        return antrenor1;
    }

    public Antrenor getAntrenor2() {
        return antrenor2;
    }

    public void start() throws InterruptedException, IOException {

        Thread t1 = new Thread(new batalieIntrePokemoni(antrenor1.getPokemons(0), antrenor2.getPokemons(0), logger1));
        Thread t2 = new Thread(new batalieIntrePokemoni(antrenor1.getPokemons(1), antrenor2.getPokemons(1), logger2));
        Thread t3 = new Thread(new batalieIntrePokemoni(antrenor1.getPokemons(2), antrenor2.getPokemons(2), logger3));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        Thread.sleep(500);

        Pokemon p1 = bestPokemon(antrenor1);
        Pokemon p2 = bestPokemon(antrenor2);

        finalLogger.append("~~~~~~~~~~~~~~~~ In finala se vor duela ").append(p1.getNume())
                .append(" si ").append(p2.getNume()).append(" ~~~~~~~~~~~~~~~~\n\n");

        finalBattle(p1, p2, finalLogger);


        if(Main.loggerType == 0){

            StandardOutLogger logger = new StandardOutLogger();
            logger.print(logger1);
            logger.print(logger2);
            logger.print(logger3);
            logger.print(finalLogger);
        } else if (Main.loggerType == 1){

            FileLogger logger = new FileLogger();
            logger.print(logger1);
            logger.print(logger2);
            logger.print(logger3);
            logger.print(finalLogger);
        }

    }

    public Pokemon bestPokemon(Antrenor antrenor){

        int statsVal = 0, val = 0;
        Pokemon best = null;

        for(Pokemon p : antrenor.pokemons){
            val += p.getHP();
            val += p.getNormalAttack();
            val += p.getSpecialAttack();
            val += p.getDef();
            val += p.getSpecialDef();
            if(statsVal < val){
                best = p;
            } else if(statsVal == val){
                if(p.getNume().compareTo(best.getNume()) > 0){
                    best = p;
                }
            }
        }

        return best;
    }

    private void afisezaObiecte(Pokemon pokemon, StringBuffer buffer) {

        if (pokemon.getObiecteSpeciale() != null) {

            buffer.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n")
                    .append(pokemon.getNume()).append(" poarta urmatoarele obiecte speciale:\n");
            for (ObiectSpecial obiectSpecial : pokemon.getObiecteSpeciale()) {
                buffer.append("\t").append(obiectSpecial.getNume()).append("\n");
            }
        } else {
            buffer.append(pokemon.getNume()).append(" nu poarta obiecte speciale\n");
        }
        buffer.append("\n");
    }

    public static int choseAttack(Pokemon pokemon) {

        Random rand = new Random();
        if (pokemon.getNormalAttack() != 0) {
            if (pokemon.getAbility1() != null || pokemon.getAbility2() != null) {

                if (pokemon.getAbility1().getCooldown() == 0 && pokemon.getAbility2().getCooldown() == 0) {
                    int[] attacks = {0, 2, 3};
                    return attacks[rand.nextInt(3)];
                }
                if (pokemon.getAbility1().getCooldown() == 0) {
                    int[] attacks = {0, 2};
                    return attacks[rand.nextInt(2)];
                }
                if (pokemon.getAbility2().getCooldown() == 0) {
                    int[] attacks = {0, 3};
                    return attacks[rand.nextInt(2)];
                }
                return 0;
            }
        } else if (pokemon.getSpecialAttack() != 0) {
            if (pokemon.getAbility1() != null || pokemon.getAbility2() != null) {

                if (pokemon.getAbility1().getCooldown() == 0 && pokemon.getAbility2().getCooldown() == 0) {
                    int[] attacks = {1, 2, 3};

                    return attacks[rand.nextInt(3)];
                }
                if (pokemon.getAbility1().getCooldown() == 0) {
                    int[] attacks = {1, 2};
                    return attacks[rand.nextInt(2)];
                }
                if (pokemon.getAbility2().getCooldown() == 0) {
                    int[] attacks = {1, 3};
                    return attacks[rand.nextInt(2)];
                }
                return 1;
            }
        }
        return 0;
    }


    public void printAttacks(Pokemon pokemon1, Pokemon pokemon2, StringBuffer buffer, int contor, int pokemon1Attack, int pokemon2Attack) {

        switch (pokemon1Attack) {
            case (0):
                if (pokemon1.isStun()) {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" nu face nimic / ");
                } else {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" atac normal / ");
                }
                break;
            case (1):
                if (pokemon1.isStun()) {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" nu face nimic / ");
                } else {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" atac special / ");
                }
                break;
            case (2):
                if (pokemon1.isStun()) {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" nu face nimic / ");
                } else {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" abilitate 1 / ");
                    pokemon1.setDodge(pokemon1.getAbility1().isDodge());
                }
                break;
            case (3):
                if (pokemon1.isStun()) {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" nu face nimic / ");
                } else {
                    buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" abilitate 2 / ");
                    pokemon1.setDodge(pokemon1.getAbility2().isDodge());
                }
                break;
            default:
                System.out.println("Nu merge bine");
                break;
        }

        switch (pokemon2Attack) {
            case (0):
                if (pokemon2.isStun()) {
                    buffer.append(pokemon2.getNume()).append(" nu face nimic -> Rezultat:\n");
                } else {
                    buffer.append(pokemon2.getNume()).append(" atac normal -> Rezultat:\n");
                }
                break;
            case (1):
                if (pokemon2.isStun()) {
                    buffer.append(pokemon2.getNume()).append(" nu face nimic -> Rezultat:\n");
                } else {
                    buffer.append(pokemon2.getNume()).append(" atac special -> Rezultat:\n");
                }
                break;
            case (2):
                if (pokemon2.isStun()) {
                    buffer.append(pokemon2.getNume()).append(" nu face nimic -> Rezultat:\n");
                } else {
                    buffer.append(pokemon2.getNume()).append(" abilitate 1 -> Rezultat:\n");
                    pokemon2.setDodge(pokemon2.getAbility1().isDodge());
                }
                break;
            case (3):
                if (pokemon2.isStun()) {
                    buffer.append(pokemon2.getNume()).append(" nu face nimic -> Rezultat:\n");
                } else {
                    buffer.append(pokemon2.getNume()).append(" abilitate 2 -> Rezultat:\n");
                    pokemon2.setDodge(pokemon2.getAbility2().isDodge());
                }
                break;
            default:
                System.out.println("Nu merge bine");
                break;
        }

    }

    public void finalBattle(Pokemon pokemon1, Pokemon pokemon2, StringBuffer buffer) throws InterruptedException {


        Thread atacaPokemon1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atacaPokemon1(pokemon1, pokemon2, buffer);
            }
        });

        Thread atacaPokemon2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atacaPokemon2(pokemon1, pokemon2, buffer);
            }
        });

        atacaPokemon1.start();
        atacaPokemon2.start();
        atacaPokemon1.join();
        atacaPokemon2.join();


        if (pokemon2.getHP() > 0) {
            pokemon2.increaseStats();
            pokemon2.regenerate();
            buffer.append("********** A castigat ").append(pokemon2.getNume())
                    .append(" **********").append("\n");
        } else {
            pokemon2.regenerate();
        }
        if (pokemon1.getHP() > 0) {
            pokemon1.increaseStats();
            pokemon1.regenerate();
            buffer.append("********** A castigat ").append(pokemon1.getNume())
                    .append(" **********").append("\n");
        } else {
            pokemon1.regenerate();
        }

        if(pokemon1.getHP() <= 0 && pokemon2.getHP() <= 0){
            pokemon1.regenerate();
            pokemon2.regenerate();
            buffer.append("********** REMIZA **********\n");
        }
        pokemonAttacked = 0;

    }

    public void printPokemon1Attack(Pokemon pokemon1, Pokemon pokemon2, int attackType1, int attackType2, StringBuffer buffer) {

        int damage;
        switch (attackType1) {
            case 0 -> {

                if (!pokemon1.isStun() && !pokemon2.isDodge()) {
                    damage = pokemon1.getNormalAttack() - pokemon2.getDef();
                    if (damage > 0) {
                        pokemon2.updateHP(damage);
                    }
                }

                if (pokemon1.isStun()) {
                    pokemon1.setStun(false);
                }
            }
            case 1 -> {
                if (!pokemon1.isStun() && !pokemon2.isDodge()) {
                    damage = pokemon1.getSpecialAttack() - pokemon2.getSpecialDef();
                    if (damage > 0) {
                        pokemon2.updateHP(damage);
                    }
                }
                if (pokemon1.isStun()) {
                    pokemon1.setStun(false);
                }
            }
            case 2 -> {

                pokemon1.getAbility1().resetCooldown();

                if (!pokemon1.isStun() && !pokemon2.isDodge()) {
                    pokemon1.getAbility1().run(pokemon1, pokemon2);
                }

                if (pokemon1.isStun()) {
                    pokemon1.setStun(false);
                }
            }
            case 3 -> {

                pokemon1.getAbility2().resetCooldown();

                if (!pokemon1.isStun() && !pokemon2.isDodge()) {
                    pokemon1.getAbility2().run(pokemon1, pokemon2);
                }

                if (pokemon1.isStun()) {
                    pokemon1.setStun(false);
                }
            }
            default -> {
                System.out.println("Nu merge bine");
            }
        }
    }


        public void atacaPokemon1(Pokemon pokemon1, Pokemon pokemon2, StringBuffer buffer) {

            while (pokemon1.getHP() > 0 && pokemon2.getHP() > 0) {

                synchronized (this) {
                    try {
                        if (pokemonAttacked == 1) {
                            wait();

                            if(pokemon1.getHP() <= 0 || pokemon2.getHP() <= 0) {
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    attackType1 = choseAttack(pokemon1);
                    attackType2 = choseAttack(pokemon2);

                    printAttacks(pokemon1, pokemon2, buffer, contor++, attackType1, attackType2);
                    printPokemon1Attack(pokemon1, pokemon2, attackType1, attackType2, buffer);
                    pokemonAttacked = 1;
                    notify();
                }
            }
            contor = 1;

        }

    public void printPokemon2Attack(Pokemon pokemon2, Pokemon pokemon1, int attackType2, int attackType1, StringBuffer buffer) {

        int damage;
        switch (attackType2) {
            case (0) -> {
                if (!pokemon2.isStun() && !pokemon1.isDodge()) {

                    damage = pokemon2.getNormalAttack() - pokemon1.getDef();
                    if (damage > 0) {
                        pokemon1.updateHP(damage);
                    }
                }
                if (pokemon2.isStun()) {
                    pokemon2.setStun(false);
                }
                buffer.append("a. ").append(pokemon1.getNume()).append(" HP ");
                if (pokemon1.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon1.getHP());
                } else {
                    buffer.append(pokemon1.getHP());
                }
                if (pokemon1.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                }
                if (pokemon1.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown());
                }
                buffer.append("\nb. ").append(pokemon2.getNume()).append(" HP ");
                if (pokemon2.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon2.getHP());
                } else {
                    buffer.append(pokemon2.getHP());
                }
                if (pokemon2.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon2.getAbility1().getCooldown());
                }
                if (pokemon2.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon2.getAbility2().getCooldown());
                }

                buffer.append("\n\n");
            }
            case (1) -> {
                if (!pokemon2.isStun() && !pokemon1.isDodge()) {
                    damage = pokemon2.getSpecialAttack() - pokemon1.getSpecialDef();
                    if (damage > 0) {
                        pokemon1.updateHP(damage);
                    }
                }
                if (pokemon2.isStun()) {
                    pokemon2.setStun(false);
                }
                buffer.append("a. ").append(pokemon1.getNume()).append(" HP ");
                if (pokemon1.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon1.getHP());
                    pokemon1.setDodge(false);
                } else {
                    buffer.append(pokemon1.getHP());
                }
                if (pokemon1.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                }
                if (pokemon1.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown());
                }
                buffer.append("\nb. ").append(pokemon2.getNume()).append(" HP ");
                if (pokemon2.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon2.getHP());
                    pokemon2.setDodge(false);
                } else {
                    buffer.append(pokemon2.getHP());
                }

                if (pokemon1.isStunNextRound()) {
                    buffer.append(", este stuned de la abilitatea 1 a lui ").append(pokemon2.getNume());
                    pokemon1.setStunNextRound(false);
                    pokemon1.setStun(true);
                }

                if (pokemon2.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon2.getAbility1().getCooldown());
                }
                if (pokemon2.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon2.getAbility2().getCooldown());
                }
                buffer.append("\n\n");
            }
            case (2) -> {
                pokemon2.getAbility1().resetCooldown();
                if (!pokemon2.isStun() && !pokemon1.isDodge()) {
                    pokemon2.getAbility1().run(pokemon2, pokemon1);
                }
                if (pokemon2.isStun()) {
                    pokemon2.setStun(false);
                }
                buffer.append("a. ").append(pokemon1.getNume()).append(" HP ");
                if (pokemon1.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon1.getHP());
                    pokemon1.setDodge(false);

                } else {
                    buffer.append(pokemon1.getHP());
                }
                if (pokemon1.isStunNextRound()) {
                    buffer.append(", este stuned de la abilitatea 1 a lui ").append(pokemon2.getNume());
                    pokemon1.setStunNextRound(false);
                    pokemon1.setStun(true);
                }
                if (pokemon1.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                }
                if (pokemon1.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown());
                }
                buffer.append("\nb. ").append(pokemon2.getNume()).append(" HP ");
                if (pokemon2.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon2.getHP());
                    pokemon2.setDodge(false);
                } else {
                    buffer.append(pokemon2.getHP());
                }

                if (pokemon2.isStunNextRound()) {
                    buffer.append(", este stuned de la abilitatea ").append(attackType1 - 1)
                            .append(" a lui ").append(pokemon1.getNume());
                    pokemon2.setStunNextRound(false);
                    pokemon2.setStun(true);
                }

                if (pokemon2.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon2.getAbility1().getCooldown());
                }

                if (pokemon2.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon2.getAbility2().getCooldown());
                }
                buffer.append("\n\n");
            }
            case (3) -> {
                pokemon2.getAbility2().resetCooldown();
                if (!pokemon2.isStun() && !pokemon1.isDodge()) {
                    pokemon2.getAbility2().run(pokemon2, pokemon1);
                }
                if (pokemon2.isStun()) {
                    pokemon2.setStun(false);
                }
                buffer.append("a. ").append(pokemon1.getNume()).append(" HP ");
                if (pokemon1.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon1.getHP());
                    pokemon1.setDodge(false);
                } else {
                    buffer.append(pokemon1.getHP());
                }
                if (pokemon1.isStunNextRound()) {
                    buffer.append(", este stuned de la abilitatea 2 a lui ").append(pokemon2.getNume());
                    pokemon1.setStunNextRound(false);
                    pokemon1.setStun(true);
                }
                if (pokemon1.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                }
                if (pokemon1.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown());
                }
                buffer.append("\nb. ").append(pokemon2.getNume()).append(" HP ");
                if (pokemon2.isDodge()) {
                    buffer.append("(dodge) ").append(pokemon2.getHP());
                    pokemon2.setDodge(false);
                } else {
                    buffer.append(pokemon2.getHP());
                }
                if (pokemon2.isStunNextRound()) {
                    buffer.append(", este stuned de la abilitatea ").append(attackType1 - 1)
                            .append(" a lui ").append(pokemon1.getNume());
                    pokemon2.setStunNextRound(false);
                    pokemon2.setStun(true);
                }
                if (pokemon2.getAbility1().getCooldown() != 0) {
                    buffer.append(", abilitate 1 cooldown ").append(pokemon2.getAbility1().getCooldown());
                }
                if (pokemon2.getAbility2().getCooldown() != 0) {
                    buffer.append(", abilitate 2 cooldown ").append(pokemon2.getAbility2().getCooldown());
                }
                buffer.append("\n\n");
            }
            default -> System.out.println("Nu merge bine");
        }

        pokemon1.getAbility1().updateCooldown();
        pokemon1.getAbility2().updateCooldown();
        pokemon2.getAbility1().updateCooldown();
        pokemon2.getAbility2().updateCooldown();

    }

    public void atacaPokemon2(Pokemon pokemon1, Pokemon pokemon2, StringBuffer buffer) {

        while (pokemon1.getHP() > 0 && pokemon2.getHP() >  0) {

            synchronized (this) {

                if (pokemonAttacked == 2) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                printPokemon2Attack(pokemon2, pokemon1, attackType2, attackType1, buffer);
                pokemonAttacked = 2;
                notify();
            }
        }

    }

    class batalieIntrePokemoni implements Runnable {

        private Pokemon pokemon1;
        private Pokemon pokemon2;
        private final StringBuffer buffer;
        battleNeutrel runBattle = new battleNeutrel();

        public batalieIntrePokemoni(Pokemon pokemon1, Pokemon pokemon2, StringBuffer buffer) {
            this.pokemon1 = pokemon1;
            this.pokemon2 = pokemon2;
            this.buffer = buffer;
        }

        public void setPokemon1(Pokemon pokemon1) {
            this.pokemon1 = pokemon1;
        }

        public void setPokemon2(Pokemon pokemon2) {
            this.pokemon2 = pokemon2;
        }

        public Pokemon getPokemon1() {
            return pokemon1;
        }

        public Pokemon getPokemon2() {
            return pokemon2;
        }

        public void run() {

            afisezaObiecte(pokemon1, buffer);
            afisezaObiecte(pokemon2, buffer);

            Random rand = new Random();
            while (true) {

                int battleType = rand.nextInt(3);
                switch (battleType) {
                    case 0 -> {
                        buffer.append("~~~~~~~~~~~~~~ Pokemonii se vor lupta cu Neutrel1. ~~~~~~~~~~~~~~\n\n");
                        runBattle.BattleNeutrel(pokemon1, neutrel1, buffer);
                        runBattle.BattleNeutrel(pokemon2, neutrel1, buffer);
                    }
                    case 1 -> {
                        buffer.append("~~~~~~~~~~~~~~ Pokemonii se vor lupta cu Neutrel2. ~~~~~~~~~~~~~~\n\n");
                        runBattle.BattleNeutrel(pokemon1, neutrel2, buffer);
                        runBattle.BattleNeutrel(pokemon2, neutrel2, buffer);
                    }
                    case 2 -> {

                        buffer.append("~~~~~~~~~~~~~~ ").append(pokemon1.getNume()).append(" si ")
                                .append(pokemon2.getNume()).append(" se vor lupta intre ei. ~~~~~~~~~~~~~~\n\n");
                        try {
                            finalBattle(pokemon1, pokemon2, buffer);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    default -> {
                        System.out.println("Nu merge bine");
                    }
                }
                if (battleType == 2) {
                    break;
                }
            }
        }
    }
}



