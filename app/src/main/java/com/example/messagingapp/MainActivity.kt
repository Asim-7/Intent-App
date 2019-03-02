package com.example.messagingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data.setOnClickListener{
            Toast.makeText(this,"Data Clicked",Toast.LENGTH_SHORT).show()
            //getting data
            val dataMsg: String = msgText.text.toString()
            //Explicit Intent
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("keyOne",dataMsg)
            startActivity(intent)

            show.isEnabled = true
        }
        show.setOnClickListener {
            Toast.makeText(this, "Show clicked", Toast.LENGTH_SHORT).show()
        }
        share.setOnClickListener{
            val dataMsg: String = msgText.text.toString()
            //Implicit Intent
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, dataMsg)
            shareIntent.type = "text/plain"

            startActivity(Intent.createChooser(shareIntent,"Share to: "))
        }

    }
}
