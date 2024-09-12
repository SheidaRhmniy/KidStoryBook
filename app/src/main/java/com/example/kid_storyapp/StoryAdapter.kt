package com.example.kid_storyapp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// آداپتور برای نمایش لیست داستان‌ها در RecyclerView
class StoryAdapter (private val dataSet:ArrayList<Story>):
    RecyclerView.Adapter<StoryAdapter.ViewHolder>()
{
    // متغیر برای مدیریت کلیک‌ها روی آیتم‌ها
    private var onClickListener: OnClickListener? = null
    // کلاس داخلی برای نگهداری ویوهای هر آیتم در RecyclerView
        class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            val tvTitle:TextView = view.findViewById(R.id.tvItemListTitle)
            val image:ImageView = view.findViewById(R.id.itemListImage)
            val tvCategory:TextView = view.findViewById(R.id.tvCategory)
            val tvDesc:TextView = view.findViewById(R.id.tvDesc)

        }
    // ایجاد ویو هولدر جدید برای آیتم‌ها
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list,parent,false)
        return ViewHolder((view))
    }
    // بازگرداندن تعداد آیتم‌ها در داده‌ها
    override fun getItemCount(): Int {
        return dataSet.size
    }
    // تنظیم محتوای ویو هولدر با داده‌های مربوط به آیتم
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.setText(dataSet[position].title)
        holder.tvCategory.setText(dataSet[position].category)
        holder.tvDesc.setText(dataSet[position].moral)
        holder.image.setImageResource(dataSet[position].cvImg)

        //sending position of specific story that has been clicked
        holder.itemView.setOnClickListener{
            if(onClickListener!=null)
            {
                onClickListener!!.onClick(position)
            }
        }
    }

    // تنظیم لیسنر برای کلیک‌ها
    fun setOnClickListener(onClickListener: OnClickListener)
    {
        this.onClickListener = onClickListener
    }
    // اینترفیس برای مدیریت کلیک‌ها
    interface OnClickListener{
        fun onClick(position: Int)
    }
}