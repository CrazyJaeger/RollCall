package es.crazyjaeger.rollcall.interfaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.crazyjaeger.rollcall.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.empty_activity)
    }
}