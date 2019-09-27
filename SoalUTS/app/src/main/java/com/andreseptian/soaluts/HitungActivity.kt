package com.andreseptian.soaluts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import kotlin.math.sqrt

class HitungActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var tvLuas: TextView
    private lateinit var tvKeliling : TextView
    private lateinit var tvDiagonal : TextView
    private lateinit var btnHitung : Button
    private lateinit var btnReset : Button

    companion object {
        private const val STATE_RESULT1 = "state_result"
        private const val STATE_RESULT2 = "state_result"
        private const val STATE_RESULT3 = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        val actionBar = supportActionBar
        actionBar!!.title = "HITUNG PERSEGI PANJANG"
        actionBar.setDisplayHomeAsUpEnabled(true)


        edtPanjang = findViewById(R.id.edt_panjang)
        edtLebar = findViewById(R.id.edt_lebar)
        tvLuas = findViewById(R.id.tv_luas)
        tvKeliling = findViewById(R.id.tv_keliling)
        tvDiagonal = findViewById(R.id.tv_diagonal)

        btnHitung = findViewById(R.id.btn_hitung)
        btnHitung.setOnClickListener(this)

        btnReset = findViewById(R.id.btn_reset)
        btnReset.setOnClickListener(this)

        if (savedInstanceState != null) {
            val luas = savedInstanceState.getString(STATE_RESULT1)
            tvLuas.text = luas
            val keliling = savedInstanceState.getString(STATE_RESULT2)
            tvLuas.text = keliling
            val diagonal = savedInstanceState.getString(STATE_RESULT3)
            tvLuas.text = diagonal
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_hitung) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()

            var isEmptyField = false
            var isInvalidNumber = false

            if (inputPanjang.isEmpty()) {
                isEmptyField = true
                edtPanjang.error = "Maaf Field ini tidek boleh kosong"
            }

            if (inputLebar.isEmpty()) {
                isEmptyField = true
                edtLebar.error = "Maaf Field ini tidak boleh Kosong"
            }

            val panjang = toDouble(inputPanjang)
            val lebar = toDouble(inputLebar)

            if (panjang == null) {
                isInvalidNumber = true
                edtPanjang.error = "Field ini Harus Berupa Angka"
            }

            if (lebar == null) {
                isInvalidNumber = true
                edtLebar.error = "Field ini Harus Berupa Angka"
            }

            if (!isEmptyField && !isInvalidNumber) {
                val luas = panjang as Double * lebar as Double
                val keliling = (2 * panjang) + (2 * lebar)
                val diagonal = Math.sqrt(Math.pow(panjang, 2.0) + Math.pow(lebar, 2.0))


                tvLuas.text = luas.toString()
                tvKeliling.text = keliling.toString()
                tvDiagonal.text = diagonal.toString()


            }
        }
        if (v.id == R.id.btn_reset){
            tvLuas.text = 0.toString()
            tvKeliling.text = 0.toString()
            tvDiagonal.text = 0.toString()

            edtPanjang.text.clear()
            edtLebar.text.clear()
        }
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        }catch (e: NumberFormatException) {
            null
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(STATE_RESULT1, tvLuas.text.toString())
        outState.putString(STATE_RESULT2, tvKeliling.text.toString())
        outState.putString(STATE_RESULT3, tvDiagonal.text.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
