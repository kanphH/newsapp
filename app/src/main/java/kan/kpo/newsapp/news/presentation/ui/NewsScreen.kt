package kan.kpo.newsapp.news.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kan.kpo.newsapp.news.presentation.NewState
import kan.kpo.newsapp.news.presentation.NewsAction
import kan.kpo.newsapp.news.presentation.NewsViewModel
import kan.kpo.newsapp.news.presentation.theme.NewsAppTheme
import org.koin.androidx.compose.koinViewModel


@Composable
fun NewsScreenCore(
    viewModel: NewsViewModel = koinViewModel(),
    onArticleClick: (String) -> Unit,
) {
    NewsScreen(
        state = viewModel.state,
        onAction = viewModel::onAction,
        onArticleClick = onArticleClick
    )
}

@Composable
private fun NewsScreen(
    modifier: Modifier = Modifier,
    state: NewState,
    onAction: (NewsAction) -> Unit,
    onArticleClick: (String) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        
    }

}

@Preview
@Composable
private fun NeewScrenPrev() {
    NewsAppTheme {
        NewsScreenCore(onArticleClick = {})

    }

}