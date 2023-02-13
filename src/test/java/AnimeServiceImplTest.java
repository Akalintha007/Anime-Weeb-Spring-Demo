import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.zemoso.springboot.demo.project.entity.Genre;
import com.zemoso.springboot.demo.project.service.AnimeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zemoso.springboot.demo.project.dao.AnimeRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith (MockitoJUnitRunner.class)
public class AnimeServiceImplTest {

    @Mock
    private AnimeRepository animeRepository;

    @InjectMocks
    private AnimeServiceImpl animeService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Given
        List<Anime> expectedAnimeList = new ArrayList<>();
        List<Genre> genre = new ArrayList<>();

        expectedAnimeList.add(new Anime(1, "Naruto", genre));
        expectedAnimeList.add(new Anime(2, "Death Note",genre ));
        when(animeRepository.findAllByOrderByAnimeNameAsc()).thenReturn(expectedAnimeList);

        // When
        List<Anime> actualAnimeList = animeService.findAll();

        // Then
        assertEquals(expectedAnimeList, actualAnimeList);
        verify(animeRepository).findAllByOrderByAnimeNameAsc();
    }

    @Test
    void testFindById() {
        // Given
        List<Genre> genre = new ArrayList<>();
        Anime expectedAnime = new Anime(1, "Naruto", genre);
        when(animeRepository.findById(anyInt())).thenReturn(Optional.of(expectedAnime));

        // When
        Anime actualAnime = animeService.findById(1);

        // Then
        assertEquals(expectedAnime, actualAnime);
        verify(animeRepository).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(animeRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> animeService.findById(1));
        verify(animeRepository).findById(1);
    }

    @Test
    void testSave() {
        // Given
        List<Genre> genre = new ArrayList<>();
        Anime animeToSave = new Anime(1, "Naruto", genre);

        // When
        animeService.save(animeToSave);

        // Then
        verify(animeRepository).save(animeToSave);
    }

    @Test
    void testDeleteById() {
        // Given
        int id = 1;

        // When
        animeService.deleteById(id);

        // Then
        verify(animeRepository).deleteById(id);
    }

    @Test
    void testDeleteAnimeById() {
        // Given
        int id = 1;

        // When
        animeService.deleteAnimeById(id);

        // Then
        verify(animeRepository).deleteAnimeById(id);
    }
}
