package health.daytoday.com.app.usecases

import health.daytoday.com.app.data.api.UserGeneratorContract
import health.daytoday.com.app.data.api.UserRepository
import health.daytoday.com.app.domain.User

class GetUserFromDb(
        private val userGeneratorFramework:UserGeneratorContract
) {

    operator fun invoke(): User {

        val userRepository = UserRepository(userGeneratorFramework)
        return userRepository.generateUser()
    }

}