package health.daytoday.com.app.data.api

import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroBase {


    var disposable: Disposable? = null

    companion object {
        fun create(): EndPoints {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(URL.URL_GITHUB)
                    .build()

            return retrofit.create(EndPoints::class.java)
        }
    }
}