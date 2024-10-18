package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokedexTest {
    Pokemon pokemon = new Pokemon(0, "Bulbizarre", 613, 64, 4000, 500, 613, 64, 4000, 500);
    @Mock
    IPokedex pokedex;

    @Test
    void testSize() {
        when(pokedex.size()).thenReturn(1);
        assertEquals(1, pokedex.size());
    }

    @Test
    void testAddPokemon() {
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        assertEquals(0, pokedex.addPokemon(pokemon));
    }

    @Test
    void testGetPokemon() {
        try {
            when(pokedex.getPokemon(0)).thenReturn(pokemon);
            assertEquals(pokemon, pokedex.getPokemon(0));
        } catch (PokedexException e) {
        }
    }

    @Test
    void testGetPokemonsThrowsException() {
        try {
            when(pokedex.getPokemon(1)).thenThrow(new PokedexException("Pokemon not found"));
            pokedex.getPokemon(1);
        } catch (PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
        }
    }

    @Test
    void testListGetPokemons() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(pokemon);
        when(pokedex.getPokemons()).thenReturn(pokemons);
        assertEquals(pokemons, pokedex.getPokemons());
    }

    @Test
    void testSortedPokemonsList() {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(pokemon);
        when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemons);
        assertEquals(pokemons, pokedex.getPokemons(PokemonComparators.NAME));
    }
    
}
