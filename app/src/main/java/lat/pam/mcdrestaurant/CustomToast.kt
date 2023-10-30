package lat.pam.mcdrestaurant

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

class CustomToast(private val context: Context) {

    fun show(message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customToastView = inflater.inflate(R.layout.custom_toast, null)

        val messageTextView = customToastView.findViewById<TextView>(R.id.customToastMessage)
        messageTextView.text = message

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = customToastView
        toast.show()
    }
}
