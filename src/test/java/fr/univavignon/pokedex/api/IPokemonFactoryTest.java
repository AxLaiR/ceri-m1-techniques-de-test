package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        // Création du mock pour IPokemonFactory
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        // Configuration des réponses simulées
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(134, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
        Mockito.when(pokemonFactory.createPokemon(134, 2729, 202, 5000, 4)).thenReturn(aquali);
    }

    @Test
    public void testCreatePokemonBulbizarre() {
        // Création d'un Pokémon via la factory simulée
        Pokemon createdPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Vérifications
        assertNotNull(createdPokemon, "Le Pokémon créé ne doit pas être nul.");
        assertEquals(0, createdPokemon.getIndex());
        assertEquals("Bulbizarre", createdPokemon.getName());
        assertEquals(126, createdPokemon.getAttack());
        assertEquals(126, createdPokemon.getDefense());
        assertEquals(90, createdPokemon.getStamina());
        assertEquals(613, createdPokemon.getCp());
        assertEquals(64, createdPokemon.getHp());
        assertEquals(4000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
        assertEquals(56.0, createdPokemon.getIv(), 0.001);
    }

    @Test
    public void testCreatePokemonAquali() {
        // Création d'un autre Pokémon via la factory simulée
        Pokemon createdPokemon = pokemonFactory.createPokemon(134, 2729, 202, 5000, 4);

        // Vérifications
        assertNotNull(createdPokemon, "Le Pokémon créé ne doit pas être nul.");
        assertEquals(134, createdPokemon.getIndex());
        assertEquals("Aquali", createdPokemon.getName());
        assertEquals(186, createdPokemon.getAttack());
        assertEquals(168, createdPokemon.getDefense());
        assertEquals(260, createdPokemon.getStamina());
        assertEquals(2729, createdPokemon.getCp());
        assertEquals(202, createdPokemon.getHp());
        assertEquals(5000, createdPokemon.getDust());
        assertEquals(4, createdPokemon.getCandy());
        assertEquals(100.0, createdPokemon.getIv(), 0.001);
    }
}
