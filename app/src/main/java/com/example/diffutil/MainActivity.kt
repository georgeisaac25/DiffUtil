package com.example.diffutil

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.diffutil.R
import kotlinx.android.synthetic.main.main.*


class MainActivity : AppCompatActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var mRecyclerViewAdapter: EmployeeRecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        mRecyclerViewAdapter = EmployeeRecyclerViewAdapter(
            DummyEmployeeDataUtils.getData(), this
        );
        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view);
        mRecyclerView!!.layoutManager = LinearLayoutManager(this);
        mRecyclerView!!.adapter = mRecyclerViewAdapter;
        //mRecyclerViewAdapter!!.notifyDataSetChanged()
        mRecyclerViewAdapter!!.UpdateList(DummyEmployeeDataUtils.getData())
        button.setOnClickListener(View.OnClickListener {
            mRecyclerViewAdapter!!.UpdateList(DummyEmployeeDataUtils.getUpdatedData())
        })
    }
}

internal object DummyEmployeeDataUtils {
    fun getData() = mutableListOf<Employee>(
        Employee(6, "Employee 6", "Team lead"),
        Employee(7, "Employee 7", "Scrum Master"), Employee(4, "Employee 4", "Sales Manager")
        , Employee(5, "Employee 5", "Tester")
    )

    fun getUpdatedData() = mutableListOf<Employee>(
        Employee(6, "Employee 6", "Team lead"),
        Employee(7, "Employee 7", "Scrum Master"), Employee(4, "Employee 4", "Sales Manager")
        , Employee(5, "Employee 5", "Tester"), Employee(8, "Employee 8", "Sr. Tester")
    )


}