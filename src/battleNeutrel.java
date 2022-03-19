public class battleNeutrel {

    public void BattleNeutrel(Pokemon pokemon1, Pokemon neutrel, StringBuffer buffer) {

        int damage, contor = 1;
        while (pokemon1.getHP() > 0 && neutrel.getHP() > 0) {

            int pokemon1Attack = Aventura.choseAttack(pokemon1);

            switch (pokemon1Attack) {
                case 0 -> {
                    if (neutrel.isStun()) {
                        buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" atac normal / ")
                                .append(neutrel.getNume()).append(" nu face nimic -> Rezultat:\n");
                    } else {
                        buffer.append(contor).append(". ").append(pokemon1.getNume())
                                .append(" atac normal / ").append(neutrel.getNume()).append(" atac normal -> Rezultat:\n");
                    }
                    if (!neutrel.isStun()) {
                        damage = neutrel.getNormalAttack() - pokemon1.getDef();
                        if (damage > 0) {
                            pokemon1.updateHP(damage);
                        }
                    } else {
                        neutrel.setStun(false);
                    }

                    damage = pokemon1.getNormalAttack() - neutrel.getDef();
                    if (damage > 0) {
                        neutrel.updateHP(damage);
                    }

                    buffer.append("a. ").append(pokemon1.getNume()).append(" HP ").append(pokemon1.getHP());
                    if (pokemon1.getAbility1().getCooldown() != 0) {
                        buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                    }
                    if (pokemon1.getAbility2().getCooldown() != 0) {
                        buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown()).append("\n");
                    } else {
                        buffer.append("\n");
                    }
                    buffer.append("b. ").append(neutrel.getNume()).append(" HP ").append(neutrel.getHP()).append("\n\n");
                }
                case 1 -> {
                    if (neutrel.isStun()) {
                        buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" atac special / ").append(neutrel.getNume()).append(" nu face nimic -> Rezultat:\n");
                    } else {
                        buffer.append(contor).append(". ").append(pokemon1.getNume())
                                .append(" atac special / ").append(neutrel.getNume()).append(" atac normal -> Rezultat:\n");
                    }
                    if (!neutrel.isStun()) {
                        damage = neutrel.getNormalAttack() - pokemon1.getDef();
                        if (damage > 0) {
                            pokemon1.updateHP(damage);
                        }
                    } else {
                        neutrel.setStun(false);
                    }

                    damage = pokemon1.getSpecialAttack() - neutrel.getDef();
                    if (damage > 0) {
                        neutrel.updateHP(damage);
                    }

                    buffer.append("a. ").append(pokemon1.getNume()).append(" HP ").append(pokemon1.getHP());
                    if (pokemon1.getAbility1().getCooldown() != 0) {
                        buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                    }
                    if (pokemon1.getAbility2().getCooldown() != 0) {
                        buffer.append(", abilitate 2 cooldown ").append(pokemon1.getAbility2().getCooldown()).append("\n");
                    } else {
                        buffer.append("\n");
                    }
                    buffer.append("b. ").append(neutrel.getNume()).append(" HP ").append(neutrel.getHP()).append("\n\n");
                }
                case 2 -> {
                    pokemon1.getAbility1().resetCooldown();

                    if (neutrel.isStun()) {
                        buffer.append(contor).append(". ").append(pokemon1.getNume())
                                .append(" abilitate 1 / ").append(neutrel.getNume()).append(" nu face nimic -> Rezultat:\n");
                    } else {
                        buffer.append(contor).append(". ").append(pokemon1.getNume())
                                .append(" abilitate 1 / ").append(neutrel.getNume()).append(" atac normal -> Rezultat:\n");
                    }

                    if (!neutrel.isStun() && !pokemon1.getAbility1().isDodge()) {
                        damage = neutrel.getNormalAttack() - pokemon1.getDef();
                        if (damage > 0) {
                            pokemon1.updateHP(damage);
                        }
                    }
                    if (neutrel.isStun()) {
                        neutrel.setStun(false);
                    }

                    pokemon1.getAbility1().run(pokemon1, neutrel);
                    if (pokemon1.getAbility1().isDodge()) {
                        buffer.append("a. ").append(pokemon1.getNume()).append(" HP (dodge) ")
                                .append(pokemon1.getHP()).append(", abilitate 1 cooldown ")
                                .append(pokemon1.getAbility1().getInitialCooldown());
                    } else {
                        buffer.append("a. ").append(pokemon1.getNume()).append(" HP ")
                                .append(pokemon1.getHP()).append(", abilitate 1 cooldown ")
                                .append(pokemon1.getAbility1().getInitialCooldown());
                    }

                    if (pokemon1.getAbility2().getCooldown() != 0) {
                        buffer.append(", abilitate 2 cooldowmn ").append(pokemon1.getAbility2().getCooldown());
                    }
                    buffer.append("\n");


                    if (pokemon1.getAbility1().isStun()) {
                        buffer.append("b. ").append(neutrel.getNume()).append(" HP ")
                                .append(neutrel.getHP()).append(" si este stunded din cauza abilitatii 1 a lui ")
                                .append(pokemon1.getNume()).append("\n\n");

                    } else {
                        buffer.append("b. ").append(neutrel.getNume()).append(" HP ").append(neutrel.getHP()).append("\n\n");
                    }
                }
                case 3 -> {

                    pokemon1.getAbility2().resetCooldown();
                    if (neutrel.isStun()) {
                        buffer.append(contor).append(". ").append(pokemon1.getNume())
                                .append(" abilitate 2 / ").append(neutrel.getNume())
                                .append(" nu face nimic -> Rezultat:\n");
                    } else {
                        buffer.append(contor).append(". ").append(pokemon1.getNume()).append(" abilitate 2 / ")
                                .append(neutrel.getNume()).append(" atac normal -> Rezultat:\n");
                    }
                    if (!neutrel.isStun() && !pokemon1.getAbility2().isDodge()) {

                        damage = neutrel.getNormalAttack() - pokemon1.getDef();
                        if (damage > 0) {
                            pokemon1.updateHP(damage);
                        }
                    }
                    if (neutrel.isStun()) {
                        neutrel.setStun(false);
                    }

                    pokemon1.getAbility2().run(pokemon1, neutrel);
                    if (pokemon1.getAbility2().isDodge()) {
                        buffer.append("a. ").append(pokemon1.getNume()).append(" HP (dodge) ")
                                .append(pokemon1.getHP());
                        pokemon1.setDodge(false);
                    } else {
                        buffer.append("a. ").append(pokemon1.getNume()).append(" HP ")
                                .append(pokemon1.getHP());
                    }

                    if (pokemon1.getAbility1().getCooldown() != 0) {
                        buffer.append(", abilitate 1 cooldown ").append(pokemon1.getAbility1().getCooldown());
                    }

                    buffer.append(", abilitate 2 cooldowmn ").append(pokemon1.getAbility2().getCooldown()).append("\n");

                    if (pokemon1.getAbility2().isStun()) {
                        buffer.append("b. ").append(neutrel.getNume()).append(" HP ")
                                .append(neutrel.getHP()).append(" si este stunded din cauza abilitatii 2 a lui ")
                                .append(pokemon1.getNume()).append("\n\n");
                    } else {
                        buffer.append("b. ").append(neutrel.getNume()).append(" HP ")
                                .append(neutrel.getHP()).append("\n\n");
                    }
                }
                default -> {
                    buffer.append("Batalia cu ").append(neutrel.getNume()).append(" nu merge bine\n");
                }
            }

            pokemon1.getAbility1().updateCooldown();
            pokemon1.getAbility2().updateCooldown();
            contor++;

        }

        if (neutrel.getHP() <= 0) {
            neutrel.regenerate();
        }
        if (pokemon1.getHP() > 0) {
            pokemon1.increaseStats();
            pokemon1.regenerate();
        } else {
            pokemon1.regenerate();
        }

    }
}
