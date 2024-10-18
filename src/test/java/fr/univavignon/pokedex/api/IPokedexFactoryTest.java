package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokedexFactoryTest {
    @Mock
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;

    @Test
    void testCreatePokedex() {
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(new Pokedex());
        assertEquals(Pokedex.class, pokedexFactory.createPokedex(metadataProvider, pokemonFactory).getClass());
    }
}
