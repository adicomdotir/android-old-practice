package ir.adicom.androidoldpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.adicom.androidoldpractice.databinding.ActivityAddNoteBinding
import ir.adicom.androidoldpractice.models.Note
import java.text.SimpleDateFormat
import java.util.Date

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var note: Note
    private lateinit var oldNote: Note
    private var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            oldNote = intent.getSerializableExtra("current_note") as Note
            binding.etTitle.setText(oldNote.title)
            binding.etNote.setText(oldNote.note)
            isUpdate = true
        } catch (e: Exception) {

        }

        binding.imgCheck.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val noteDesc = binding.etNote.text.toString()

            if (title.isNotEmpty() || noteDesc.isNotEmpty()) {
                val formatter = SimpleDateFormat("EEE, a MMM yyy HH:mm a")
                if (isUpdate) {
                    note = Note(oldNote.id, title, noteDesc, formatter.format(Date()))
                } else {
                    note = Note(null, title, noteDesc, formatter.format(Date()))
                }

                val intent = Intent()
                intent.putExtra("note", note)
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this@AddNoteActivity, "Please enter some data", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
        }
    }
}