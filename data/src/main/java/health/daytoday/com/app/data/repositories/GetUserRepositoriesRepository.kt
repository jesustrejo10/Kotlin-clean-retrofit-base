package health.daytoday.com.app.data.repositories

import health.daytoday.com.app.data.api.RetroBase
import health.daytoday.com.app.domain.Github
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * @author Jesus Trejo on 10/28/18.
 */
class GetUserRepositoriesRepository(
        private val getUserRepositories :GetUserRepositoryContract
) {

    fun call(username : String, schedulers: Scheduler){

        RetroBase.create().getGitHubUser(username)
                .subscribeOn(Schedulers.computation())
                .observeOn(schedulers)
                .subscribe(
                        { result -> getUserRepositories.manageGithubResult(result) },
                        { error -> getUserRepositories.manageError(error.message) }
                )
    }


}

interface GetUserRepositoryContract{

    fun manageGithubResult(result : Github)

    fun manageError(message : String?)

}