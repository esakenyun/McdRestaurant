package lat.pam.mcdrestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Menu : AppCompatActivity() {

    var selectedMenu: ItemMenu? = null

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val intent = intent
        val selectedStore = intent.getStringExtra("STORE")
        val userName = intent.getStringExtra("USERNAME")
        val userTextView = findViewById<TextView>(R.id.helloname)
        userTextView.text = "Hello, $userName"

        val menuList = listOf<ItemMenu>(
            ItemMenu(
                R.drawable.chicken,
                nameMenu = "Chicken",
                descMenu = "Rasakan kelezatan ayam orisinal McDonald's dengan rempah pilihan, pengalaman kuliner tak terlupakan.",
                imgDetail = R.drawable.chicken_detailmenu,
                descDetail = "Ayam Krispy McDonald's adalah sajian lezat yang menggugah selera. Dibuat dengan daging ayam pilihan yang dilapisi tepung renyah dan rempah khusus, kemudian digoreng hingga keemasan. Hasilnya adalah potongan ayam Krispy yang renyah di luar namun tetap juicy dan lembut di dalam. Rasakan kenikmatan gigitan pertama hingga terakhir, menjadikannya pilihan sempurna bagi pecinta ayam goreng yang mencari cita rasa istimewa di setiap suapan.",
                priceMenu = "45.000,00"

            ),
            ItemMenu(
                R.drawable.frenchfries,
                nameMenu = "French Fries",
                descMenu = "Rasakan kelezatan kentang goreng orisinal McDonald's dengan bumbu oriental menggugah selera, tak tertandingi!",
                imgDetail = R.drawable.frenchfries_detailmenu,
                descDetail = "Kentang goreng McDonald's adalah sajian yang tak tertandingi. Dipotong dengan sempurna dan digoreng hingga keemasan, kentang goreng ini memiliki tekstur renyah di luar namun lembut di dalam. Diberi sedikit garam untuk menambah cita rasa, kentang goreng McDonald's adalah pendamping sempurna untuk setiap hidangan, memberikan pengalaman kuliner yang memuaskan bagi para pecinta rasa renyah dan lezat.",
                priceMenu = "18.000,00"
            ),
            ItemMenu(
                R.drawable.cheeseburger,
                nameMenu = "Cheese Burger",
                descMenu = "Rasakan kelembutan cheeseburger kami, lapisan keju lezat, sayuran segar, daging tebal, sensasi burger tak terlupakan.",
                imgDetail = R.drawable.cheeseburger_detailmenu,
                descDetail = "Cheeseburger McDonald's adalah kelezatan yang memikat dengan paduan sempurna daging sapi panggang, lapisan keju lembut, sayuran segar, dan saus istimewa, semua disajikan di dalam roti burger empuk. Setiap gigitan menghadirkan sensasi cita rasa yang harmonis, dari rasa gurih dan lembutnya keju hingga kesegaran sayuran, menciptakan pengalaman burger yang tak terlupakan. Rasakan kelezatan tiada tara dalam setiap suapan.",
                priceMenu = "25.000,00"
            ),
            ItemMenu(
                R.drawable.mcflurry,
                nameMenu = "McFlurry",
                descMenu = "Rasakan segarnya McFlurry McDonald's dengan topping lezat, nikmati kelezatan yang menggugah selera Anda.",
                imgDetail = R.drawable.mcflurry_detailmenu,
                descDetail = "McFlurry McDonald's adalah penciptaan ajaib yang memadukan es krim lembut dengan berbagai pilihan topping menggoda. Rasakan sensasi segar es krim yang meleleh di mulut Anda, dipadu dengan kelezatan unik dari berbagai varian topping, seperti Oreo, cokelat, atau buah-buahan segar. Setiap suapan menghadirkan ledakan rasa yang memanjakan lidah Anda.",
                priceMenu = "13.000,00"
            )
        )

        val adapter = MenuAdapter(this, menuList, selectedMenu) { selectedMenu ->
            this.selectedMenu = selectedMenu
        }

        val recyclerView = findViewById<RecyclerView>(R.id.mainmenu)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        val addButton = findViewById<ImageButton>(R.id.detailButton)
        addButton.setOnClickListener {
            if (selectedMenu != null) {
                val intent = Intent(this, DetailMenu::class.java)
                intent.putExtra(Menu.INTENT_PARCELABLE, selectedMenu) // Menyimpan objek Parcelable
                intent.putExtra("STORE", selectedStore)
                intent.putExtra("USERNAME", userName)
                intent.putExtra("MENU_NAME", selectedMenu?.nameMenu) // Menyimpan nama menu
                startActivity(intent)
            } else {
                Toast.makeText(this, "Pilih menu terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}