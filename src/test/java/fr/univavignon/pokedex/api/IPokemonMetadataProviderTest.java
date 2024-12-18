package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() throws PokedexException {
        // Création du mock pour IPokemonMetadataProvider
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        // Configuration des réponses simulées
        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aqualiMetadata = new PokemonMetadata(134, "Aquali", 186, 168, 260);

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(metadataProvider.getPokemonMetadata(134)).thenReturn(aqualiMetadata);
        when(metadataProvider.getPokemonMetadata(999)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    public void testGetPokemonMetadataBulbizarre() throws PokedexException {
        // Récupération des métadonnées pour Bulbizarre
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);

        // Vérifications
        assertNotNull(metadata, "Les métadonnées de Bulbizarre ne doivent pas être nulles.");
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataAquali() throws PokedexException {
        // Récupération des métadonnées pour Aquali
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(134);

        // Vérifications
        assertNotNull(metadata, "Les métadonnées d'Aquali ne doivent pas être nulles.");
        assertEquals(134, metadata.getIndex());
        assertEquals("Aquali", metadata.getName());
        assertEquals(186, metadata.getAttack());
        assertEquals(168, metadata.getDefense());
        assertEquals(260, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataInvalidIndexThrowsException() {
        // Vérification qu'une exception est levée pour un index invalide
        Exception exception = assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(999);
        });

        // Vérification du message de l'exception
        assertEquals("Invalid index", exception.getMessage());
    }

    @Test
    public void testNullPokemonMetadataThrowsException() {
        // Simulation d'une exception pour une requête retournant des métadonnées nulles
        try {
            when(metadataProvider.getPokemonMetadata(0)).thenThrow(new PokedexException("PokemonMetadata is null"));
        } catch (PokedexException e) {

        }

        // Vérification qu'une exception est levée
        Exception exception = assertThrows(PokedexException.class, () -> {
            metadataProvider.getPokemonMetadata(0);
        });

        // Vérification du message de l'exception
        assertEquals("PokemonMetadata is null", exception.getMessage());
    }
}
