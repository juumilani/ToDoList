package e.mobile.todolist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThreadWithContext
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListaToDoActivity : AppCompatActivity() {

    companion object{
        private const val REQUEST_CADASTRO: Int = 1
    }
    var listaItens: MutableList<ToDoObject> = mutableListOf()
    var indexToDo: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddItem.setOnClickListener() {
            val adicionarItem = Intent(this, cadastroToDoActivity::class.java)
            startActivity(adicionarItem)
        }
    }

    override fun onResume(){
        super.onResume()
        carregaLista()
    }

    fun carregaLista() {

        val ToDoDao = AppDatabase.getInstance(this).ToDoDao()

        doAsync {
            listaItens = ToDoDao.getAll() as MutableList<ToDoObject>

            activityUiThreadWithContext {
                val adapter = ToDoAdapter(this, listaItens)

                adapter.setOnItemClickListener{indexToDo ->
                    val editaToDo = Intent(this, cadastroToDoActivity::class.java)
                    editaToDo.putExtra(cadastroToDoActivity.EXTRA_NOVO_TODO, listaItens.get(indexToDo))
                    startActivity(editaToDo)
                }

                val layoutManager = LinearLayoutManager(this)

                rvItens.adapter = adapter
                rvItens.layoutManager = layoutManager
            }
        }


    }

/*    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
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
    }*/
}

