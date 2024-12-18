package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;

    @BeforeEach
    public void setUp() {
        // Création des mocks pour les dépendances
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);

        // Simulation de la méthode createPokedex
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        // Appel de la méthode simulée
        IPokedex createdPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Vérifications
        assertNotNull(createdPokedex, "La méthode createPokedex doit retourner une instance non nulle d'IPokedex.");
    }
}
