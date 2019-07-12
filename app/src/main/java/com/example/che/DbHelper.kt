package com.example.che

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.che.Model.User
import io.realm.Realm
import io.realm.RealmResults


class DbHelper{

    lateinit var realm : Realm
    init {
        realm = Realm.getDefaultInstance()
    }
    fun  find(): ArrayList<User> {
        var user : ArrayList<User> = ArrayList()
        var result : RealmResults<User> = realm.where(User::class.java).findAll()

        for (us in result)
        {
            user.add(us)

        }
        return user
    }

    fun saveData(context: Context, name: String, family: String) {
        realm.executeTransactionAsync({ realm ->
            val number = realm.where(User::class.java!!).max("Id")
            val nextId: Long
            if (number == null) {
                nextId = 1
            } else {
                nextId = number!!.toLong() + 1
            }
            val users = realm.createObject(User::class.java!!, nextId)
            users.Name = name
            users.Family = family

        },
            { Toast.makeText(context, "ذخیره انجام شد", Toast.LENGTH_SHORT).show() },
            { error -> Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show() }
        )
    }

    fun delete( id: Long) {



        var result : RealmResults<User> = realm.where(User::class.java).equalTo("Id",id).findAll()

        realm.beginTransaction()

        result.deleteFromRealm(0)
        realm.commitTransaction()
//        realm.executeTransaction(Realm.Transaction {
//            result.deleteFromRealm(0)
//        })

    }

    fun upDate( name:String, family:String ,id: Long?)
    {
//        realm.executeTransaction(object : Realm.Transaction{
//            override fun execute(realm: Realm) {
        realm.beginTransaction()

                var result = realm!!.where(User::class.java).equalTo("Id",id).findFirst()



//                if(result != null){
                    result!!.Name = if(name.isEmpty()) result.Name else name
                    result!!.Family = if(family.isEmpty()) result.Family else family
                    Log.i("pejman" ,result.toString())

//                }else
//                {
//                    Toast.makeText(context,"incorrect id",Toast.LENGTH_LONG).show()
//                }

        realm.commitTransaction()


//            }
//        })

    }

}