package uz.instat.fitneskittest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.instat.fitneskittest.busines.enums.LessonTypes
import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.databinding.ItemDateBinding
import uz.instat.fitneskittest.databinding.ItemLessonBinding
import javax.inject.Inject

class LessonAdapter @Inject constructor() :
    ListAdapter<LessonsHistoryLocal, RecyclerView.ViewHolder>(LessonsHistoryLocal.Companion.LessonCallBack()) {

    class LessonVH(private val binding: ItemLessonBinding) :
        BaseViewHolder<LessonsHistoryLocal>(binding.root) {
        override fun bind(item: LessonsHistoryLocal) {
            binding.tvName.text = item.name
            binding.tvTrName.text = item.trainerName
            binding.tvPrice.text = item.price

            binding.ivLesson.setImageDrawable(
                ContextCompat.getDrawable(
                    itemView.context,
                    LessonTypes.getByValue(item.type).drawable
                )
            )
        }
    }

    class DateVH(private val binding: ItemDateBinding) :
        BaseViewHolder<LessonsHistoryLocal>(binding.root) {
        override fun bind(item: LessonsHistoryLocal) {
            binding.containerDateItem.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TIME -> {
                val binding =
                    ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                DateVH(binding)
            }
            TYPE_LESSON -> {
                val binding =
                    ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LessonVH(binding)
            }
            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val element = getItem(position)
        when (holder) {
            is LessonVH -> {
                holder.bind(element)
            }
            is DateVH -> {
                holder.bind(element)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).name == "") TYPE_TIME
        else TYPE_LESSON
    }

    companion object {
        private const val TYPE_TIME = 0
        private const val TYPE_LESSON = 1
    }
}

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}