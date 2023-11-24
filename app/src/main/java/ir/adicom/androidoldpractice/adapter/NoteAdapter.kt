package ir.adicom.androidoldpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.androidoldpractice.R
import ir.adicom.androidoldpractice.models.Note
import kotlin.random.Random

class NoteAdapter(private val context: Context, private val listener: NoteItemClickListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val noteList = ArrayList<Note>()
    private val fullList = ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.tvNote.text = currentNote.note
        holder.tvTitle.text = currentNote.title
        holder.tvTitle.isSelected = true
        holder.tvDate.text = currentNote.date
        holder.tvDate.isSelected = true

        holder.noteLayout.setCardBackgroundColor(
            holder.itemView.resources.getColor(
                randomColor(),
                null
            )
        )

        holder.noteLayout.setOnClickListener {
            listener.onItemClicked(currentNote)
        }

        holder.noteLayout.setOnLongClickListener {
            listener.onLongItemClicked(currentNote, holder.noteLayout)
            true
        }
    }

    fun updateList(newList: List<Note>) {
        fullList.clear()
        fullList.addAll(newList)

        noteList.clear()
        noteList.addAll(newList)
        notifyDataSetChanged()
    }

    fun filterList(search: String) {
        noteList.clear()
        for (item in fullList) {
            if (
                item.title?.lowercase()?.contains(search.lowercase()) == true ||
                item.note?.lowercase()?.contains(search.lowercase()) == true
            ) {
                noteList.add(item)
            }
        }
        notifyDataSetChanged()
    }

    private fun randomColor(): Int {
        val list = ArrayList<Int>()
        list.add(R.color.note_color1)
        list.add(R.color.note_color2)
        list.add(R.color.note_color3)
        list.add(R.color.note_color4)
        list.add(R.color.note_color5)
        list.add(R.color.note_color6)

        val seed = System.currentTimeMillis().toInt()
        val randomIndex = Random(seed).nextInt(list.size)
        return list[randomIndex]
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteLayout: CardView = itemView.findViewById(R.id.card_layout)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvNote: TextView = itemView.findViewById(R.id.tv_note)
        val tvDate: TextView = itemView.findViewById(R.id.tv_date)
    }

    interface NoteItemClickListener {
        fun onItemClicked(note: Note)
        fun onLongItemClicked(note: Note, cardView: CardView)
    }
}