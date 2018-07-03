package com.example.brakai.nextepisode.database.dao

import androidx.room.*
import com.example.brakai.nextepisode.database.model.User
import io.reactivex.Single

@Dao
interface UserDao {

    @Query("SELECT count(*) FROM users")
    fun getCount(): Single<Int>

    @Update
    fun updateMultiple(quotes: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("DELETE FROM users")
    fun deleteAll(): Int
}