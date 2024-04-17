package org.compose_projects.socialocal.profile.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.compose_projects.socialocal.core.utils.DB_CONSTANTS.tableAccount_name
import org.compose_projects.socialocal.profile.domain.models.AccountEntity

@Dao
interface AccountDBDao {
    @Query("SELECT * FROM $tableAccount_name")
    fun getUser(): Flow<List<AccountEntity>>

    @Query("SELECT * FROM $tableAccount_name WHERE id = :id")
    fun getUser(id: Int): Flow<AccountEntity>

    @Insert
    suspend fun addUser(user: AccountEntity)

    @Update
    suspend fun updateUser(user: AccountEntity)

    @Delete
    suspend fun deleteUser(user: AccountEntity)

}