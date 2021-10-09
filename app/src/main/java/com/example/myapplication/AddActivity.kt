package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class AddActivity : AppCompatActivity() {

    @Inject
    lateinit var notesDao: NotesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        (application as MyApp).appComponent!!.inject(this)

        val save = findViewById<Button>(R.id.btn_save)
        val etTitle = findViewById<EditText>(R.id.et_title)
        val etDescription = findViewById<EditText>(R.id.et_description)

        save.setOnClickListener {

            val title = etTitle.text.toString()
            val description = etDescription.text.toString()

            Thread {
                val note = Notes()
                note.title = title
                note.description = description
                notesDao.insert(note)
                val size = notesDao.getData().size
                Log.d("size", size.toString())
            }.start()
        }
    }
}