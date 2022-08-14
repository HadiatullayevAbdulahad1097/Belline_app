package developer.abdulahad.bellineapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import developer.abdulahad.bellineapp.Utils.Mydata
import developer.abdulahad.bellineapp.databinding.FragmentItemlarBinding

class ItemlarFragment : Fragment() {
    lateinit var binding: FragmentItemlarBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentItemlarBinding.inflate(layoutInflater)

        when(Mydata.harakat){
            1 ->{
                when(Mydata.list[Mydata.position].name){
                    "Hammasi Zor 1" -> {
                        binding.txtNameTarif.text = "Hammasi Zor 1"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Hammasi Zor 2" -> {
                        binding.txtNameTarif.text = "Hammasi Zor 2"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Hammasi Zor 3" -> {
                        binding.txtNameTarif.text = "Hammasi Zor 3"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Hammasi Zor 4" -> {
                        binding.txtNameTarif.text = "Hammasi Zor 4"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Status Silver" -> {
                        binding.txtNameTarif.text = "Status Silver"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Status Gold" -> {
                        binding.txtNameTarif.text = "Status Gold"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Status Platina" -> {
                        binding.txtNameTarif.text = "Status Platina"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Oson 1" -> {
                        binding.txtNameTarif.text = "Oson 1"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Oson 10" -> {
                        binding.txtNameTarif.text = "Oson 10"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Kunlik" -> {
                        binding.txtNameTarif.text = "Kunlik"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Bolajon" -> {
                        binding.txtNameTarif.text = "Bolajon"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Welcome" -> {
                        binding.txtNameTarif.text = "Welcome"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                    "Uydagidek" -> {
                        binding.txtNameTarif.text = "Uydagidek"
                        binding.txtKodTarif.text = Mydata.list[Mydata.position].narh
                        binding.txtMalumotTarif.text = Mydata.list[Mydata.position].malumot
                    }
                }
            }
            2 ->{
                when(Mydata.list2[Mydata.position2].name) {
                    "1 gb" -> {
                        binding.txtNameTarif.text = "1 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "2 gb" -> {
                        binding.txtNameTarif.text = "2 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "5 gb" -> {
                        binding.txtNameTarif.text = "5 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "10 gb" -> {
                        binding.txtNameTarif.text = "10 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "20 gb" -> {
                        binding.txtNameTarif.text = "20 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "30 gb" -> {
                        binding.txtNameTarif.text = "30 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "50 gb" -> {
                        binding.txtNameTarif.text = "50 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "75 gb" -> {
                        binding.txtNameTarif.text = "75 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "1.5 gb" ->{
                        binding.txtNameTarif.text = "1.5 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "2.5 gb" ->{
                        binding.txtNameTarif.text = "2.5 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "5.0 gb" ->{
                        binding.txtNameTarif.text = "5.0 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "100 mb" ->{
                        binding.txtNameTarif.text = "100 mb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "200 mb" -> {
                        binding.txtNameTarif.text = "200 mb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "500 mb" -> {
                        binding.txtNameTarif.text = "500 mb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "4 gb" -> {
                        binding.txtNameTarif.text = "4 gb"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "5 gb 4g" -> {
                        binding.txtNameTarif.text = "5 gb 4g"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "15 gb 4g" -> {
                        binding.txtNameTarif.text = "15 gb 4g"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                    "30 gb 4g" -> {
                        binding.txtNameTarif.text = "30 gb 4g"
                        binding.txtKodTarif.text = Mydata.list2[Mydata.position2].narh
                        binding.txtMalumotTarif.text = Mydata.list2[Mydata.position2].muddat
                    }
                }
            }
            3 ->{
                when(Mydata.list3[Mydata.position3].name){
                    "Aksiya 40gb" -> {
                        binding.txtNameTarif.text = "Aksiya 40gb"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Aksiya 150gb" -> {
                        binding.txtNameTarif.text = "Aksiya 150gb"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Aksiya 100gb" -> {
                        binding.txtNameTarif.text = "Aksiya 100gb"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Plus 7" -> {
                        binding.txtNameTarif.text = "Plus 7"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Plus 14" -> {
                        binding.txtNameTarif.text = "Plus 14"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Erkin Muloqot" -> {
                        binding.txtNameTarif.text = "Erkin Muloqot"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Erkin Muloqot+" -> {
                        binding.txtNameTarif.text = "Erkin Muloqot+"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Beeline app" -> {
                        binding.txtNameTarif.text = "Beeline app"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Beeline Visa" -> {
                        binding.txtNameTarif.text = "Beeline Visa"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                    "Imo 20 paketi" -> {
                        binding.txtNameTarif.text = "Imo 20 paketi"
                        binding.txtKodTarif.text = Mydata.list3[Mydata.position3].narh
                        binding.txtMalumotTarif.text = Mydata.list3[Mydata.position3].muddat
                    }
                }
            }
            4 ->{
                when(Mydata.list4[Mydata.position4].name){
                    "Paket 100 sms" ->{
                        binding.txtNameTarif.text = "Paket 100 sms"
                        binding.txtKodTarif.text = Mydata.list4[Mydata.position4].narh
                        binding.txtMalumotTarif.text = Mydata.list4[Mydata.position4].malumot
                    }
                    "Paket 500 sms" ->{
                        binding.txtNameTarif.text = "Paket 500 sms"
                        binding.txtKodTarif.text = Mydata.list4[Mydata.position4].narh
                        binding.txtMalumotTarif.text = Mydata.list4[Mydata.position4].malumot
                    }
                    "Paket 1000 sms" ->{
                        binding.txtNameTarif.text = "Paket 1000 sms"
                        binding.txtKodTarif.text = Mydata.list4[Mydata.position4].narh
                        binding.txtMalumotTarif.text = Mydata.list4[Mydata.position4].malumot
                    }
                }
            }
        }
        return binding.root
    }
}