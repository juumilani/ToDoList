package e.mobile.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.item_lista.view.*

class ToDoAdapter (val context:Context, val itens: List<String>)
    : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    var clickListener: ((toDo: String, index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, itens[position], clickListener)
    }

    fun setOnItemClickListener(clickListener: ((toDo: String, index: Int) -> Unit)){
        this.clickListener = clickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, itemNome: String, clickListener: ((toDo: String, index: Int) -> Unit)?) {
            itemView.tvNome.text = itemNome

            if(clickListener != null){
                itemView.setOnClickListener{
                    clickListener.invoke(itemNome, adapterPosition)
                }
            }
        }

    }
}
