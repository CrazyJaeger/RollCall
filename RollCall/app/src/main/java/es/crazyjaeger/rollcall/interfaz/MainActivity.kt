package es.crazyjaeger.rollcall.interfaz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import es.crazyjaeger.rollcall.R
import es.crazyjaeger.rollcall.interfaz.fragments.grupo.IndiceGruposFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if( savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<IndiceGruposFragment>(R.id.fragment_container)
            }
        }
        setContentView(R.layout.activity_main)
    }
}