public class ObiectSpecialFactory {

    public ObiectSpecial createObiectSpecial(String nume){

        switch(nume){
            case "Scut":
                return new Scut();
            case "Vesta":
                return new Vesta();
            case "Sabiuta":
                return new Sabiuta();
            case "Bagheta Magica":
                return new BaghetaMagica();
            case "Vitamine":
                return new Vitamine();
            case "Brad de Craciun":
                return new BradDeCraciun();
            case "Pelerina":
                return new Pelerina();
            default:
                System.out.println("Obiectul special: " + nume + " nu exista!");
                return null;
        }
    }
}
