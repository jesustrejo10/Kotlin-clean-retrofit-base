package health.daytoday.com.app.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Jesus Trejo on 10/28/18.
 */
open class Github() {

    @SerializedName("id")
    @Expose
    open var id: Int= 0

    @SerializedName("avatar_url")
    @Expose
    open var avatarUrl: String? = null

    @SerializedName("name")
    @Expose
    open var name: String? = null

    @SerializedName("public_repos")
    @Expose
    open var publicRepos: Int?= null

    @SerializedName("usuario")
    @Expose
    open var usuario: Any?= null
}