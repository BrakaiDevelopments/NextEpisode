package com.example.brakai.nextepisode.rest

import android.arch.lifecycle.Lifecycle
import android.support.v4.app.Fragment
import com.example.brakai.nextepisode.database.model.Episode
import com.example.brakai.nextepisode.database.model.TVshow
import com.example.brakai.nextepisode.rest.model.Response
import com.example.brakai.nextepisode.rest.model.Status
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClient private constructor() {

    private object Holder {
        val INSTANCE = RestClient()
    }

    companion object {
        private const val TIMEOUT_SECONDS = 15
        private val ApiURL = "http://"
        val shared: RestClient by lazy { Holder.INSTANCE }
    }

    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
                .build()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiURL)
                .build()
    }

    private fun getApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    private fun <T> executeAsyncCall(context: Any, service: Single<T>, closure: ((Response<T>) -> Unit)?) {
        service.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableSingleObserver<T>() {

                    override fun onSuccess(value: T) {
                        if (context is Fragment && !context.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                            return
                        }
                        closure?.invoke(Response(Status.SUCCESS, item = value))
                    }

                    override fun onError(e: Throwable) {
                        if (context is Fragment && !context.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                            return
                        }
                        closure?.invoke(Response(Status.FAILED, e))
                    }
                })
    }

    fun searchShows(context: Any, params: String, closure: ((Response<Flowable<TVshow>>) -> Unit)?) {
        val service = getApiService(getRetrofit()).search(params)
        executeAsyncCall(context, service, closure)
    }

    fun getEpisode(context: Any, id: Int, closure: ((Response<Episode>) -> Unit)?) {
        val service = getApiService(getRetrofit()).getEpisode(id)
        executeAsyncCall(context, service, closure)
    }

}