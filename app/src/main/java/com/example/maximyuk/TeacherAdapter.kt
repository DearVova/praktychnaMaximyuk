package com.example.maximyuk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TeacherAdapter(private val teacherList: ArrayList<Teacher>, ) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    class TeacherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val lName : TextView = itemView.findViewById(R.id.lastNameTeacher)
        val fName : TextView = itemView.findViewById(R.id.FirstNameTeacher)
        val sName : TextView = itemView.findViewById(R.id.SurNameTeacher)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item_layout, parent,false)
        return TeacherViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return teacherList.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.lName.text = teacherList[position].lastName
        holder.fName.text = teacherList[position].firstName
        holder.sName.text = teacherList[position].surName
    }
}