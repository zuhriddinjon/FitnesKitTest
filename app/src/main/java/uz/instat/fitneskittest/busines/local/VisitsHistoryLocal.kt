package uz.instat.fitneskittest.busines.local

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize


@Parcelize
data class VisitsHistoryLocal(
    val name: String,
    val data: String,
) : Parcelable {
    companion object {
        class VisitCallBack : DiffUtil.ItemCallback<VisitsHistoryLocal>() {
            override fun areItemsTheSame(
                oldItem: VisitsHistoryLocal,
                newItem: VisitsHistoryLocal
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: VisitsHistoryLocal,
                newItem: VisitsHistoryLocal
            ): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}