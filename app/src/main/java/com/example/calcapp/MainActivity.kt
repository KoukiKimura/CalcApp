package com.example.calcapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab1.setOnClickListener {view ->
            if (edit1.text.toString() != "" || edit2.text.toString() != ""){
                operator = "+"
                onClick(view)
            }
            else noText(view)
        }
        fab2.setOnClickListener {view ->
            if (edit1.text.toString() != "" || edit2.text.toString() != ""){
                operator = "-"
                onClick(view)
            }
            else noText(view)
        }
        fab3.setOnClickListener {view ->
            if (edit1.text.toString() != "" || edit2.text.toString() != ""){
                operator = "*"
                onClick(view)
            }
            else noText(view)
        }
        fab4.setOnClickListener {view ->
            if (edit1.text.toString() != "" || edit2.text.toString() != ""){
                operator = "/"
                onClick(view)
            }
            else noText(view)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent( this, SecondActivity::class.java)
        intent.putExtra("VALUE1", edit1.text.toString().toDouble())
        intent.putExtra("VALUE2",edit2.text.toString().toDouble())
        intent.putExtra("OPERATOR",operator)
        startActivity(intent)
    }

    private fun noText(view: View){
        Snackbar.make(view,"数値を入力してください", Snackbar.LENGTH_LONG)
            .setAction("Action",null).show()
    }
}