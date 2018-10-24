package e.mobile.todolist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            startActivity(adicionarItem)
        }

        }


    }

