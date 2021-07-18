package uz.instat.fitneskittest.busines.local

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
class LessonsHistoryLocal(
    val name: String = "",
    val trainerName: String = "",
    val type: String = "",
    val price: String? = "",
    val date: String,
) : Parcelable {
    companion object {
        class LessonCallBack : DiffUtil.ItemCallback<LessonsHistoryLocal>() {
            override fun areItemsTheSame(
                oldItem: LessonsHistoryLocal,
                newItem: LessonsHistoryLocal
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: LessonsHistoryLocal,
                newItem: LessonsHistoryLocal
            ): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}