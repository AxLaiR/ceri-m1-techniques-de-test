package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {
    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Test
    void IfPokemonMetadataNullThrowsException() {
        try{
            when(pokemonMetadataProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("PokemonMetadata is null"));
            assertThrows(PokedexException.class, () -> {
                pokemonMetadataProvider.getPokemonMetadata(0);
            });
        } catch (PokedexException e) {

        }
    }
}
