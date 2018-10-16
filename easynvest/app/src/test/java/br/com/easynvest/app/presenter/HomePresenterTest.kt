package br.com.easynvest.app.presenter

import br.com.easynvest.app.contract.HomeContract
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
open class HomePresenterTest {

    @InjectMocks
    lateinit var homePresenter: HomePresenter

    @Mock
    lateinit var homeView: HomeContract.HomeView

    @Before
    fun setUp() {
        homePresenter.view = homeView
    }

    @Test
    fun getSimulate() {
        Assert.assertNotNull(homePresenter.view)
        Assert.assertThat(homePresenter, IsInstanceOf.instanceOf(HomeContract.HomePresenter::class.java))
        Assert.assertThat(homePresenter, IsInstanceOf.instanceOf(Presenter<HomeContract.HomeView>()::class.java))
    }
}