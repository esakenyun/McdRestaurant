package lat.pam.mcdrestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class Order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = intent
        val selectedStore = intent.getStringExtra("STORE")
        val userName = intent.getStringExtra("USERNAME")
        val namaMenu = intent.getStringExtra("MENU_NAME")

        val userTextView = findViewById<TextView>(R.id.helloname)
        userTextView.text = "Nama  : $userName"

        val selectStoreView = findViewById<TextView>(R.id.store)
        selectStoreView.text = "Store : $selectedStore"

        val namaMenuView = findViewById<TextView>(R.id.ordered)
        namaMenuView.text = "$namaMenu sudah dipesan"

        val ambilSendiriCheckBox = findViewById<CheckBox>(R.id.ambilsendiri)
        val fastDeliveryCheckBox = findViewById<CheckBox>(R.id.fastdelivery)
        val doneButton = findViewById<Button>(R.id.backButton)

        doneButton.setOnClickListener {
            val ambilSendiriChecked = ambilSendiriCheckBox.isChecked
            val fastDeliveryChecked = fastDeliveryCheckBox.isChecked

            if (ambilSendiriChecked && fastDeliveryChecked) {
                val toastMessage = "Mohon Maaf, Silahkan pilih salah satu opsi pengiriman"
                CustomToast(this).show(toastMessage)
            } else if (ambilSendiriChecked) {
                val toastMessage =
                    "Terima Kasih Pa $userName sudah memesan di toko kami. Pesanan $namaMenu Anda akan diambil sendiri ke tempat kami."
                CustomToast(this).show(toastMessage)
            } else if (fastDeliveryChecked) {
                val toastMessage =
                    "Terima Kasih Pa $userName sudah memesan di toko kami. Pesanan $namaMenu Anda akan dikirim menggunakan Fast Delivery."
                CustomToast(this).show(toastMessage)
            } else {
                val toastMessage = "Pilih salah satu opsi pengiriman terlebih dahulu"
                CustomToast(this).show(toastMessage)
            }
        }


    }
}