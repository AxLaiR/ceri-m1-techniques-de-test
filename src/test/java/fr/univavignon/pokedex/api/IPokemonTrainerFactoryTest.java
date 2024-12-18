package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Test class for IPokemonTrainerFactory.
 */
public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        // Création des mocks
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        // Configuration des réponses simulées
        PokemonTrainer ashTrainer = new PokemonTrainer("Ash", Team.VALOR, pokedex);
        PokemonTrainer mistyTrainer = new PokemonTrainer("Misty", Team.MYSTIC, pokedex);

        // Mock de la création des Pokedex et Trainers
        when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);
        when(pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory)).thenReturn(ashTrainer);
        when(pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory)).thenReturn(mistyTrainer);
    }

    @Test
    public void testCreateTrainerAsh() {
        // Création du trainer Ash
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Vérifications
        assertNotNull(trainer, "Le trainer créé ne doit pas être null.");
        assertEquals("Ash", trainer.getName(), "Le nom du trainer doit être 'Ash'.");
        assertEquals(Team.VALOR, trainer.getTeam(), "L'équipe du trainer doit être 'VALOR'.");
        assertEquals(pokedex, trainer.getPokedex(), "Le pokedex du trainer doit être le mock configuré.");
    }

    @Test
    public void testCreateTrainerMisty() {
        // Création du trainer Misty
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Misty", Team.MYSTIC, pokedexFactory);

        // Vérifications
        assertNotNull(trainer, "Le trainer créé ne doit pas être null.");
        assertEquals("Misty", trainer.getName(), "Le nom du trainer doit être 'Misty'.");
        assertEquals(Team.MYSTIC, trainer.getTeam(), "L'équipe du trainer doit être 'MYSTIC'.");
        assertEquals(pokedex, trainer.getPokedex(), "Le pokedex du trainer doit être le mock configuré.");
    }

    @Test
    public void testCreateTrainerReturnsCorrectClass() {
        // Vérifie que la classe du trainer créé est correcte
        when(pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory))
                .thenReturn(new PokemonTrainer("Ash", Team.VALOR, pokedex));
        assertEquals(
                PokemonTrainer.class,
                pokemonTrainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory).getClass(),
                "La classe retournée doit être 'PokemonTrainer'."
        );
    }
}
