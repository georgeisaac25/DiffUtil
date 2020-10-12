package com.example.diffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.diffutil.R


class EmployeeRecyclerViewAdapter(var mEmployees: MutableList<Employee>,var context : Context) : RecyclerView.Adapter<EmployeeRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.single_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mEmployees.size;
    }

     fun UpdateList( mEmployees: List<Employee> ){
         val diffCallback = EmployeeDiffCallback(this.mEmployees, mEmployees)
         val diffResult = DiffUtil.calculateDiff(diffCallback)

         this.mEmployees.clear()
         this.mEmployees.addAll(mEmployees)
         diffResult.dispatchUpdatesTo(this)
     }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
         val role: TextView
         val name: TextView

        init {
            name = itemView.findViewById<View>(R.id.employee_name) as TextView
            role = itemView.findViewById<View>(R.id.employee_role) as TextView
        }
    }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val  employee = mEmployees.get(position);
         holder.name.setText(employee.name);
         holder.role.setText(employee.role);
     }
 }