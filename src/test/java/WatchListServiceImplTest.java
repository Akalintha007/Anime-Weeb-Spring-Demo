import com.zemoso.springboot.demo.project.dao.WatchListRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.Genre;
import com.zemoso.springboot.demo.project.service.WatchListServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WatchListServiceImplTest {

    @Mock
    private WatchListRepository watchListRepository;

    @InjectMocks
    private WatchListServiceImpl watchListService;

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
        List<Anime> result = watchListService.getWatchListByUser(userName);

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
        watchListService.removeFromWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).removeFromWatchList(userName, animeId);
    }

    @Test
    public void testAddToWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        // When
        watchListService.addToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).addToWatchList(userName, animeId);
    }

    @Test
    public void testDeleteFromWatchList() {
        // Given
        int animeId = 1;

        // When
        watchListService.deleteFromWatchList(animeId);

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
        int result = watchListService.checkBeforeAddToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).checkBeforeAddToWatchList(userName, animeId);
        assertEquals(0, result);
    }
}
