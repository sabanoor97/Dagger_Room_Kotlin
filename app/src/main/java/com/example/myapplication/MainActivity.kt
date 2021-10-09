package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var notesDao: NotesDao

    private lateinit var notesAdapter: NotesAdapter
    private lateinit var postsRV: RecyclerView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApp).appComponent!!.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Thread {
            val tasks = notesDao.getData()
            notesAdapter.notesList = tasks
            runOnUiThread {
                notesAdapter.notifyDataSetChanged()
            }
            Log.d("Checking", "${notesDao.getData()?.size}")
        }.start()
    }

    private fun initUI() {
        postsRV = findViewById(R.id.rv_add)
        notesAdapter = NotesAdapter(this)
        postsRV.apply {
            adapter = notesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            itemAnimator = DefaultItemAnimator()
        }
    }
}