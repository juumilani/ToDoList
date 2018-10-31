package e.mobile.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_to_do.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class cadastroToDoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOVO_TODO: String = "novoToDo"
    }

    var todo: ToDoObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_to_do)

        todo = intent.getSerializableExtra(EXTRA_NOVO_TODO) as ToDoObject?
        if(todo != null){
            carregaDados()
        }

        btnSave.setOnClickListener() {
            salvaToDo()
        }

    }

    private fun carregaDados() {
        edtToDo.setText(todo?.text)
    }

    private fun salvaToDo() {
        if(edtToDo.text.isEmpty()){
            edtToDo.requestFocus()
            edtToDo.setError(getString(R.string.vazio))
            return
        }

        if(todo == null){
            todo = ToDoObject(edtToDo.text.toString())
        }else{
            todo?.text = edtToDo.text.toString()
        }

        val todoDao: ToDoDao = AppDatabase.getInstance(this).ToDoDao()
        doAsync {
            todoDao.insert(todo!!)
            uiThread {
                finish()
            }
        }
    }
}
