package model;

public class Controller {

    private PokemonCard[] collection;

    public Controller() {
        collection = new PokemonCard[200];
        testData();
    }

    public void testData() {

        savePokemonCard("Leafeon", 80, 3, 40);
        savePokemonCard("Jolteon", 80, 4, 100);
    }

    public PokemonType calculatePokemonType(int option) {
        PokemonType temp = PokemonType.AGUA;
        switch (option) {
            case 1:
                temp = PokemonType.AGUA;
                break;
            case 2:
                temp = PokemonType.FUEGO;
                break;
            case 3:
                temp = PokemonType.PLANTA;
                break;
            case 4:
                temp = PokemonType.ELECTRICO;
                break;

            default:
                temp = PokemonType.AGUA;
                break;
        }
        return temp;
    }

    /**
     * Descripcion: ... pre: El arreglo collection debe estar inicializado pos:
     * PokemonCard queda añadido al arreglo collection
     *
     * @param name String El nombre de la carta a registrar
     * @param healthPoints int ...
     * @param pokemonType String ...
     * @param attackPower int ...
     * @return boolean true si se añade, false si no
     */
    public boolean savePokemonCard(String name, int healthPoints, int pokemonType, int attackPower) {

        PokemonType temp = calculatePokemonType(pokemonType);
        PokemonCard newCard = new PokemonCard(name, healthPoints, temp, attackPower);

        for (int i = 0; i < collection.length; i++) {

            if (collection[i] == null) {
                collection[i] = newCard;
                return true;
            }

        }

        return false;
    }

    /**
     * Descripcion: pre: El arreglo collection debe estar inicializado
     *
     * @return String la lista de cartas registradas
     */
    public String getCollection() {
        String list = "";

        for (int i = 0; i < collection.length; i++) {
            if (collection[i] != null) {
                list += (i + 1) + "|" + collection[i].getName(); //collection[i] es un objeto PokemonCard
            }
        }
        return list;
    }

    public String getPokemonTypeList() {
        String msg = "Los tipos de Pokemon son";

        PokemonType[] types = PokemonType.values();

        for (int i = 0; i < types.length; i++) {
            msg += (i + 1) + ". " + types[i];

        }

        return msg;
    }

    public boolean verifyCard(int position) {
        if (collection[position] != null) {
            return true;
        }
        return false;
    }

    public boolean deleteCard(int position) {
        if (collection[position] == null) {
            return false;
        } else {
            collection[position] = null;
            return true;
        }
    }

    public void modifyCard(String name, int healthpoints, int pokemonType, int attackPower, int position) {
        PokemonType temp = calculatePokemonType(pokemonType);
        PokemonCard newCard = new PokemonCard(name, healthpoints, temp, attackPower);
        collection[position - 1] = newCard;

    }

    public boolean modifyFieldPokemonCard(int position, int option, String data) {
        int dataInteger = 0;
        if (option != 1) {
            dataInteger = Integer.parseInt(data);
        }

        switch (option) {
            case 1:
                collection[position - 1].setName(data);
                return true;
            case 2:
                collection[position - 1].setPokemonType(calculatePokemonType(dataInteger));
                return true;
            case 3:
                collection[position - 1].setHealthPoints(dataInteger);
                return true;
            case 4:
                collection[position - 1].setAttackPower(dataInteger);
                return true;

        }

        return false;
    }
}
