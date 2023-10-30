package lat.pam.mcdrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_menu)

        val intent = intent
        val selectedStore = intent.getStringExtra("STORE")
        val userName = intent.getStringExtra("USERNAME")
        val menuName = intent.getStringExtra("MENU_NAME")

        val menu = intent.getParcelableExtra<ItemMenu>(Menu.INTENT_PARCELABLE)
        val nameMenu = findViewById<TextView>(R.id.item_menu)
        val descDetail = findViewById<TextView>(R.id.item_menu_description)
        val imgDetailMenu = findViewById<ImageView>(R.id.img_detail_menu)
        val priceMenu = findViewById<TextView>(R.id.item_price)

        imgDetailMenu.setImageResource(menu?.imgDetail!!)
        nameMenu.text = menu.nameMenu
        descDetail.text = menu.descDetail
        priceMenu.text = menu.priceMenu

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val orderButton = findViewById<Button>(R.id.orderButton)
        orderButton.setOnClickListener {
            val intent = Intent(this, Order::class.java)
            intent.putExtra("STORE", selectedStore)
            intent.putExtra("USERNAME", userName)
            intent.putExtra("MENU_NAME", menuName)
            startActivity(intent)
        }
    }
}
