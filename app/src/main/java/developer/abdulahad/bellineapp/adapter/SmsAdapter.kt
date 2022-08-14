package developer.abdulahad.bellineapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.bellineapp.R
import developer.abdulahad.bellineapp.Utils.User4
import kotlinx.android.synthetic.main.sms_item.view.*

class SmsAdapter(var list: List<User4>, var rvClick: RvClick) : RecyclerView.Adapter<SmsAdapter.Vh>() {
        inner class Vh(var itemView: View,var context: Context) : RecyclerView.ViewHolder(itemView){
            fun onBind(user : User4, position: Int) {
                 itemView.sms_txt.text = user.name
                 itemView.sms_txt2.text = user.narh
                 itemView.sms_card.setOnClickListener {
                     rvClick.onClick(user,position)
                 }
                itemView.sms_image.setOnClickListener {
                    rvClick.onActionDial(position,context)
                    val intent = Intent(Intent.ACTION_DIAL)
                    val input = Uri.encode(user.raqam)
                    intent.data = Uri.parse("tel:$input")
                    context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
            return Vh(LayoutInflater.from(parent.context).inflate(R.layout.sms_item, parent, false),parent.context)
        }

        override fun onBindViewHolder(holder: Vh, position: Int) {
            holder.onBind(list[position],position)
        }

        override fun getItemCount(): Int = list.size
    interface RvClick{
        fun onClick(user: User4, position: Int)
        fun onActionDial(position: Int, context: Context)
    }
    }