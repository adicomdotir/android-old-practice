package ir.adicom.androidoldpractice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import ir.adicom.androidoldpractice.models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = REPLACE)
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Update(onConflict = REPLACE)
    fun update(note: Note)
}