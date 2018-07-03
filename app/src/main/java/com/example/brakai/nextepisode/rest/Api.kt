package com.example.brakai.nextepisode.rest

import com.example.brakai.nextepisode.database.model.Episode
import com.example.brakai.nextepisode.database.model.TVshow
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.*


interface Api {

    @FormUrlEncoded
    @POST("api.tvmaze.com/search/shows")
    fun search(@Query("q") name: String):  Single<Flowable<TVshow>>

    @GET("api.tvmaze.com/episodes/{id}")
    @Headers("Content-Type: application/json")
    fun getEpisode(@Path("id") id: Int): Single<Episode>

}