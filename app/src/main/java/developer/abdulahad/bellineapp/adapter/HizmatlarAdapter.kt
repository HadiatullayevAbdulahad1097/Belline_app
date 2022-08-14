package developer.abdulahad.bellineapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.bellineapp.R
import developer.abdulahad.bellineapp.Utils.User3
import kotlinx.android.synthetic.main.hizmatlar_item.view.*

class HizmatlarAdapter(var list: ArrayList<User3>, var rvClick : RvClick) : RecyclerView.Adapter<HizmatlarAdapter.Vh>() {
        inner class Vh(var itemView: View,var context: Context) : RecyclerView.ViewHolder(itemView){
            fun onBind(user: User3, position: Int) {
                itemView.tv_internet_name.text = user.name
                itemView.tv_narh_internet.text = user.narh
                itemView.tv_daqiqa_internet.text = user.daqiqa
                itemView.tv_sms_internet.text = user.daqiqa
                itemView.card_hizmatlar.setOnClickListener {
                    rvClick.onClick(list,position)
                }
                itemView.profile_image.setOnClickListener {
                    rvClick.onActionDial(position,context)
                    val intent = Intent(Intent.ACTION_DIAL)
                    val input = Uri.encode(user.raqam)
                    intent.data = Uri.parse("tel:$input")
                    context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
            return Vh(LayoutInflater.from(parent.context).inflate(R.layout.hizmatlar_item, parent, false),parent.context)
        }

        override fun onBindViewHolder(holder: Vh, position: Int) {
            holder.onBind(list[position], position)
        }

        override fun getItemCount(): Int = list.size

    interface RvClick{
        fun onClick(list: ArrayList<User3>, position: Int)
        fun onActionDial(position: Int, context: Context)
    }
    }