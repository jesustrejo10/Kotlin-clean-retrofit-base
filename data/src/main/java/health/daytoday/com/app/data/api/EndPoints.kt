package health.daytoday.com.app.data.api

import health.daytoday.com.app.domain.Github
import io.reactivex.Observable
import retrofit2.http.*

interface EndPoints {



    @GET("{username}")
    fun getGitHubUser(@Path("username") username : String) : Observable<Github>
}