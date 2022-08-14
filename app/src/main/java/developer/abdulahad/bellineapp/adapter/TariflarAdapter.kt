package developer.abdulahad.bellineapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.bellineapp.R
import developer.abdulahad.bellineapp.Utils.User
import kotlinx.android.synthetic.main.tariflar_item.view.*


class TariflarAdapter(var list: List<User>, var rvClick: RvClick) : RecyclerView.Adapter<TariflarAdapter.Vh>(){
        inner class Vh(var itemView: View,var context: Context) : RecyclerView.ViewHolder(itemView){
            fun onBind(user : User, position: Int) {
                itemView.tv_tariflar_item.text = user.name
                itemView.tv2_tariflar_item.text = user.narh
                when(user.name){
                    "Hammasi Zor 1" ->{
                        itemView.profile_image.setImageResource(R.drawable.hammasizor1)
                    }
                    "Hammasi Zor 2" ->{
                        itemView.profile_image.setImageResource(R.drawable.hammasizor2)
                    }
                    "Hammasi Zor 3" ->{
                        itemView.profile_image.setImageResource(R.drawable.hammasizor3)
                    }
                    "Hammasi Zor 4" ->{
                        itemView.profile_image.setImageResource(R.drawable.hammasizor4)
                    }
                    "Status Silver" ->{
                        itemView.profile_image.setImageResource(R.drawable.statussilver)
                    }
                        "Status Gold" ->{
                            itemView.profile_image.setImageResource(R.drawable.statusgold)
                    }
                    "Status Platina" ->{
                        itemView.profile_image.setImageResource(R.drawable.statusplatina)
                    }
                    "Oson 1" -> {
                        itemView.profile_image.setImageResource(R.drawable.oson1)
                    }
                    "Oson 10" ->{
                        itemView.profile_image.setImageResource(R.drawable.oson10)
                    }
                    "Kunlik" ->{
                        itemView.profile_image.setImageResource(R.drawable.kunlik)
                    }
                    "Bolajon" ->{
                        itemView.profile_image.setImageResource(R.drawable.bolajon)
                    }
                        "Werlcome" ->{
                            itemView.profile_image.setImageResource(R.drawable.welcome)
                    }
                    "Uydagidek" ->{
                        itemView.profile_image.setImageResource(R.drawable.uydagidek)
                    }
                }
                itemView.card_tariflar_item.setOnClickListener {
                    rvClick.onClick(user,position)
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
            return Vh(LayoutInflater.from(parent.context).inflate(R.layout.tariflar_item, parent, false),parent.context)
        }

        override fun onBindViewHolder(holder: Vh, position: Int) {
            holder.onBind(list[position],position)
        }

        override fun getItemCount(): Int = list.size

    interface RvClick{
        fun onClick(user: User, position: Int)
        fun onActionDial(position: Int, context: Context)
    }


//    fun onItemDismiss(position: Int, context: Context) {
//        val intent = Intent(Intent.ACTION_DIAL)
//        intent.data = Uri.parse("tel: ${list[position].raqam}")
//        context.startActivity(intent)
//    }
}