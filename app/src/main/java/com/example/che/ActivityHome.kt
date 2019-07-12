package com.example.che

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.che.Adapter.UserAdapter
import com.example.che.Model.User
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.user_row.*

class ActivityHome : AppCompatActivity() {


    var usersList : ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)






        var dbHelper = DbHelper()
        usersList = dbHelper.find()

        recycelman.layoutManager = LinearLayoutManager(this)
        recycelman.adapter = UserAdapter(usersList,this)




    }

    override fun onRestart() {
        super.onRestart()
        var dbHelper = DbHelper()
        usersList = dbHelper.find()

        recycelman.layoutManager = LinearLayoutManager(this)
        recycelman.adapter = UserAdapter(usersList,this)

    }




}
