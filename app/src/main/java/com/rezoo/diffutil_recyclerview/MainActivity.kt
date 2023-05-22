package com.rezoo.diffutil_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.rezoo.diffutil_recyclerview.databinding.ActivityMainBinding
import com.rezoo.diffutil_recyclerview.databinding.ItemListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val customAdapter by lazy { CustomAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        customAdapter.differ.submitList(loadData())
        binding.apply {
            rvMain.apply {
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=customAdapter
            }
        }
    }


    fun loadData(): MutableList<Person> {
        val personList: MutableList<Person> = mutableListOf()
        personList.add(Person(1, "reza"))
        personList.add(Person(2, "ali"))
        personList.add(Person(3, "sali"))
        personList.add(Person(4, "mali"))
        personList.add(Person(5, "kali"))
        return personList
    }
}