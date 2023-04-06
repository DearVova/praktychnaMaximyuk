package com.example.maximyuk

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TeachersActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherList: ArrayList<Teacher>
    private var db = Firebase.firestore

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teachers)

        recyclerView = findViewById(R.id.teacherRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        teacherList = arrayListOf()

        db = FirebaseFirestore.getInstance()

        db.collection("teachers").get().addOnSuccessListener {
            if(!it.isEmpty){
                for(data in it.documents){
                    val teacher:Teacher? = data.toObject(Teacher::class.java)
                    if (teacher != null) {
                        teacherList.add(teacher)
                    }
                }
                recyclerView.adapter = TeacherAdapter(teacherList)
            }
        }
            .addOnFailureListener{
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            }


    }


}