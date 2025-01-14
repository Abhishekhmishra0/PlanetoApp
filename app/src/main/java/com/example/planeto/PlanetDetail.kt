package com.example.planeto

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlanetDetail : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private  var planetImg: Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_planet_detail)


        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        obj = intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage",-1)
        setData(obj, planetImg!!)


        findViewById<TextView>(R.id.button_info).setOnClickListener{
            val intent = Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun setData(obj:PlanetData,planetImg:Int){
        findViewById<TextView>(R.id.title_info).text = obj.title
        findViewById<TextView>(R.id.gravity_info).text = obj.gravity + "m/ss"
        findViewById<TextView>(R.id.distance_info).text = obj.distance + "m km"
        findViewById<TextView>(R.id.overview_info).text = obj.overview
        findViewById<ImageView>(R.id.planet_img_info).setImageResource(planetImg)
        findViewById<TextView>(R.id.galaxy_info).text = obj.galaxy
    }
}