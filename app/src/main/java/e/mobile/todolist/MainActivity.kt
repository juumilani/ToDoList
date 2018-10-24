package e.mobile.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CADASTRO: Int = 1
    }
    val listaItens: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ToDoAdapter(listaItens)
        val layoutManager = LinearLayoutManager(this)

        rvItens.adapter = adapter
        rvItens.layoutManager = layoutManager

        btnAddItem.setOnClickListener() {
            val adicionarItem = Intent(this, cadastroToDoActivity::class.java)
            startActivityForResult(adicionarItem, REQUEST_CADASTRO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CADASTRO && resultCode == Activity.RESULT_OK){
            val novoToDo: String? = data?.getStringExtra(cadastroToDoActivity.EXTRA_NOVO_TODO)
            if(novoToDo != null){
                listaItens.add(novoToDo)
            }
        }
    }
}

