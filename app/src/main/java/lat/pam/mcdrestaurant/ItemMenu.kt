package lat.pam.mcdrestaurant

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class ItemMenu(
    val imgMenu: Int,
    val nameMenu: String,
    val descMenu: String,
    val imgDetail: Int,
    val descDetail: String,
    val priceMenu: String
) : Parcelable
