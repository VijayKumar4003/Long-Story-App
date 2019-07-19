package com.dinocodeacademy.longstoryapp.activites

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import com.dinocodeacademy.longstoryapp.R
import com.dinocodeacademy.longstoryapp.adapters.ListViewAdapter
import com.dinocodeacademy.longstoryapp.model.StoryClass

class MainActivity : AppCompatActivity() {


    var title = arrayOf(

        "Android Developers",
        "Game Programmer",
        "Web Developer",
        "AI Expert",
        "Game Developer",
        "Special Designer",
        "Programming",
        "Hello World!"

    )

    var profile = intArrayOf(

        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
        R.drawable.f,
        R.drawable.a,
        R.drawable.b
    )


    var time = arrayOf(
        "25 min ago",
        "5 min ago",
        "25 min ago",
        "5 min ago",
        "25 min ago",
        "2 min ago",
        "25 min ago",
        "25 min ago"
    )

    var comment = arrayOf(
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)",
        "Ohh cool! Subscribe to Dino Code Acadmey YouTube Channel for more stuff :)"
    )

    private var storyClass:ArrayList<StoryClass>?= null
    private var listViewAdapter:ListViewAdapter? = null
    private var ls: ListView? = null

    lateinit var lf: LayoutInflater

    lateinit var headerView:View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.long_story_app)

        ls = findViewById(R.id.list)

        lf = this.layoutInflater

        headerView  = lf.inflate(R.layout.header,null,false) as View

        ls!!.addHeaderView(headerView,null,false)

        storyClass = ArrayList()



        for (i in title.indices){

            val storyClassob = StoryClass(title[i],profile[i],time[i],comment[i])
            storyClass!!.add(storyClassob)

        }

        listViewAdapter = ListViewAdapter(this@MainActivity,storyClass!!)

        ls!!.adapter = listViewAdapter

    }
}
