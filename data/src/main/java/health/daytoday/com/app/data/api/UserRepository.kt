package health.daytoday.com.app.data.api

import health.daytoday.com.app.domain.User

/**
 * Each repository should has it own interface (contract) to communicate with other layers. (layers bellow it)
 * It talk directly with the Domain Layer.
 */
class UserRepository(private val userGeneratorContract: UserGeneratorContract){

    fun generateUser(): User{
        return userGeneratorContract.generateUser()
    }

}

interface UserGeneratorContract{

    fun generateUser() : User

}
