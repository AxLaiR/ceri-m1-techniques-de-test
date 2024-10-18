package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPokemonMetadata'");
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPokemon'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPokemon'");
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPokemon'");
    }

    @Override
    public List<Pokemon> getPokemons() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPokemons'");
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPokemons'");
    }   
}
