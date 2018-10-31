package health.daytoday.com.app.data.repositories

import health.daytoday.com.app.domain.User

class LoginRepository(
        val loginRepositoryContract : LoginRepositoryContract,
        val email : String,
        val password : String
) {

    fun loginCall(){

    }
}

interface LoginRepositoryContract {

    fun loginUSer(user:User)
}