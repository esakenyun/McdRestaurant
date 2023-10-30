package lat.pam.mcdrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Lokasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi)

        val intent = intent
        val selectedStore = intent.getStringExtra("STORE")
        val userName = intent.getStringExtra("USERNAME")

        val storeTextView = findViewById<TextView>(R.id.lokasi)
        val userTextView = findViewById<TextView>(R.id.helloname)
        storeTextView.text = "$selectedStore"
        userTextView.text = "Hello, $userName"

        val seeMenusButton = findViewById<Button>(R.id.seeMenusButton)
        seeMenusButton.setOnClickListener {
            val intent = intent
            val selectedStore = intent.getStringExtra("STORE")
            val userName = intent.getStringExtra("USERNAME")

            val menuIntent = Intent(this, Menu::class.java)
            menuIntent.putExtra("STORE", selectedStore)
            menuIntent.putExtra("USERNAME", userName)
            startActivity(menuIntent)
        }

    }
}