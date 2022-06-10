package com.example.a5103kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var recyclerViewMain: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {

        recyclerViewMain = findViewById(R.id.main_recyclerview)
        recyclerViewMain?.layoutManager = GridLayoutManager(this, 1)

        getAdapter(data())

    }

    private fun data(): ArrayList<Main> {
        val main = ArrayList<Main>()
        val story = LinkedList<Story>()
        val photo = ArrayList<Photo>()

        main.add(Main(story))
        for (i in 0..30) {
            story.add(Story(R.drawable.ali, "Alisher"))
        }
        main.add(Main(photo))
        for (i in 0..10) {
            photo.add(Photo(R.drawable.ali))
        }

        for (i in 0..30) {
            if (i == 1){
                val adds = Adds(R.drawable.c)
                  main.add(Main(adds))
            }else{
                main.add(Main(photo))
            }
        }
        return main
    }

    private fun getAdapter(main: ArrayList<Main>) {
        val adapter = PostAdapter(this, main)
        recyclerViewMain?.adapter = adapter
    }
}