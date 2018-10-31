package e.mobile.todolist

import android.arch.persistence.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: ToDo)

    @Query("SELECT * FROM Todo")
    fun getAll(): List<ToDo>

    @Delete
    fun delete(todo: ToDo)

    @Query("SELECT * FROM Todo WHERE ToDoID = :ToDoID LIMIT 1")
    fun getToDo(ToDoID: Int): ToDo
}