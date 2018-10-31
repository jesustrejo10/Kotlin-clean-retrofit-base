package com.app.health.daytoday_android.framework

import health.daytoday.com.app.data.api.UserGeneratorContract
import health.daytoday.com.app.domain.User

/**
 * Imagine that we get the user
 */
class UserGenerator : UserGeneratorContract
{
    override fun generateUser(): User {
        return User("Jesus",1)
    }


}