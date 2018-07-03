package com.example.brakai.nextepisode.database.dao

import androidx.room.*
import com.example.brakai.nextepisode.database.model.TVshow
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface TVshowDao {

    @Query("SELECT count(*) FROM tv_shows")
    fun getCount(): Single<Int>

    @Update
    fun updateMultiple(quotes: List<TVshow>)

    @Query("SELECT * FROM tv_shows")
    fun getAll(): Flowable<List<TVshow>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tvshow: TVshow)

    @Delete
    fun delete(tvshow: TVshow)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tvshow: List<TVshow>)

    @Query("DELETE FROM tv_shows")
    fun deleteAll(): Int

}