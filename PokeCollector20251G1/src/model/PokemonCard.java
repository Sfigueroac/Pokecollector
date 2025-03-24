package model;

public class PokemonCard {

    private String name;
    private int healthPoints;
    private PokemonType pokemonType;
    private int attackPower;

    public PokemonCard(String name, int healthPoints, PokemonType pokemonType, int attackPower){
        this.name=name;
        this.healthPoints=healthPoints;
        this.pokemonType=pokemonType;
        this.attackPower=attackPower;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints){
        this.healthPoints=healthPoints;
    }

    public PokemonType getPokemonType(){
        return pokemonType;
    } 

    public void setPokemonType(PokemonType pokemonType){
        this.pokemonType = pokemonType;
    }
    
    public int getAttackPower(){
        return attackPower;
    }

    public void setAttackPower(int attackPower){
        this.attackPower=attackPower;
    }

    
}
