package e.mobile.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.item_lista.view.*

class ToDoAdapter (val context:Context, val itens: List<ToDoObject>)
    : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    var clickListener: ((index: Int) -> Unit)? = null

    var clickEditListener: ((index: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, itens[position], clickListener, clickEditListener)
    }

    fun setOnItemClickListener(clickListener: ((index: Int) -> Unit)){
        this.clickListener = clickListener
    }

    fun setOnClickEditListener(clickEditListener: ((index: Int) -> Unit)){
        this.clickEditListener = clickEditListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,
                     todo: ToDoObject,
                     clickListener: ((index: Int) -> Unit)?,
                     clickEditListener: ((index: Int) -> Unit)?) {
            itemView.tvNome.text = todo.text

            if(clickListener != null){
                itemView.setOnClickListener{
                    clickListener.invoke(adapterPosition)
                }
            }

            if(clickEditListener != null){
                itemView.btnEdit.setOnClickListener{
                    clickEditListener.invoke(adapterPosition)
                }
            }
        }
    }
}
