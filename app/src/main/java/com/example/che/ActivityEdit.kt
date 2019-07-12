package com.example.che

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.che.Adapter.UserAdapter
import com.example.che.Model.User
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import kotlinx.android.synthetic.main.dialog_alert.*

class ActivityEdit : AppCompatActivity() {

    var list : ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        var id = intent.getLongExtra("pejman",2)




        btneditEdit.setOnClickListener {
            var name = edteditname.text.toString()
            var family = edteditfamily.text.toString()

            var dbHelper = DbHelper()

            dbHelper.upDate(name,family,id)

            var adapt = UserAdapter(list,this)
            adapt.notifyDataSetChanged()


//            recycelman.notifySubtreeAccessibilityStateChanged()
            finish()
        }

        btncancel.setOnClickListener {
            finish()
        }

        onRestart()




    }


}

//private fun RecyclerView.notifySubtreeAccessibilityStateChanged() {
//
//}
