package e.mobile.todolist

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class ToDo (var text: String,
                 @PrimaryKey(autoGenerate = true)
                 var ToDoID: Int = 0)