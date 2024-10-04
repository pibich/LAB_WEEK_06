package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {

        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.Persian, "Tommy", "Fluffy and friendly", "https://cdn2.thecatapi.com/images/2b7.jpg"),
                CatModel(Gender.Female, CatBreed.Bengal, "Mia", "Active and playful", "https://cdn2.thecatapi.com/images/1g6.jpg"),
                CatModel(Gender.Male, CatBreed.Ragdoll, "Leo", "Gentle giant", "https://cdn2.thecatapi.com/images/3e7.jpg"),
                CatModel(Gender.Female, CatBreed.Sphynx, "Nina", "Loves attention", "https://cdn2.thecatapi.com/images/4f6.jpg"),
                CatModel(Gender.Unknown, CatBreed.Abyssinian, "Coco", "Curious and energetic", "https://cdn2.thecatapi.com/images/5g7.jpg"),
                CatModel(Gender.Male, CatBreed.Siamese, "Shadow", "Talkative and loyal", "https://cdn2.thecatapi.com/images/6h8.jpg"),
                CatModel(Gender.Female, CatBreed.BritishShorthair, "Bella", "Calm and dignified", "https://cdn2.thecatapi.com/images/7i9.jpg")
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}


