package health.daytoday.com.app.usecases

import health.daytoday.com.app.data.repositories.GetUserRepositoriesRepository
import health.daytoday.com.app.data.repositories.GetUserRepositoryContract
import io.reactivex.Scheduler

/**
 * @author Jesus Trejo on 10/28/18.
 */
class GetUserRepositories(
        private val username : String,
        private val schedule : Scheduler,
        private val getUserRepositories : GetUserRepositoryContract
) {

    operator fun invoke() {

        val getUserRepository = GetUserRepositoriesRepository(getUserRepositories)
        return getUserRepository.call(username,schedule)
    }

}