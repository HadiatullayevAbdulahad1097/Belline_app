package developer.abdulahad.bellineapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.bellineapp.R
import developer.abdulahad.bellineapp.Utils.User2
import kotlinx.android.synthetic.main.internet_item.view.*

class InternetAdapter(var list: ArrayList<User2>, var rvClick: RvClick) : RecyclerView.Adapter<InternetAdapter.Vh>() {
        inner class Vh(var itemView: View,var context: Context) : RecyclerView.ViewHolder(itemView){
            fun onBind(user : User2, position: Int) {
                itemView.tv_internet.text = user.name
                itemView.tv_narh.text = user.narh
                itemView.internet_card.setOnClickListener {
                    rvClick.onClick(user,position)
                }
                itemView.image_internet.setOnClickListener {
                    rvClick.onActionDial(position,context)
                    val intent = Intent(Intent.ACTION_DIAL)
                    val input = Uri.encode(user.raqam)
                    intent.data = Uri.parse("tel:$input")
                    context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
            return Vh(LayoutInflater.from(parent.context).inflate(R.layout.internet_item, parent, false),parent.context)
        }

        override fun onBindViewHolder(holder: Vh, position: Int) {
            holder.onBind(list[position],position)
        }

        override fun getItemCount(): Int = list.size

    interface RvClick{
        fun onClick(user: User2, position: Int)
        fun onActionDial(position: Int, context: Context)
    }
    }