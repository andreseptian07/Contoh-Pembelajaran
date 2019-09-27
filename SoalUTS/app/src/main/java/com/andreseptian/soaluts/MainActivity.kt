package com.andreseptian.soaluts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToHitung: Button = findViewById(R.id.btn_to_hitung)
        btnToHitung.setOnClickListener(this)
        val btnToDetail: Button = findViewById(R.id.btn_to_detail)
        btnToDetail.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_utama, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectMode: Int) {
        when (selectMode) {
            R.id.mn_profile -> {
                val moveToProfile = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveToProfile)
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_to_hitung -> {
                val moveInten = Intent(this@MainActivity, HitungActivity::class.java)
                startActivity(moveInten)
            }

            R.id.btn_to_detail -> {
                val moveIntent = Intent (this@MainActivity, DetailActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
