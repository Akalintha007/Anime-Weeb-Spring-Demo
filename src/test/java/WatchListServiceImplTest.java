import com.zemoso.springboot.demo.project.dao.WatchListRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.Genre;
import com.zemoso.springboot.demo.project.service.WatchListServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith (MockitoJUnitRunner.class)
public class WatchListServiceImplTest {

    @Mock
    private WatchListRepository watchListRepository;

    @InjectMocks
    private WatchListServiceImpl watchlistservice2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWatchListByUser() {
        // Given
        String userName = "testUser";
        List<Genre> genre = new ArrayList<>();
        List<Anime> animeList = new ArrayList<>();
        animeList.add(new Anime(1, "Naruto", genre));

        when(watchListRepository.getWatchListByUser(userName)).thenReturn(animeList);

        // When
        List<Anime> result = watchlistservice2.getWatchListByUser(userName);

        // Then
        verify(watchListRepository, times(1)).getWatchListByUser(userName);
        assertEquals(animeList, result);
    }

    @Test
    public void testRemoveFromWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        // When
        watchlistservice2.removeFromWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).removeFromWatchList(userName, animeId);
    }

    @Test
    public void testAddToWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        // When
        watchlistservice2.addToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).addToWatchList(userName, animeId);
    }

    @Test
    public void testDeleteFromWatchList() {
        // Given
        int animeId = 1;

        // When
        watchlistservice2.deleteFromWatchList(animeId);

        // Then
        verify(watchListRepository, times(1)).deleteFromWatchList(animeId);
    }

    @Test
    public void testCheckBeforeAddToWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        when(watchListRepository.checkBeforeAddToWatchList(userName, animeId)).thenReturn(0);

        // When
        int result = watchlistservice2.checkBeforeAddToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).checkBeforeAddToWatchList(userName, animeId);
        assertEquals(0, result);
    }
}
