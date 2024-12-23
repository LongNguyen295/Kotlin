package com.example.a15_10_2024

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var items = mutableListOf<String>()
        for(i in 1 .. 50)
            items.add("Item $i")

        var adapter: ArrayAdapter<String> = ArrayAdapter(
            context: this,
            android.R.layout.simple_list_item_1,
            items
        )

        val adapter: ArrayAdapter<String> = ArrayAdapter{
            context: this,
            R.layout.layout_item.
            R.id.text_content,
            items
        }

        val ListView: ListView = findViewById(R.id.list_View)
        listView.adapter = adapter

        listView.setonitemclicklistener { adapterView, view, i, l ->
            val selectedItem = items[i]
            log.v(tag: "TAG", msg: "Selected Item: $selectedItem") // bat logcat
        }

        findViewById<Button>(R.id.btn_add).setOnClickListener{
            items.add(index: 0, element: "NEW ITEM")
            adapter.notifyDataSetChanged() //giao dien duoc cap nhat ngay khi du lieu thay doi
        }

        findViewById<Button>(R.id.btn_remove).setOnClickListener{
            items.removeAt(index: 0)
            adapter.notifyDataSetChanged() //giao dien duoc cap nhat ngay khi du lieu thay doi
        }

        findViewById<Button>(R.id.btn_update).setOnClickListener{
            items[0] = "UPDATE ITEM"
            adapter.notifyDataSetChanged() //giao dien duoc cap nhat ngay khi du lieu thay doi
        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}