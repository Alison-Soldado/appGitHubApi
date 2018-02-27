import com.example.alison.appgithubapi.data.source.remote.GithubApiService

object SearchPullRequestProvider {

    fun provideSearchPullRequest() = SearchPullRequest(GithubApiService.create())
}