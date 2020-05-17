package aut.bme.jokes.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import aut.bme.jokes.TestApplication;
import aut.bme.jokes.ui.list.ListActivity;
import aut.bme.jokes.ui.list.ListPresenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(application = TestApplication.class)
public class ListPresenterTest {
    @Inject
    ListPresenter presenter;

    @Mock
    ListActivity mockActivity;

    @Before
    public void setup(){
        mockActivity = Mockito.mock(ListActivity.class);
        TestApplication.injector.inject(mockActivity);

        presenter = mockActivity.presenter;
        presenter.attachScreen(mockActivity);
    }

    @Test
    public void testGetAll(){
        try {
            presenter.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        verify(mockActivity, times(1) ).showActivities(any());
    }
}
