package com.example.che.Adapter

import android.app.AlertDialog
import android.app.AppComponentFactory
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.che.*
import com.example.che.Model.User
import java.security.Permission

class UserAdapter(var dataList : ArrayList<User>,context: Context): RecyclerView.Adapter<UserAdapter.ViewHolder>(){
//     = ArrayList()on
var dbHelper = DbHelper()


    var mycontext: Context = context
    init {
        this.mycontext = context
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
        return ViewHolder(view)

    }


    override fun getItemCount(): Int {
        return dataList.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.uName.text = dataList[position]!!.Name
        holder.ufamily.text = dataList[position]!!.Family
        holder.uid.text = dataList[position]!!.Id.toString()




        Log.i("pejman1",holder.toString())




            holder.btnimageedit.setOnClickListener {

                alertDialog(mycontext, "لطفا گزینه مورد نظر خود را انتخاب کنید", position)

            }

    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var uName : TextView = itemView.findViewById(R.id.txtNemuneh)
        var ufamily : TextView = itemView.findViewById(R.id.textFamily)
        var uid : TextView = itemView.findViewById(R.id.textid)
        var btnimageedit : ImageButton = itemView.findViewById(R.id.btnimageedit)


    }
    fun alertDialog(context: Context,title : String, position: Int)
    {
        val dialog = Dialog(context)
        dialog .requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog .setCancelable(true)
        dialog .setContentView(R.layout.dialog_alert)
        val body = dialog .findViewById(R.id.textdialog) as TextView
        body.text = title
        val delBtn = dialog .findViewById(R.id.btndeletdialog) as Button
        val edtBtn = dialog .findViewById(R.id.btneditdialog) as TextView
        delBtn.setOnClickListener {


            dbHelper.delete(dataList!![position].Id!!)
            dataList.removeAt(position)
            notifyDataSetChanged()

            dialog.dismiss()



        }
        edtBtn.setOnClickListener {
            var id = dataList[position].Id
            var nextpage = Intent(mycontext,ActivityEdit::class.java)
            nextpage.putExtra("pejman" ,id )
            ((mycontext)).startActivity(nextpage)
            dialog.dismiss()


        }
        dialog .show()

    }

    }

