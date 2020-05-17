package aut.bme.jokes.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;

import javax.inject.Inject;

import aut.bme.jokes.TestApplication;
import aut.bme.jokes.model.Joke;
import aut.bme.jokes.model.JokeModel;
import aut.bme.jokes.ui.details.DetailsActivity;
import aut.bme.jokes.ui.details.DetailsPresenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class DetailsPresenterTest {

    @Inject
    DetailsPresenter presenter;

    @Mock
    DetailsActivity mockActivity;

    @Before
    public void setup(){
        mockActivity = Mockito.mock(DetailsActivity.class);
        TestApplication.injector.inject(mockActivity);

        presenter = mockActivity.presenter;
        presenter.attachScreen(mockActivity);
    }

    @Test
    public void networkTest(){
        try {
            //Act
            presenter.getJoke();

            // Assert
            ArgumentCaptor<JokeModel> argument = ArgumentCaptor.forClass(JokeModel.class);
            verify(mockActivity, times(1) ).showJokeActivity(argument.capture());

            JokeModel argumentValue = argument.getValue();
            Assert.assertEquals("Test Setup", argumentValue.getSetup());
            Assert.assertEquals("Test Punchline", argumentValue.getPunchline());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
