package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonTrainerFactoryTest {
    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;

    @Test
    void testCreateTrainer() {
        when(pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory)).thenReturn(new PokemonTrainer("Sacha", Team.VALOR, pokedex));
        assertEquals(PokemonTrainer.class, pokemonTrainerFactory.createTrainer("Sacha", Team.VALOR, pokedexFactory).getClass());
    }
}
