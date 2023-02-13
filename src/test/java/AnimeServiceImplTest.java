

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import com.zemoso.springboot.demo.project.dao.AnimeRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.Genre;
import com.zemoso.springboot.demo.project.service.AnimeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;

@RunWith (MockitoJUnitRunner.class)
public class AnimeServiceImplTest {

    @Mock
    private AnimeRepository animeRepository;

    @InjectMocks
    private AnimeServiceImpl animeService2;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Given
        List<Anime> expectedAnimeList = new ArrayList<>();
        List<Genre> genre = new ArrayList<>();
        System.out.println("testFindAll");
        expectedAnimeList.add(new Anime(1, "Naruto", genre));
        expectedAnimeList.add(new Anime(2, "Death Note",genre ));
        when(animeRepository.findAllByOrderByAnimeNameAsc()).thenReturn(expectedAnimeList);

        // When
        List<Anime> actualAnimeList = animeService2.findAll();

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
        Anime actualAnime = animeService2.findById(1);

        // Then
        assertEquals(expectedAnime, actualAnime);
        verify(animeRepository).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(animeRepository.findById(anyInt())).thenReturn(Optional.empty());

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> animeService2.findById(1));
        verify(animeRepository).findById(1);
    }

    @Test
    void testSave() {
        // Given
        List<Genre> genre = new ArrayList<>();
        Anime animeToSave = new Anime(1, "Naruto", genre);

        // When
        animeService2.save(animeToSave);

        // Then
        verify(animeRepository).save(animeToSave);
    }

    @Test
    void testDeleteById() {
        // Given
        int id = 1;

        // When
        animeService2.deleteById(id);

        // Then
        verify(animeRepository).deleteById(id);
    }

    @Test
    void testDeleteAnimeById() {
        // Given
        int id = 1;

        // When
        animeService2.deleteAnimeById(id);

        // Then
        verify(animeRepository).deleteAnimeById(id);
    }
}
