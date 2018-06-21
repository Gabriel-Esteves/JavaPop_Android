package com.example.javapop.java_pop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val repositories: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addRepositories()

        rv_listRepositories.layoutManager = LinearLayoutManager(this)
        rv_listRepositories.adapter = RepositoriesAdapter (repositories, this)

        fun addRepositories.add ("") {
        }
    }
}
