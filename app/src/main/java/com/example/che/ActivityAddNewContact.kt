package com.example.che

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import com.example.che.Model.User
import io.realm.Realm
import io.realm.RealmResults
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_row.*


class ActivityAddNewContact : AppCompatActivity() {
    lateinit var realm : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm = Realm.getDefaultInstance()

        var dbHelper = DbHelper()

//        btnupdate.setOnClickListener {
////            var id : Long = edtid.text.toString().toLong()
//
//            var neme = edtName.text.toString()
//            var family = edtFamily.text.toString()
//
//
//                var id : Long = edtid.text.toString().toLong()
//
////                upDate(this,neme,family,id)
//               dbHelper.upDate(neme,family,id)
//
//                ShowToast("آپدیت انجام شد")
//                edtid.setText("")
//                edtName.setText("")
//                edtFamily.setText("")
//
//
//
//        }
       btnAddUser.setOnClickListener {

           var neme = edtName.text.toString()
           var family = edtFamily.text.toString()
           if (neme == "" && family == "")
           {
               Toast.makeText(this,"لطفا فیلدهای خالی را پر کنید",Toast.LENGTH_LONG).show()
           }else
           {
              dbHelper.saveData(this,neme,family)
               ShowToast("با موفقیت ثبت شد")

               edtName.setText("")
               edtFamily.setText("")
           }


      }
//        btndelete.setOnClickListener {
//
//            var id = edtid.text.toString()
//            if (id == "")
//            {
//                Toast.makeText(this,"لطفا فیلد id را پر کنید",Toast.LENGTH_LONG).show()
//            }
//            else
//            {
//                var id : Long = edtid.text.toString().toLong()
//                if (id != null)
//                {
//                    dbHelper.delete(id)
//                }else
//                {
//                    Toast.makeText(this,"id dorost vared kon",Toast.LENGTH_LONG).show()
//                }
//
//
//
//
//                ShowToast("شماره مورد نظر پاک شد")
//                edtid.setText("")
//                edtName.setText("")
//                edtFamily.setText("")
//            }
//        }
        btnshow.setOnClickListener {
            var nextpage = Intent(this,ActivityHome::class.java)

           startActivity(nextpage)


       }

    }

    fun ShowToast(t : String)
    {
        Toast.makeText(this,t,Toast.LENGTH_LONG).show()


    }



       }


