package lat.pam.mcdrestaurant

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val context: Context,
    private val menu: List<ItemMenu>,
    private var selectedMenu: ItemMenu?,
    val listener: (ItemMenu) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    fun setSelectedMenu(menu: ItemMenu) {
        selectedMenu = menu
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgMenu = view.findViewById<ImageView>(R.id.imageViewMenu)
        val nameMenu = view.findViewById<TextView>(R.id.nama_menu)
        val descMenu = view.findViewById<TextView>(R.id.menu_description)


        fun bindView(menu: ItemMenu, listener: (ItemMenu) -> Unit) {
            imgMenu.setImageResource(menu.imgMenu)
            nameMenu.text = menu.nameMenu
            descMenu.text = menu.descMenu
            itemView.setOnClickListener {
                listener(menu)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)
        )
    }


    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindView(menu[position], listener)
        holder.itemView.setOnClickListener {
            listener(menu[position])
            setSelectedMenu(menu[position])
            Toast.makeText(context, "Menu ${menu[position].nameMenu} telah dipilih", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount(): Int = menu.size

}
