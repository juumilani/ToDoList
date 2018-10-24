package e.mobile.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_to_do.*

class cadastroToDoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOVO_TODO: String = "novoToDo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_to_do)

        val toDoString: String? = intent.getStringExtra(EXTRA_NOVO_TODO) as String?
        if(toDoString != null){
            edtToDo.setText(toDoString)
        }

        btnSave.setOnClickListener() {
            salvaToDo()
        }
    }

    private fun salvaToDo() {
        if(edtToDo.text.isEmpty()){
            edtToDo.requestFocus()
            edtToDo.setError(getString(R.string.vazio))
            return
        }

        val stringToDo = edtToDo.text.toString()

        val salvaToDo = Intent(this, MainActivity::class.java)
        salvaToDo.putExtra(EXTRA_NOVO_TODO, stringToDo)
        setResult(Activity.RESULT_OK, salvaToDo)
        finish()
    }


}
