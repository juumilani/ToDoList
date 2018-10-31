package e.mobile.todolist

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class ToDoObject (var text: String,
                       @PrimaryKey(autoGenerate = true)
                 var ToDoID: Int = 0): Serializable