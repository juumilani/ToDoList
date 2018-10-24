package e.mobile.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_to_do.*

class cadastroToDoActivity : AppCompatActivity() {

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
        //TODO: Implement save code
    }


}
