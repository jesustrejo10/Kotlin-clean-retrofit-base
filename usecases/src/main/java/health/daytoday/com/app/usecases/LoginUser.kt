package health.daytoday.com.app.usecases

import health.daytoday.com.app.data.repositories.LoginRepository
import health.daytoday.com.app.data.repositories.LoginRepositoryContract
import health.daytoday.com.app.domain.User

/**
 * @author Jesus Trejo on 10/28/18.
 */
class LoginUser(
        private val presenterContractLayer:LoginPresenterContract,
        private val userName : String,
        private val userPass: String
) : LoginRepositoryContract {

    operator fun invoke() {

        val userRepository = LoginRepository(this,userName,userPass)
        return userRepository.loginCall()
    }

    override fun loginUSer(user: User) {
        presenterContractLayer.loginUser(user)
    }
}

interface LoginPresenterContract{

    fun loginUser(user : User)


}