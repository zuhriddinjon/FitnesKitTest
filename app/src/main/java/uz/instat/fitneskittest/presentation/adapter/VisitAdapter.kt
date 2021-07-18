package uz.instat.fitneskittest.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.busines.local.VisitsHistoryLocal
import uz.instat.fitneskittest.databinding.ItemDateBinding
import uz.instat.fitneskittest.databinding.ItemVisitBinding
import javax.inject.Inject

class VisitAdapter @Inject constructor() :
    ListAdapter<VisitsHistoryLocal, RecyclerView.ViewHolder>(VisitsHistoryLocal.Companion.VisitCallBack()) {

    class VisitVH(private val binding: ItemVisitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: VisitsHistoryLocal) {
            binding.tvName.text = item.name
            binding.tvDate.text = item.data
//            if(item.type)
        }
    }

    class DateVH(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LessonsHistoryLocal) {
            binding.containerDateItem.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemVisitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VisitVH(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VisitVH).bind(getItem(position))
    }
}