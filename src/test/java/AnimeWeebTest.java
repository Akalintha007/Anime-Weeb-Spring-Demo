import com.zemoso.springboot.demo.project.constants.AppConstants;
import com.zemoso.springboot.demo.project.controller.AnimeController;
import com.zemoso.springboot.demo.project.controller.ErrorAndExceptionController;
import com.zemoso.springboot.demo.project.controller.LoginController;
import com.zemoso.springboot.demo.project.dao.WatchListRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.Genre;
import com.zemoso.springboot.demo.project.service.AnimeService;
import com.zemoso.springboot.demo.project.service.WatchListService;
import com.zemoso.springboot.demo.project.service.WatchListServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AnimeWeebTest {

    @Mock
    private AnimeService animeService;

    @Mock
    private WatchListService watchListService;

    @InjectMocks
    private AnimeController animeController;

    @Test
    public void testListAnime() {
        List<Anime> animeList = new ArrayList<>();
        animeList.add(new Anime());

        Mockito.when(animeService.findAll()).thenReturn(animeList);

        Model model = new ExtendedModelMap();
        String viewName = animeController.listAnime(model);

        assertEquals("anime/list-anime", viewName);
        assertEquals(animeList, model.asMap().get("anime"));
    }

    @Test
    public void testUserView() {
        List<Anime> animeList = new ArrayList<>();
        animeList.add(new Anime());

        Mockito.when(animeService.findAll()).thenReturn(animeList);

        Model model = new ExtendedModelMap();
        String viewName = animeController.userView(model);

        assertEquals("anime/list-anime-user-view", viewName);
        assertEquals(animeList, model.asMap().get("anime"));
    }

    @Test
    public void testShowFormForAdd() {
        Model model = new ExtendedModelMap();
        String viewName = animeController.showFormForAdd(model);

        assertEquals("anime/anime-form", viewName);
        assertNotNull(model.asMap().get("anime1"));
    }

    @Test
    public void testShowFormForUpdate() {
        int animeId = 1;
        Anime anime = new Anime();
        Mockito.when(animeService.findById(animeId)).thenReturn(anime);

        Model model = new ExtendedModelMap();
        String viewName = animeController.showFormForUpdate(animeId, model);

        assertEquals("anime/anime-form-update", viewName);
        assertEquals(anime, model.asMap().get("anime1"));
    }

    @Test
    public void testAnimeGenre() {
        int animeId = 1;
        Anime anime = new Anime();
        Mockito.when(animeService.findById(animeId)).thenReturn(anime);

        Model model = new ExtendedModelMap();
        String viewName = animeController.animeGenre(animeId, model);

        assertEquals("anime/anime-genre", viewName);
        assertEquals(anime, model.asMap().get("animeg"));
    }

    @Test
    public void testAnimeGenreUser() {
        int animeId = 1;
        Anime anime = new Anime();
        Mockito.when(animeService.findById(animeId)).thenReturn(anime);

        Model model = new ExtendedModelMap();
        String viewName = animeController.animeGenreUser(animeId, model);

        assertEquals("anime/anime-genre-user-view", viewName);
        assertEquals(anime, model.asMap().get("animeg"));
    }

    @Test
    public void testSaveAnimeADD() {
        Anime anime = new Anime();

        BindingResult bindingResult = mock(BindingResult.class);
        Mockito.when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = animeController.saveAnimeADD(anime, bindingResult);

        assertEquals(AppConstants.RedirectPathAnimePage, viewName);
        verify(animeService).save(anime);
    }

    @Test
    public void testSaveAnimeUPDATE() {
        Anime anime = new Anime();

        BindingResult bindingResult = mock(BindingResult.class);
        Mockito.when(bindingResult.hasErrors()).thenReturn(false);

        String viewName = animeController.saveAnimeUPDATE(anime, bindingResult);

        assertEquals(AppConstants.RedirectPathAnimePage, viewName);
    }

    @Test
    public void testDelete() {
        int animeId = 1;
        int watchListId = 2;
        doNothing().when(watchListService).deleteFromWatchList(watchListId);
        doNothing().when(animeService).deleteAnimeById(animeId);

        String result = animeController.delete(animeId, watchListId);

        verify(watchListService).deleteFromWatchList(watchListId);
        verify(animeService).deleteAnimeById(animeId);
        assertEquals(AppConstants.RedirectPathAnimePage, result);
    }

    @Test
    public void testHandleException() {
        Exception exception = new Exception("Test Exception");
        Model model = mock(Model.class);
        ErrorAndExceptionController controller = new ErrorAndExceptionController();
        String result = controller.handleException(exception, model);
        assertEquals("error/custom-error", result);
        verify(model).addAttribute("message", "Test Exception");
    }

    @Test
    public void testHandleError() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        ErrorAndExceptionController controller = new ErrorAndExceptionController();

        // Test when status is not set
        when(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(null);
        String result = controller.handleError(request);
        assertEquals("error", result);

        // Test when status is set to HttpStatus.NOT_FOUND
        when(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(HttpStatus.NOT_FOUND.value());
        result = controller.handleError(request);
        assertEquals("error/404", result);

        // Test when status is set to HttpStatus.INTERNAL_SERVER_ERROR
        when(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result = controller.handleError(request);
        assertEquals("error/500", result);

        // Test when status is set to HttpStatus.FORBIDDEN
        when(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)).thenReturn(HttpStatus.FORBIDDEN.value());
        result = controller.handleError(request);
        assertEquals("error/403", result);
    }

    @Test
    public void testShowMyLoginPage() {
        LoginController controller = new LoginController();
        String result = controller.showMyLoginPage();
        assertEquals("anime/login", result);
    }

    @Test
    public void testShowAccessDenied() {
        LoginController controller = new LoginController();
        String result = controller.showAccessDenied();
        assertEquals("anime/access-denied", result);
    }




    @Mock
    private WatchListRepository watchListRepository;

    @InjectMocks
    private WatchListServiceImpl watchListService2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @org.junit.jupiter.api.Test
    public void testGetWatchListByUser() {
        // Given
        String userName = "testUser";
        List<Genre> genre = new ArrayList<>();
        List<Anime> animeList = new ArrayList<>();
        animeList.add(new Anime(1, "Naruto", genre));

        when(watchListRepository.getWatchListByUser(userName)).thenReturn(animeList);

        // When
        List<Anime> result = watchListService2.getWatchListByUser(userName);

        // Then
        verify(watchListRepository, times(1)).getWatchListByUser(userName);
        Assertions.assertEquals(animeList, result);
    }

    @org.junit.jupiter.api.Test
    public void testRemoveFromWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        // When
        watchListService2.removeFromWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).removeFromWatchList(userName, animeId);
    }

    @org.junit.jupiter.api.Test
    public void testAddToWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        // When
        watchListService2.addToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).addToWatchList(userName, animeId);
    }

    @org.junit.jupiter.api.Test
    public void testDeleteFromWatchList() {
        // Given
        int animeId = 1;

        // When
        watchListService2.deleteFromWatchList(animeId);

        // Then
        verify(watchListRepository, times(1)).deleteFromWatchList(animeId);
    }

    @org.junit.jupiter.api.Test
    public void testCheckBeforeAddToWatchList() {
        // Given
        String userName = "testUser";
        int animeId = 1;

        when(watchListRepository.checkBeforeAddToWatchList(userName, animeId)).thenReturn(0);

        // When
        int result = watchListService2.checkBeforeAddToWatchList(userName, animeId);

        // Then
        verify(watchListRepository, times(1)).checkBeforeAddToWatchList(userName, animeId);
        Assertions.assertEquals(0, result);
    }
}
