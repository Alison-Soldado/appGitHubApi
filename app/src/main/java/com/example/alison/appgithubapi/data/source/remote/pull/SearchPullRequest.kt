import com.example.alison.appgithubapi.data.source.remote.GithubApiService

class SearchPullRequest(private val apiService: GithubApiService) {

    fun searchPullRequest(login: String, name: String) = apiService.getPullRequest(login, name)
}