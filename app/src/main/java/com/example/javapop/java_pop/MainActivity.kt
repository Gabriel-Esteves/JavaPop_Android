package com.example.javapop.java_pop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.javapop.java_pop.model.Owner
import com.example.javapop.java_pop.model.Repository
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val adapter = RepositoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_listRepositories.layoutManager = LinearLayoutManager(this)
        rv_listRepositories.adapter = adapter

        adapter.setItems(getItems())
    }

    private fun getItems(): ArrayList<Repository> {
        return arrayListOf(
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", "")),
                Repository("REpo 1", "description", 1215, 154, Owner("owner1", ""))
        )
    }

}
