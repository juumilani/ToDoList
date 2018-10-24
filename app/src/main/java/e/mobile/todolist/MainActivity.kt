package e.mobile.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_lista.*

class MainActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CADASTRO: Int = 1
    }
    var listaItens: MutableList<String> = mutableListOf()
    var indexToDo: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddItem.setOnClickListener() {
            val adicionarItem = Intent(this, cadastroToDoActivity::class.java)
            startActivityForResult(adicionarItem, REQUEST_CADASTRO)
        }
    }

    override fun onResume(){
        super.onResume()
        carregaLista()
    }

    fun carregaLista() {
        val adapter = ToDoAdapter(this, listaItens)

        adapter.setOnItemClickListener{toDo, indexToDo ->
            this.indexToDo = indexToDo
            val editaToDo = Intent(this, cadastroToDoActivity::class.java)
            editaToDo.putExtra(cadastroToDoActivity.EXTRA_NOVO_TODO, toDo)
            this.startActivityForResult(editaToDo, REQUEST_CADASTRO)
        }

        val layoutManager = LinearLayoutManager(this)

        rvItens.adapter = adapter
        rvItens.layoutManager = layoutManager
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CADASTRO && resultCode == Activity.RESULT_OK){
            val toDo: String? = data?.getStringExtra(cadastroToDoActivity.EXTRA_NOVO_TODO)
            if(toDo != null){
                if(indexToDo >= 0){
                listaItens.set(indexToDo, toDo)
                indexToDo = -1
            }else {
                    listaItens.add(toDo)
                }
            }
        }
    }
}

