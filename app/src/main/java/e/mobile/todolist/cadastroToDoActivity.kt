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
        val salvaToDo = Intent(this, MainActivity::class.java)
        salvaToDo.putExtra(EXTRA_NOVO_TODO, edtToDo.text)
        setResult(Activity.RESULT_OK, salvaToDo)
        finish()
    }


}
