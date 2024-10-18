package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {
    @Mock
    IPokemonFactory pokemonFactory;

    @Test
    void testCreatePokemon() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 500)).thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 500, 613, 64, 4000, 500));
        assertEquals(Pokemon.class, pokemonFactory.createPokemon(0, 613, 64, 4000, 500).getClass());
    }    
}
