package fr.univavignon.pokedex.api;

import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private List<Pokemon> pokemonList;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokedex = Mockito.mock(IPokedex.class);
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(134, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
        pokemonList = new ArrayList<>();
        pokemonList.add(bulbizarre);
        pokemonList.add(aquali);

        Mockito.when(pokedex.size()).thenReturn(pokemonList.size());
        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Mockito.when(pokedex.getPokemon(134)).thenReturn(aquali);
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);
        Mockito.when(pokedex.getPokemons(Mockito.any(Comparator.class))).thenAnswer(invocation -> {
            pokemonList.sort(invocation.getArgument(0));
            return pokemonList;
        });
        Mockito.when(pokedex.getPokemon(999)).thenThrow(new PokedexException("Invalid ID"));
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon retrievedPokemon = pokedex.getPokemon(0);
        assertNotNull(retrievedPokemon);
        assertEquals("Bulbizarre", retrievedPokemon.getName());
        assertEquals(613, retrievedPokemon.getCp());
    }

    @Test
    public void testGetPokemonInvalidId() {
        Exception exception = assertThrows(PokedexException.class, () -> pokedex.getPokemon(999));
        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> sortedPokemons = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp));
        assertEquals("Bulbizarre", sortedPokemons.get(0).getName());
        assertEquals("Aquali", sortedPokemons.get(1).getName());
    }
}
