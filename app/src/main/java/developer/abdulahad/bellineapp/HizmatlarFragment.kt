package developer.abdulahad.bellineapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulahad.bellineapp.R
import developer.abdulahad.bellineapp.Utils.*
import developer.abdulahad.bellineapp.adapter.HizmatlarAdapter
import developer.abdulahad.bellineapp.adapter.InternetAdapter
import developer.abdulahad.bellineapp.adapter.SmsAdapter
import developer.abdulahad.bellineapp.adapter.TariflarAdapter
import developer.abdulahad.bellineapp.databinding.FragmentHizmatlarBinding

class HizmatlarFragment : Fragment(){
   lateinit var list4: ArrayList<User4>
   lateinit var list3: ArrayList<User3>
   lateinit var list2: ArrayList<User2>
   lateinit var list1: ArrayList<User>
   lateinit var smsAdapter: SmsAdapter
   lateinit var hizmatlarAdapter: HizmatlarAdapter
   lateinit var internetAdapter: InternetAdapter
   lateinit var tariflarAdapter: TariflarAdapter
   lateinit var binding: FragmentHizmatlarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        
        binding = FragmentHizmatlarBinding.inflate(layoutInflater)

        list1 = ArrayList()
        list2 = ArrayList()
        list3 = ArrayList()
        list4 = ArrayList()


        when(Sanoq.raqam) {
            1 -> {
                tariflarAdapter = TariflarAdapter(list1, object : TariflarAdapter.RvClick {
                    override fun onClick(user: User, position: Int) {
                        findNavController().navigate(R.id.itemlarFragment)
                        Mydata.list = list1
                        Mydata.position = position
                        Mydata.harakat = 1
                    }

                    override fun onActionDial(position: Int, context: Context) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel: ${list1[position].raqam}")
                        context.startActivity(intent)
                    }

                })



                binding.rvObshiy.adapter = tariflarAdapter

                binding.imageBacObshiy2.visibility = View.INVISIBLE
                binding.imageBacObshiy.visibility = View.VISIBLE
                binding.imageBacObshiy3.visibility = View.INVISIBLE
                binding.imageBacObshiy4.visibility = View.INVISIBLE
                list1.add(
                    User(
                        R.drawable.hammasizor1,
                        "*2*3#",
                        "Hammasi Zor 1",
                        "20.000 sum",
                        "* Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovi to'liq yechiladi va tarif bo’yicha trafik ham to'liq taqdim etiladi.                \n" +
                                "• Navbatdagi oylik abonent to'lovi to'lanishi kerak bo'lgan sanada abonent balansida yetarli mablag' bo'lsa oylik abonent to'lovi yechiladi va bir oylik trafik paketi taqdim etiladi. Agarda abonent balansida bir oylik abonent to'lovi uchun yetarli mablag' bo'lmasa abonent to'lovi yechilmaydi va tarif bo'yicha belgilangan trafik taqdim etilmaydi. Ushbu holatda aloqa xizmatlari uchun to'lov tarif reja shartlariga asosan narxlanadi.                \n" +
                                "• Bir oylik abonent to'lovini to'lash uchun yetarli mablag' jamlanishi bilan u darhol yechiladi va bir oylik paketlar taqdim etiladi. Keyingi oylik abonent to'lovi yeсhilishi sanasi oxirgi abonent to’lovi yechilgan sanadan 1 oyga uzaytiriladi.                \n" +
                                "• Tarifda belgilangan oylik trafik qoldig'i amal qilish muddati tugashi bilan kuyadi, keyingi oyda taqdim etiladigan trafikga qo'shilmaydi.                \n" +
                                "• Tarif bo’yicha taqdim etilgan GB, daqiqa va SMSlarni faqatgina raqam faol holatda bo’lganida sarflash mumkin.                \n" +
                                "• Internetdan foydalanganda avval tarif bo'yicha, so'ng internet paketlar bo'yicha trafik sarflanadi.                \n" +
                                "• Tarifga kiritilgan oylik paket tugagandan so’ng uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi.                \n" +
                                "• Tarifga kiritilgan paketlar taqdim etilgungacha internet, SMS va qo’ng’iroqlar narxlanishi tarif bo’yicha standart narxlar asosida amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, trafik sizga taqdim etilganiga ishonch hosil qiling. Gigabaytlarni tekshirish uchun *103#, daqiqalar uchun - *106#, SMSlar uchun -*105#.                \n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun 421 so'm kunlik abonent to'lovi yechiladi. Shunda tarif bo’yicha oylik abonent to’lovi yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo'yicha yangi oylik limitlar taqdim etiladi. Sarflanmay qolgan avvalgi limitlar kuyadi. Keyingi abonent to'lovi yechilishi sanasi oxirgi oylik abonent to'lovi yechilgan kundan boshlab 1 oy muddatga suriladi. Agar oylik abonent to’lovi yechilishiga yetarli mablag’ bo’lmasa, u holda aloqa xizmatlaridan foydalanish tarifda belgilangan standart narxlarga asosan amalga oshiriladi. Agar raqam blok holatidan chiqarilgandan so’ng abonent hisobida abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, hisobdan mablag’ yechilmaydi va yangi trafik taqdim etilmaydi. Avvalgi oydan qolgan tarif reja trafiki mavjud bo’lsa, uning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.                \n" +
                                "• Tarif rejalarda balans nolga teng yoki qarz holatida bo'lganda ham, abonentlar barcha mobil raqamlardan qo’ng’iroqlar va SMS-xabarlar qabul qilishi mumkin                \n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.                \n" +
                                "• Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.                \n" +
                                "• Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.                \n" +
                                "• Mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun Abonent raqami faol holatida bo'lishi kerak."
                    )
                )
                list1.add(
                    User(
                        R.drawable.hammasizor2,
                        "*2*5#",
                        "Hammasi Zor 2",
                        "30.000 sum",
                        "* Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «Hammasi ZO’R 2» tarifida «Beeline TV»da telekanallar uchun oylik cheksiz foydalanish imkoniyati kiritilgan. «Beeline TV» ilovasida telekanallardan cheksiz foydalanishni abonent to’lovi to’langanidan so’ng amalga oshirish mumkin. «Beeline TV» ilovasini yuklab olish uchun - *6#\n" +
                                "\n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovi to'liq yechiladi va tarif bo’yicha trafik ham to'liq taqdim etiladi.                \n" +
                                "• Navbatdagi oylik abonent to'lovi to'lanishi kerak bo'lgan sanada abonent balansida yetarli mablag' bo'lsa oylik abonent to'lovi yechiladi va bir oylik trafik paketi taqdim etiladi. Agarda abonent balansida bir oylik abonent to'lovi uchun yetarli mablag' bo'lmasa abonent to'lovi yechilmaydi va tarif bo'yicha belgilangan trafik taqdim etilmaydi. Ushbu holatda aloqa xizmatlari uchun to'lov tarif reja shartlariga asosan narxlanadi.                \n" +
                                "• Bir oylik abonent to'lovini to'lash uchun yetarli mablag' jamlanishi bilan u darhol yechiladi va bir oylik paketlar taqdim etiladi. Keyingi oylik abonent to'lovi yeсhilishi sanasi oxirgi abonent to’lovi yechilgan sanadan 1 oyga uzaytiriladi.                \n" +
                                "• Tarifda belgilangan oylik trafik qoldig'i amal qilish muddati tugashi bilan kuyadi, keyingi oyda taqdim etiladigan trafikga qo'shilmaydi.                \n" +
                                "• Tarif bo’yicha taqdim etilgan GB, daqiqa va SMSlarni faqatgina raqam faol holatda bo’lganida sarflash mumkin.                \n" +
                                "• Internetdan foydalanganda avval tarif bo'yicha, so'ng internet paketlar bo'yicha trafik sarflanadi.                \n" +
                                "• Tarifga kiritilgan oylik paket tugagandan so’ng uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi.                \n" +
                                "• Tarifga kiritilgan paketlar taqdim etilgungacha internet, SMS va qo’ng’iroqlar narxlanishi tarif bo’yicha standart narxlar asosida amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, trafik sizga taqdim etilganiga ishonch hosil qiling. Gigabaytlarni tekshirish uchun *103#, daqiqalar uchun - *106#, SMSlar uchun -*105#.                \n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun 421 so'm kunlik abonent to'lovi yechiladi. Shunda tarif bo’yicha oylik abonent to’lovi yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo'yicha yangi oylik limitlar taqdim etiladi. Sarflanmay qolgan avvalgi limitlar kuyadi. Keyingi abonent to'lovi yechilishi sanasi oxirgi oylik abonent to'lovi yechilgan kundan boshlab 1 oy muddatga suriladi. Agar oylik abonent to’lovi yechilishiga yetarli mablag’ bo’lmasa, u holda aloqa xizmatlaridan foydalanish tarifda belgilangan standart narxlarga asosan amalga oshiriladi. Agar raqam blok holatidan chiqarilgandan so’ng abonent hisobida abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, hisobdan mablag’ yechilmaydi va yangi trafik taqdim etilmaydi. Avvalgi oydan qolgan tarif reja trafiki mavjud bo’lsa, uning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.                \n" +
                                "• Tarif rejalarda balans nolga teng yoki qarz holatida bo'lganda ham, abonentlar barcha mobil raqamlardan qo’ng’iroqlar va SMS-xabarlar qabul qilishi mumkin                \n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.                \n" +
                                "• Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.                \n" +
                                "• Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.                \n" +
                                "• Mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun Abonent raqami faol holatida bo'lishi kerak."
                    )
                )
                list1.add(
                    User(
                        R.drawable.hammasizor3,
                        "*2*8#",
                        "Hammasi Zor 3",
                        "40.000 sum",
                        "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar uchun to’lov tarif rejaga asosan yechiladi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «Hammasi ZO’R 3» tarifida «Beeline TV»da telekanallar va «Amediateka» hamda «Beeline Music» uchun oylik cheksiz foydalanish imkoniyati kiritilgan. «Beeline Music» va «Beeline TV» ilovalaridan cheksiz foydalanishni abonent to’lovi to’langanidan so’ng amalga oshirish mumkin. Ilovalarni yuklab olish uchun: «Beeline TV» - *6#, «Beeline Music» - *9#.\n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovi to'liq yechiladi va tarif bo’yicha trafik ham to'liq taqdim etiladi.                \n" +
                                "• Navbatdagi oylik abonent to'lovi to'lanishi kerak bo'lgan sanada abonent balansida yetarli mablag' bo'lsa oylik abonent to'lovi yechiladi va bir oylik trafik paketi taqdim etiladi. Agarda abonent balansida bir oylik abonent to'lovi uchun yetarli mablag' bo'lmasa abonent to'lovi yechilmaydi va tarif bo'yicha belgilangan trafik taqdim etilmaydi. Ushbu holatda aloqa xizmatlari uchun to'lov tarif reja shartlariga asosan narxlanadi.                \n" +
                                "• Bir oylik abonent to'lovini to'lash uchun yetarli mablag' jamlanishi bilan u darhol yechiladi va bir oylik paketlar taqdim etiladi. Keyingi oylik abonent to'lovi yeсhilishi sanasi oxirgi abonent to’lovi yechilgan sanadan 1 oyga uzaytiriladi.                \n" +
                                "• Tarifda belgilangan oylik trafik qoldig'i amal qilish muddati tugashi bilan kuyadi, keyingi oyda taqdim etiladigan trafikga qo'shilmaydi.                \n" +
                                "• Tarif bo’yicha taqdim etilgan GB, daqiqa va SMSlarni faqatgina raqam faol holatda bo’lganida sarflash mumkin.                \n" +
                                "• Internetdan foydalanganda avval tarif bo'yicha, so'ng internet paketlar bo'yicha trafik sarflanadi.                \n" +
                                "• Tarifga kiritilgan oylik paket tugagandan so’ng uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi.                \n" +
                                "• Tarifga kiritilgan paketlar taqdim etilgungacha internet, SMS va qo’ng’iroqlar narxlanishi tarif bo’yicha standart narxlar asosida amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, trafik sizga taqdim etilganiga ishonch hosil qiling. Gigabaytlarni tekshirish uchun *103#, daqiqalar uchun - *106#, SMSlar uchun -*105#.                \n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun 421 so'm kunlik abonent to'lovi yechiladi. Shunda tarif bo’yicha oylik abonent to’lovi yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo'yicha yangi oylik limitlar taqdim etiladi. Sarflanmay qolgan avvalgi limitlar kuyadi. Keyingi abonent to'lovi yechilishi sanasi oxirgi oylik abonent to'lovi yechilgan kundan boshlab 1 oy muddatga suriladi. Agar oylik abonent to’lovi yechilishiga yetarli mablag’ bo’lmasa, u holda aloqa xizmatlaridan foydalanish tarifda belgilangan standart narxlarga asosan amalga oshiriladi. Agar raqam blok holatidan chiqarilgandan so’ng abonent hisobida abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, hisobdan mablag’ yechilmaydi va yangi trafik taqdim etilmaydi. Avvalgi oydan qolgan tarif reja trafiki mavjud bo’lsa, uning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.                \n" +
                                "• Tarif rejalarda balans nolga teng yoki qarz holatida bo'lganda ham, abonentlar barcha mobil raqamlardan qo’ng’iroqlar va SMS-xabarlar qabul qilishi mumkin                \n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.                \n" +
                                "• Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.                \n" +
                                "• Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.                \n" +
                                "• Mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun Abonent raqami faol holatida bo'lishi kerak.\n"
                    )
                )
                list1.add(
                    User(
                        R.drawable.hammasizor4,
                        "*2*15#",
                        "Hammasi Zor 4",
                        "60.000 sum",
                        "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar uchun to’lov tarif rejaga asosan yechiladi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «Hammasi ZO’R 4» tarifida «Beeline TV»da telekanallar va «Amediateka» hamda «Beeline Music» uchun oylik cheksiz foydalanish imkoniyati kiritilgan. «Beeline Music» va «Beeline TV» ilovalaridan cheksiz foydalanishni abonent to’lovi to’langanidan so’ng amalga oshirish mumkin. Ilovalarni yuklab olish uchun: «Beeline TV» - *6#, «Beeline Music» - *9#.\n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovi to'liq yechiladi va tarif bo’yicha trafik ham to'liq taqdim etiladi.                \n" +
                                "• Navbatdagi oylik abonent to'lovi to'lanishi kerak bo'lgan sanada abonent balansida yetarli mablag' bo'lsa oylik abonent to'lovi yechiladi va bir oylik trafik paketi taqdim etiladi. Agarda abonent balansida bir oylik abonent to'lovi uchun yetarli mablag' bo'lmasa abonent to'lovi yechilmaydi va tarif bo'yicha belgilangan trafik taqdim etilmaydi. Ushbu holatda aloqa xizmatlari uchun to'lov tarif reja shartlariga asosan narxlanadi.                \n" +
                                "• Bir oylik abonent to'lovini to'lash uchun yetarli mablag' jamlanishi bilan u darhol yechiladi va bir oylik paketlar taqdim etiladi. Keyingi oylik abonent to'lovi yeсhilishi sanasi oxirgi abonent to’lovi yechilgan sanadan 1 oyga uzaytiriladi.                \n" +
                                "• Tarifda belgilangan oylik trafik qoldig'i amal qilish muddati tugashi bilan kuyadi, keyingi oyda taqdim etiladigan trafikga qo'shilmaydi.                \n" +
                                "• Tarif bo’yicha taqdim etilgan GB, daqiqa va SMSlarni faqatgina raqam faol holatda bo’lganida sarflash mumkin.                \n" +
                                "• Internetdan foydalanganda avval tarif bo'yicha, so'ng internet paketlar bo'yicha trafik sarflanadi.                \n" +
                                "• Tarifga kiritilgan oylik paket tugagandan so’ng uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi.                \n" +
                                "• Tarifga kiritilgan paketlar taqdim etilgungacha internet, SMS va qo’ng’iroqlar narxlanishi tarif bo’yicha standart narxlar asosida amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, trafik sizga taqdim etilganiga ishonch hosil qiling. Gigabaytlarni tekshirish uchun *103#, daqiqalar uchun - *106#, SMSlar uchun -*105#.                \n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun 421 so'm kunlik abonent to'lovi yechiladi. Shunda tarif bo’yicha oylik abonent to’lovi yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo'yicha yangi oylik limitlar taqdim etiladi. Sarflanmay qolgan avvalgi limitlar kuyadi. Keyingi abonent to'lovi yechilishi sanasi oxirgi oylik abonent to'lovi yechilgan kundan boshlab 1 oy muddatga suriladi. Agar oylik abonent to’lovi yechilishiga yetarli mablag’ bo’lmasa, u holda aloqa xizmatlaridan foydalanish tarifda belgilangan standart narxlarga asosan amalga oshiriladi. Agar raqam blok holatidan chiqarilgandan so’ng abonent hisobida abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, hisobdan mablag’ yechilmaydi va yangi trafik taqdim etilmaydi. Avvalgi oydan qolgan tarif reja trafiki mavjud bo’lsa, uning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.                \n" +
                                "• Tarif rejalarda balans nolga teng yoki qarz holatida bo'lganda ham, abonentlar barcha mobil raqamlardan qo’ng’iroqlar va SMS-xabarlar qabul qilishi mumkin                \n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.                \n" +
                                "• Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.                \n" +
                                "• Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.                \n" +
                                "• Mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun Abonent raqami faol holatida bo'lishi kerak."
                    )
                )
                list1.add(
                    User(
                        R.drawable.statussilver,
                        "*2*30#",
                        "Status Silver",
                        "95.000 sum",
                        "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar uchun to’lov tarif rejaga asosan yechiladi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «STATUS» tariflar turkumida abonent to'lovi har gal to’langanida «Beeline Music» va «Beeline TV»ning «TV kanallar», «Amediateka» bo’limlaridan oylik cheksiz foydalanish imkoni kiritilgan. Ilovalarni yuklab olish: «Beeline TV» - *6#, «Beeline Music» - *9#.\n" +
                                "\n" +
                                "**** VEON rouming hududiga quyidagi davlatlar kiradi: Rossiya, Qozog’iston, Qirg'iziston, Armaniston, Gruziya, Ukraina, Italiya, Bangladesh, Jazoir va Pokiston.\n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "• Oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Hisobda qarz bo’lsa yoki abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, oylik abonent to'lovi yechilmaydi, trafik taqdim etilmaydi va abonent hisobi qarzga kirmaydi. Bunday hollarda aloqa xizmatlaridan foydalanganda mablag’ asosiy balansingizdan tarif rejangizda belgilangan narxlarda yechiladi. Hisob yetarli miqdordagi summaga to'ldirilganidan so'ng oylik abonent to'lovi darhol yechilib, tarif bo’yicha SMS, GB va daqiqalar taqdim etiladi. Abonent to'lovi yechilishining navbatdagi sanasi abonent to'lovining oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.                \n" +
                                "• Tarif bo’yicha oylik abonent to'lovi o'z vaqtida to'langan taqdirda, barcha yo’nalishlarga berilgan internet-trafik qoldig’i bekor bo’lmaydi va keyingi oyga o'tadi. Shu bilan birga, keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi «Status Silver» tarifida- 60 GBgacha, «Status Gold» tarifida - 100 GBgacha, «Status Platinum» tarifida – 300 GBgacha bo’lishi mumkin. Agar abonent to'lovining navbatdagi yechilishi paytida hisobda yetarli mablag' bo’lmasa va shu sababli abonent to’lovi yechilmasa, trafik qoldig'i kuyib ketadi.                \n" +
                                "• Tarif bo’yicha taqdim etiladigan boshqa paketlar 1 oy tugaganda kuyadi va keyingi oyga o'tmaydi.                \n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun to'lov yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo’yicha paketlar taqdim etiladi. Blok holatiga tushirilishidan avval mavjud bo’lgan daqiqa va SMS trafiki kuyadi, MB esa yangi taqdim etilgan Mblarga qo’shiladi. Shunda keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi tarif bo’yicha taqdim etiladigan 2 oylik trafik hajmidan oshmaydi. Keyingi abonent to'lovi yechilishi sanasi oxirgi abonent to’lovi to’langan kundan boshlab 1 oy muddatga suriladi. Agar abonent hisobida tarif reja bo’yicha paketlar mavjud bo’lsa, ammo abonent to’lovi yechilishi uchun hisobda yetarli mablag’ mavjud bo’lmasa, raqam blok holatidan chiqarilgandan so’ng hisobdan mablag’ yechilmaydi, qoldiq paketlarning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.\n" +
                                "• Taqdim etilgan daqiqa, SMS va GB paketlaridan faqatgina raqam faol holatda bo’lganida foydalanish mumkin.                \n" +
                                "• Internetdan foydalanayotganda avval tarifdagi megabaytlar, so'ng Internet-paketdagi megabaytlar sarflanadi.                \n" +
                                "• Shuni ma’lum qilamizki, tarif bo'yicha internet-trafik, daqiqalar, SMS qoldig'i va boshqa qo'shimcha xizmatlar qoldig’i haqida xabarlar 06:00 dan 00:00 gacha yuboriladi.                \n" +
                                "• Bepul muloqot paketi tugagandan so’ng yoki taqdim etilmagan holatda uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, *103#/*105#/*106#/*112# terib, bonuslar taqdim etilganligiga ishonch hosil qiling.                \n" +
                                "• Ushbu tarifda «Erkin muloqot», «Mega hafta», «Do it» va «Hamma tarmoqda» xizmatlari amal qilmaydi.                \n" +
                                "• Agar «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, u holda boshqa tarifga o’tish Kompaniyaning ochiq ofislarida ariza taqdim etish orqali amalga oshiriladi. Bunda «oltin» raqamni narxi to’lanadi yoki oddiy raqamga almashtiriladi.  Agarda «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, va shu raqam bilan «Status» seriyasidagi tarifda 1 yildan ko’proq foydalanilgan bo’lsa, “oltin raqam”ni saqlab qolgan holda boshqa tariflarga o’tish imkoni mavjud.\n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)                \n" +
                                "• «Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo’ng’iroq qilish imkoniyatiga ega.                \n" +
                                "• Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to’ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.                \n" +
                                "• Xizmatlar sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi. Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Abonent to’lovi yechilganidan so’ng hisob to’g’ri tariflanishi uchun joriy sessiyani yakunlab, yangisini boshlash kerak.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• «Status Silver» tarif rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun abonent raqami faol holatida bo'lishi lozim."
                    )
                )
                list1.add(
                    User(
                        R.drawable.statusgold,
                        "*2*50#",
                        "Status Gold",
                        "135.000 sum",
                        "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar uchun to’lov tarif rejaga asosan yechiladi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «STATUS» tariflar turkumida abonent to'lovi har gal to’langanida «Beeline Music» va «Beeline TV»ning «TV kanallar», «Amediateka» bo’limlaridan oylik cheksiz foydalanish imkoni kiritilgan. Ilovalarni yuklab olish: «Beeline TV» - *6#, «Beeline Music» - *9#. \n" +
                                "\n" +
                                "**** VEON rouming hududiga quyidagi davlatlar kiradi: Rossiya, Qozog’iston, Qirg'iziston, Armaniston, Gruziya, Ukraina, Italiya, Bangladesh, Jazoir va Pokiston.\n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.      \n" +
                                "\n" +
                                "• Oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Hisobda qarz bo’lsa yoki abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, oylik abonent to'lovi yechilmaydi, trafik taqdim etilmaydi va abonent hisobi qarzga kirmaydi. Bunday hollarda aloqa xizmatlaridan foydalanganda mablag’ asosiy balansingizdan tarif rejangizda belgilangan narxlarda yechiladi. Hisob yetarli miqdordagi summaga to'ldirilganidan so'ng oylik abonent to'lovi darhol yechilib, tarif bo’yicha SMS, GB va daqiqalar taqdim etiladi. Abonent to'lovi yechilishining navbatdagi sanasi abonent to'lovining oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.                \n" +
                                "• Tarif bo’yicha oylik abonent to'lovi o'z vaqtida to'langan taqdirda, barcha yo’nalishlarga berilgan internet-trafik qoldig’i bekor bo’lmaydi va keyingi oyga o'tadi. Shu bilan birga, keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi «Status Silver» tarifida- 60 GBgacha, «Status Gold» tarifida - 100 GBgacha, «Status Platinum» tarifida – 300 GBgacha bo’lishi mumkin. Agar abonent to'lovining navbatdagi yechilishi paytida hisobda yetarli mablag' bo’lmasa va shu sababli abonent to’lovi yechilmasa, trafik qoldig'i kuyib ketadi.                \n" +
                                "• Tarif bo’yicha taqdim etiladigan boshqa paketlar 1 oy tugaganda kuyadi va keyingi oyga o'tmaydi.                \n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun to'lov yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo’yicha paketlar taqdim etiladi. Blok holatiga tushirilishidan avval mavjud bo’lgan daqiqa va SMS trafiki kuyadi, MB esa yangi taqdim etilgan Mblarga qo’shiladi. Shunda keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi tarif bo’yicha taqdim etiladigan 2 oylik trafik hajmidan oshmaydi. Keyingi abonent to'lovi yechilishi sanasi oxirgi abonent to’lovi to’langan kundan boshlab 1 oy muddatga suriladi. Agar abonent hisobida tarif reja bo’yicha paketlar mavjud bo’lsa, ammo abonent to’lovi yechilishi uchun hisobda yetarli mablag’ mavjud bo’lmasa, raqam blok holatidan chiqarilgandan so’ng hisobdan mablag’ yechilmaydi, qoldiq paketlarning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.\n" +
                                "• Taqdim etilgan daqiqa, SMS va GB paketlaridan faqatgina raqam faol holatda bo’lganida foydalanish mumkin.                \n" +
                                "• Internetdan foydalanayotganda avval tarifdagi megabaytlar, so'ng Internet-paketdagi megabaytlar sarflanadi.                \n" +
                                "• Shuni ma’lum qilamizki, tarif bo'yicha internet-trafik, daqiqalar, SMS qoldig'i va boshqa qo'shimcha xizmatlar qoldig’i haqida xabarlar 06:00 dan 00:00 gacha yuboriladi.                \n" +
                                "• Bepul muloqot paketi tugagandan so’ng yoki taqdim etilmagan holatda uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, *103#/*105#/*106#/*112# terib, bonuslar taqdim etilganligiga ishonch hosil qiling.                \n" +
                                "• Ushbu tarifda «Erkin muloqot», «Mega hafta», «Do it» va «Hamma tarmoqda» xizmatlari amal qilmaydi.                \n" +
                                "• Agar «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, u holda boshqa tarifga o’tish Kompaniyaning ochiq ofislarida ariza taqdim etish orqali amalga oshiriladi. Bunda «oltin» raqamni narxi to’lanadi yoki oddiy raqamga almashtiriladi.  Agarda «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, va shu raqam bilan «Status» seriyasidagi tarifda 1 yildan ko’proq foydalanilgan bo’lsa, “oltin raqam”ni saqlab qolgan holda boshqa tariflarga o’tish imkoni mavjud.\n" +
                                "• Abonent to'lovi yuqori bo'lgan tariflarga o'tilganda sarflanmay qolgan asosiy internet trafik qoldig'i saqlanib qolinadi va yangi tarif bo'yicha taqdim etiladigan asosiy internet trafikka qo'shiladi. Shuningdek amal qilish muddati so'nggi taqdim etilgan trafik muddatiga o'zgaradi. Tarif bo'yicha taqdim etilgan boshqa trafik (asosiy bo'lmagan GBlar, daqiqalar va SMSlar) qoldig'i kuyadi.\n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)                \n" +
                                "• «Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo’ng’iroq qilish imkoniyatiga ega.                \n" +
                                "• Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to’ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.                \n" +
                                "• Xizmatlar sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi. Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Abonent to’lovi yechilganidan so’ng hisob to’g’ri tariflanishi uchun joriy sessiyani yakunlab, yangisini boshlash kerak.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• «Status Gold» tarif rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun abonent raqami faol holatida bo'lishi lozim."
                    )
                )
                list1.add(
                    User(
                        R.drawable.statusplatina,
                        "*2*150#",
                        "Status Platina",
                        "200.000 sum",
                        "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar uchun to’lov tarif rejaga asosan yechiladi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi.\n" +
                                "\n" +
                                "** 2022 yil 17 martidan 1 iyuligacha \"Hammasi ZO'R\" va \"Status\" tariflar turkumida maxsus aksiya doirasida tungi bonus trafik taqdim etiladi. Tungi bonus trafiki soat 01.00 dan 08.00 gacha bo’lgan vaqtda sarflanadi. Aksiya amal qilish davrida tarif bo’yicha abonent to’lovi har gal to’langanida tungi bonus trafik beriladi va 1 oy amal qiladi. Amal qilish muddati tugaganidan so’ng sarflanmagan qoldiq kuyadi. Agar aksiya davrida tarif reja \"Hammasi ZO'R\" yoki \"Status\" tariflaridan biriga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi va yangi tarif bo’yicha tungi bonus trafiki taqdim etiladi. Boshqa tariflarga o’zgartirilsa avvalgi tarifdan qolgan tungi bonus trafik qoldig’i kuyadi.\n" +
                                "\n" +
                                "*** «STATUS» tariflar turkumida abonent to'lovi har gal to’langanida «Beeline Music» va «Beeline TV»ning «TV kanallar», «Amediateka» bo’limlaridan oylik cheksiz foydalanish imkoni kiritilgan. Ilovalarni yuklab olish: «Beeline TV» - *6#, «Beeline Music» - *9#.\n" +
                                "\n" +
                                "**** VEON rouming hududiga quyidagi davlatlar kiradi: Rossiya, Qozog’iston, Qirg'iziston, Armaniston, Gruziya, Ukraina, Italiya, Bangladesh, Jazoir va Pokiston.\n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "• Oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.                \n" +
                                "• Hisobda qarz bo’lsa yoki abonent to’lovi yechilishi uchun yetarli mablag’ bo’lmasa, oylik abonent to'lovi yechilmaydi, trafik taqdim etilmaydi va abonent hisobi qarzga kirmaydi. Bunday hollarda aloqa xizmatlaridan foydalanganda mablag’ asosiy balansingizdan tarif rejangizda belgilangan narxlarda yechiladi. Hisob yetarli miqdordagi summaga to'ldirilganidan so'ng oylik abonent to'lovi darhol yechilib, tarif bo’yicha SMS, GB va daqiqalar taqdim etiladi. Abonent to'lovi yechilishining navbatdagi sanasi abonent to'lovining oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.                \n" +
                                "• Tarif bo’yicha oylik abonent to'lovi o'z vaqtida to'langan taqdirda, barcha yo’nalishlarga berilgan internet-trafik qoldig’i bekor bo’lmaydi va keyingi oyga o'tadi. Shu bilan birga, keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi «Status Silver» tarifida- 60 GBgacha, «Status Gold» tarifida - 100 GBgacha, «Status Platinum» tarifida – 300 GBgacha bo’lishi mumkin. Agar abonent to'lovining navbatdagi yechilishi paytida hisobda yetarli mablag' bo’lmasa va shu sababli abonent to’lovi yechilmasa, trafik qoldig'i kuyib ketadi.                \n" +
                                "• Tarif bo’yicha taqdim etiladigan boshqa paketlar 1 oy tugaganda kuyadi va keyingi oyga o'tmaydi.                \n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda blok holati uchun to'lov yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi va tarif bo’yicha paketlar taqdim etiladi. Blok holatiga tushirilishidan avval mavjud bo’lgan daqiqa va SMS trafiki kuyadi, MB esa yangi taqdim etilgan Mblarga qo’shiladi. Shunda keyingi oyga o'tadigan va taqdim etiladigan trafikning umumiy hajmi tarif bo’yicha taqdim etiladigan 2 oylik trafik hajmidan oshmaydi. Keyingi abonent to'lovi yechilishi sanasi oxirgi abonent to’lovi to’langan kundan boshlab 1 oy muddatga suriladi. Agar abonent hisobida tarif reja bo’yicha paketlar mavjud bo’lsa, ammo abonent to’lovi yechilishi uchun hisobda yetarli mablag’ mavjud bo’lmasa, raqam blok holatidan chiqarilgandan so’ng hisobdan mablag’ yechilmaydi, qoldiq paketlarning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi.\n" +
                                "• Taqdim etilgan daqiqa, SMS va GB paketlaridan faqatgina raqam faol holatda bo’lganida foydalanish mumkin.                \n" +
                                "• Internetdan foydalanayotganda avval tarifdagi megabaytlar, so'ng Internet-paketdagi megabaytlar sarflanadi.                \n" +
                                "• Shuni ma’lum qilamizki, tarif bo'yicha internet-trafik, daqiqalar, SMS qoldig'i va boshqa qo'shimcha xizmatlar qoldig’i haqida xabarlar 06:00 dan 00:00 gacha yuboriladi.                \n" +
                                "• Bepul muloqot paketi tugagandan so’ng yoki taqdim etilmagan holatda uyali aloqa xizmatlaridan foydalanishingiz tarif rejangizda belgilangan narxlarga asosan amalga oshiriladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, *103#/*105#/*106#/*112# terib, bonuslar taqdim etilganligiga ishonch hosil qiling.                \n" +
                                "• Ushbu tarifda «Erkin muloqot», «Mega hafta», «Do it» va «Hamma tarmoqda» xizmatlari amal qilmaydi.                \n" +
                                "• Agar «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, u holda boshqa tarifga o’tish Kompaniyaning ochiq ofislarida ariza taqdim etish orqali amalga oshiriladi. Bunda «oltin» raqamni narxi to’lanadi yoki oddiy raqamga almashtiriladi.  Agarda «Status» seriyasidagi tariflarga ulanish paytida “oltin raqam” berilgan bo’lsa, va shu raqam bilan «Status» seriyasidagi tarifda 1 yildan ko’proq foydalanilgan bo’lsa, “oltin raqam”ni saqlab qolgan holda boshqa tariflarga o’tish imkoni mavjud.\n" +
                                "• «Status Platinum» tarif rejasi boshqa tarif rejalariga o'zgartirilganida tarifga kiritilgan daqiqa, GB, SMSlardan foydalanilmagan qoldiq kuyadi. Qo'shimcha xarid qilingan paketlar (GB, SMS) bo'yicha trafik saqlanib qoladi.   \n" +
                                "• O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Afg’oniston, Qirg’iziston, Turkmaniston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                \n" +
                                "• Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                \n" +
                                "• Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)                \n" +
                                "• «Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo’ng’iroq qilish imkoniyatiga ega.                \n" +
                                "• Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to’ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.                \n" +
                                "• Xizmatlar sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi. Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Abonent to’lovi yechilganidan so’ng hisob to’g’ri tariflanishi uchun joriy sessiyani yakunlab, yangisini boshlash kerak.                \n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.                \n" +
                                "• «Status Platinum» rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun abonent raqami faol holatida bo'lishi lozim."
                    )
                )
                list1.add(
                    User(
                        R.drawable.oson1,
                        "*2*01#",
                        "Oson 1",
                        "40.000 sum",
                        " Muhim! Abonent to‘lovi O‘zbekiston bo‘ylab faqat cheksiz qo‘ng‘iroqlarni o‘z ichiga oladi. Abonent to‘lovi undirilgandan so‘ng internetdan foydalanish yoki SMS yuborish 1 so‘mdan tariflanadi.\n" +
                                "Abonent to‘lovini yechib olish uchun mablag‘ yetishmagan taqdirda hisob-kitob 1 MB, MIN va SMS uchun 100 so‘mdan tarifikatsiya qilinadi.\n" +
                                "\n" +
                                "* O’zbekiston bo’ylab chiqish qo’ng’iroqlarining texnologik cheklovi abonent to’lovi yechilgan kundan boshlab oyiga 45 000 daqiqani tashkil etadi. Qo’ng’iroqlar bir oy davomida ushbu tarif bo'yicha limitdan oshsa, O’zbekiston bo’ylab qo’ng’iroqlar daqiqasi narxi 1 so'mdan hisoblanadi. Cheksiz qo’ng’iroqlar hisob-kitobi 1ta abonentga belgilanadi, konferens-aloqa vaqtidagi guruh qo’ng’iroqlarini hisobga olmaydi. Tarif reja bo'yicha berilgan daqiqalar limiti tugaganidan so’ng, O'zbekiston bo’ylab chiqish qo'ng'iroqlari daqiqasi 1 so'm narxlanadi.\n" +
                                "\n" +
                                "  Qo'shimcha xizmatlar bo’yicha taqdim etilgan daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "•   Keyingi oylik abonent to'lovi yechilish vaqti oxirgi yechilgan abonent to’lovi sanasidan 1 oylik oraliq bilan (oyning birinchi kuniga bog’lanmagan holda) amalga oshiriladi.\n" +
                                "•   Navbatdagi oylik abonent to'lovi soat 00:00 dan 06:00 gacha bo’lgan vaqtda hisobida yetarli mablag' bo’lgan holatda yechiladi. Abonent to’lovi yechilganidan so’ng O'zbekiston bo'yicha aloqa xizmatlaridan foydalanish 1 so'mdan tariflanadi.\n" +
                                "•   Hisobda yetarli mablag' bo'lmagan hollarda oylik abonent to'lovi olinmaydi va O'zbekiston bo'yicha aloqa xizmatlari 100 so'mdan tariflanadi.\n" +
                                "•   Hisobni yetarli mablag'ga to’ldirilganda tarif bo’yicha abonent to’lovi darhol yechiladi va navbatdagi oylik abonent to'lovi yechilishining sanasi oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.\n" +
                                "•   Raqam ma'muriy blok holatiga tushirilganda oylik abonent to'lovi yechilmaydi. Faqatgina «Raqamni abonent so'roviga asosan bloklash» xizmati uchun kuniga 421 so'mdan to'lov olinadi. Raqam blok holatidan chiqarilgandan so'ng abonent hisobida yetarli mablag' bo'lganda bir oylik abonent to'lovi yechiladi va navbatdagi oylik abonent to'lovi yechilishining sanasi oxirgi abonent to’lovi to’langan sanadan boshlab 1 oy muddat qilib belgilanadi. Yetarli mablag' bo'lmagan hollarda abonent to’lovi olinmaydi. Agar tarif bo’yicha taqdim etilgan daqiqalar qoldig’i mavjud bo’lsa ulardan amal qilish muddati tugaguncha foydalanish mumkin. Ushbu holda O'zbekiston bo'yicha internet, SMS xizmatlari hamda limitdan tashqari qo'ng'iroqlar 100 so'mdan tariflanadi.\n" +
                                "•   Shunda tarif bo’yicha taqdim etilgan daqiqalar qoldig’i mavjud bo’lsa ulardan amal qilish muddati tugaguncha foydalanish mumkin.\n" +
                                "•   \"OSON 1\" tarif rejasida \"Perezagruzka\" xizmatidan foydalanish mumkin. \"Perezagruzka\" xizmatining narxi - 0 so’m\n" +
                                "Xizmatni ulash uchun hisobda tarifga ulanish summasining minimal miqdori bo'lishi kerak.\n" +
                                "«Perezagruzka» xizmati ulanganda hisobdan tarif reja bo'yicha oylik abonent to'lovi yechiladi. So'ng tarifga kiritilgan oylik daqiqa paketining miqdori to’liq hajmda beriladi.\n" +
                                "«Perezagruzka» xizmati yoqilganidan so'ng, tarif bo'yicha avval taqdim etilgan daqiqalar paketining qoldig'i kuyadi.\n" +
                                "Yangi taqdim etilgan oylik trafikning amal qilish muddati va oylik abonent to'lovi yechilishining navbatdagi sanasi oylik abonent to'lovining oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.\n" +
                                "Xizmatga ulanish kodi - *5#\n" +
                                "•   «OSON 1» tarifida «DO IT», «Daqiqalar va megabaytlarni almashtirish» va «Muloqot ulashing!» xizmatlaridan foydalanish imkoniyati mavjud emas.\n" +
                                "•   «OSON 1»  tarif rejasiga o'tganda tarifga kiritilgan trafik qoldig'i kuyadi. Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Noto'g'ri tarifikatsiyani oldini olish uchun joriy Internet-sessiyani tugatib, keyin esa yangisini boshlash kerak.\n" +
                                "•   Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                                "Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa).\n" +
                                "Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                                "•   Shuni ma’lum qilamizki, tarif bo'yicha daqiqalar qoldig'i hamda boshqa qo'shimcha xizmatlar qoldig’i haqida xabarlar 06:00 dan 00:00 gacha yuboriladi.\n" +
                                "•   Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)   \n" +
                                "•   «Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo’ng’iroq qilish imkoniyatiga ega.\n" +
                                "•   Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to’ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.\n" +
                                "•   Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.\n" +
                                "•   Mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish uchun Abonent raqami faol holatida bo'lishi kerak."
                    )
                )
                list1.add(
                    User(
                        R.drawable.oson10,
                        "*110*61#",
                        "Oson 10",
                        "10.000 sum",
                        "Tarif bo'yicha taqdim etiladigan oylik Mb, daqiqa va SMSlar paketi faqatgina oylik abonent to'lovi to'langanda taqdim etiladi. Abonent pullik balansida yetarli mablag' bo'lmagan hollarda oylik abonent to'lovi olinmaydi va balans qarz holatiga o'tkazilmaydi.                            \n" +
                                "\n" +
                                "Keyingi oylik abonent to'lovi yechilishi va oylik trafik taqdim etilishi vaqti oxirgi yechilgan abonent to’lovi sanasidan 1 oylik oraliq bilan (oyning birinchi kuniga bog’lanmagan holda) amalga oshiriladi. Navbatdagi oylik abonent to'lovining yechilishi soat 00:00 dan 06:00 gacha bo’lgan vaqtda amalga oshiriladi.                            \n" +
                                "\n" +
                                "Navbatdagi oylik abonent to'lovi to'lanishi kerak bo'lgan sanada abonent balansida yetarli mablag' bo'lsa oylik abonent to'lovi yechiladi va bir oylik trafik paketi taqdim etiladi. Agarda abonent balansida bir oylik abonent to'lovi uchun yetarli mablag' bo'lmasa unda abonent to'lovi olinmaydi va aloqa xizmatlaridan foydalanish har bir MB/daqiqa/SMS uchun 100 so'mdan narxlanadi.                            \n" +
                                "\n" +
                                "Bir oylik abonent to'lovini to'lash  uchun yetarli mablag' abonent hisobida jamlanishi bilan u darhol yechiladi va bir oylik  trafik paketi taqdim etiladi.                            \n" +
                                "\n" +
                                "Taqdim etilgan paketlarda trafik tugaganidan so'ng aloqa xizmatlaridan foydalanish har bir MB/daqiqa/SMS uchun 10 so'mdan narxlanadi.                            \n" +
                                "\n" +
                                "Raqam ma'muriy blok holatiga tushirilganda oylik abonent to'lovi yechilmaydi. Faqatgina \"Raqamni abonent so'roviga asosan bloklash\" xizmati uchun kuniga 421 so'mdan to'lov olinadi. Raqam blok holatidan chiqarilgandan so'ng bir oylik abonent to'lovi abonent hisobida yetarli mablag' bo'lganda yechiladi. Ungacha aloqa xizmatlaridan foydalanish tarifda belgilangan shartlarga asosan amalga oshiriladi.                            \n" +
                                "\n" +
                                "Tarifda belgilangan bir kunlik yoki bir oylik paketlaridagi trafik qoldig'i amal qilish muddati tugashi bilan kuyadi, keyingi taqdim etiladigan paketlarning trafikiga qo'shilmaydi.                            \n" +
                                "\n" +
                                "Shuni ma’lum qilamizki, tarif bo'yicha daqiqalar va SMS qoldig'i hamda boshqa qo'shimcha xizmatlar qoldig’i haqida xabarlar 06:00 dan 00:00 gacha yuboriladi.                            \n" +
                                "\n" +
                                "Tarifda belgilangan bir oylik trafik paketini faqatgina raqam faol holatda bo’lganida sarflash mumkin.                            \n" +
                                "\n" +
                                "«OSON 10» tarif rejasi boshqa tarif rejalariga o'zgartirilganida tarif bo'yicha taqdim etilgan trafik paketining sarflanmagan qoldig'i kuyadi. Qo'shimcha xarid qilingan paketlar (daqiqa, MB, SMS) bo'yicha trafik saqlanib qolinadi.                            \n" +
                                "\n" +
                                "\"OSON 10\" tarif rejasida \"Perezagruzka\" xizmatidan foydalanish mumkin. \"Perezagruzka\" xizmatining narxi - 0 so’m\n" +
                                "Xizmatni ulash uchun hisobda tarifga ulanish summasining minimal miqdori bo'lishi kerak.\n" +
                                "«Perezagruzka» xizmati ulanganda hisobdan tarif reja bo'yicha oylik abonent to'lovi yechiladi. So'ng tarifga kiritilgan oylik MB, daqiqa va SMS paketlarining miqdori to’liq hajmda beriladi.\n" +
                                "«Perezagruzka» xizmati yoqilganidan so'ng, tarif bo'yicha avval taqdim etilgan daqiqalar va SMS paketlarning qoldig'i kuyadi.\n" +
                                "Yangi taqdim etilgan oylik trafikning amal qilish muddati va oylik abonent to'lovi yechilishining navbatdagi sanasi oylik abonent to'lovining oxirgi yechilishi sanasidan boshlab 1 oy muddat qilib belgilanadi.\n" +
                                "Xizmatga ulanish kodi - *5#                            \n" +
                                "\n" +
                                "«OSON 10» tarif rejasida «Muloqotni ulashing» xizmati orqali faqatgina O'zbekiston bo'yicha qo'ng'iroqlar uchun daqiqalar hamda Internet uchun Mblar qabul qilish mumkin.                            \n" +
                                "\n" +
                                "«OSON 10» tarif rejasida Beeline Club 2.0 sodiqlik dasturi va «Daqiqalarni Mbga almashtirish va aksincha» xizmati amal qilmaydi.\n" +
                                "\n" +
                                "\"OSON 10\" tarif rejasida \"Daqiqalarni Mbga almashtirish va aksincha\" xizmatidan foydalanib bo'lmaydi.                            \n" +
                                "\n" +
                                "O'zbekistonning chegara hududlarida (Qozog’iston, Tojikiston, Qirg’iziston, Turkmaniston, Afg’oniston bilan chegaralarda) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo’limida \"Beeline Uz\" tarmog’ini tanlab qo’yib, telefon ekranida ko’rsatilayotgan operator nomiga ahamiyat berishingizni so’raymiz                            \n" +
                                "\n" +
                                "Хalqaro aloqa uchun hisob-kitob xalqaro aloqa narxi va shahar telefonlariga chiquvchi qo’ng’iroq narxini qo'shgan holda amalga oshiriladi. Qo’ng’iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.                            \n" +
                                "\n" +
                                "Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)                            \n" +
                                "\n" +
                                "«Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo’ng’iroq qilish imkoniyatiga ega.                            \n" +
                                "\n" +
                                "Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to’ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.                            \n" +
                                "\n" +
                                "Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi.  Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.                          \n" +
                                "\n" +
                                "Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi. \n" +
                                "\n" +
                                "«OSON 10» tarif rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish imkoni, abonent raqami faollashtirilgan kundan boshlab 20 kun o'tgach amalga oshiriladi, shuningdek abonent raqami faol holatida bo'lishi lozim.                       "
                    )
                )
                list1.add(
                    User(
                        R.drawable.kunlik,
                        "*110*580#",
                        "Kunlik",
                        "600 sum",
                        "* Tarif reja bo’yicha taqdim etilgan daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "• Tarif bo'yicha taqdim etilgan megabayt va daqiqalar qoldig'i keyingi kun taqdim etilgan trafikka qo'shilmaydi. Kiritilgan trafik tugaganda xizmatlar uchun to'lov tarif rejaga asosan narxlanadi.\n" +
                                "\n" +
                                "• Abonent to'lovining yechilishi va kiritilgan trafikni taqdim etilishi soat 00:00 dan 06:00 gacha bo'lgan vaqtda amalga oshiriladi.\n" +
                                "\n" +
                                "• Abonent to'lovi yechilishi uchun hisobda yetarli mablag' bo'lmasa, u holda abonent to'lovi bir marta minusga yechiladi va megabayt, daqiqalar taqdim etiladi. Hisob minus holatida bo'lganda abonent to'lovi yechilmaydi va trafik taqdim etilmaydi. Hisob to'ldirilganda va raqam blok holatidan chiqqanda soat 00:00 dan 06:00 gacha vaqt oralig'ida abonent to'lovi yechilib, tarif bo'yicha MB va daqiqalar taqdim etiladi.\n" +
                                "\n" +
                                "• Tarifga kiritilgan MB va daqiqalar raqam faol holatda bo'lganda amal qiladi.\n" +
                                "\n" +
                                "• Agar raqamda hisob to'ldirilganda beriladigan bonus daqiqa va megabaytlar bor bo'lsa, \"Kunlik\" tarifiga o'tganda ushbu bonuslar kuyadi.\n" +
                                "\n" +
                                "• O'zbekistonning chegara hududlarida (Qozog'iston, Tojikiston, Afg'oniston, Turkmaniston, Qirg'iziston chegaralarida) Camel-rouming uchun mablag' yechilishini oldini olish uchun telefoningizning sozlamalar bo'limida \"Beeline Uz\" tarmog'ini tanlab qo'yib, telefon ekranida ko'rsatilayotgan operator nomiga ahamiyat berishingizni so'raymiz\n" +
                                "\n" +
                                "• Ushbu tarif rejada hisob nol yoki minus holatida bo'lganda ham tarmoq ichida va boshqa kompaniyalardan kiruvchi qo'ng'iroqlarni qabul qilish imkoni mavjud.\n" +
                                "\n" +
                                "• Qo'ng'iroqni qabul qiluvchi abonent tomonidan raqamni aniqlash xizmati, ovozli pochta xizmati, apparatida faksimil xizmati yoki modem ishga tushishi ulanish hisoblanadi.\n" +
                                "\n" +
                                "• Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto'g'ri prefiksdan kelgan kiruvchi qo'ng'iroqlar tariflanishining to'g'riligi yuzasidan javobgarlikni o'z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to'g'ri bo'ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile)\n" +
                                "\n" +
                                "• Internet-paket xarid qilinganda yoki tarif reja almashganda, internet-sessiya to'g'ri tariflanishi uchun joriy internet-sessiyani yakunlab, keyin yangidan boshlash lozim.\n" +
                                "\n" +
                                "• Barcha tariflarda ovozli xizmatlar uchun bir ulanishning davomiyligi 40 daqiqani tashkil etadi.\n" +
                                "\n" +
                                "• Raqam ma'muriy blok holatiga tushirilganda, kunlik abonent to'lovining narxi - 421 so'mni tashkil etadi.\n" +
                                "\n" +
                                "• «Elektron» hisobda mablag' to'liq sarflanib bo'lganda Operator Abonentga aloqa xizmatlarini cheklash, shu jumladan, tugallanmagan suhbatini uzish va uni blok holatiga o'tkazish huquqiga ega. Bunda Abonent ham Beeline abonentlaridan, ham boshqa mobil operatorlarining abonentlaridan qo'ng'iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga qo'ng'iroq qilish imkoniyatiga ega.\n" +
                                "\n" +
                                "• Bloklangan holatdan chiqish uchun (ya'ni pullik tranzaksiyalar – qo'ng'iroqlar, SMS yuborish, Internetdan foydalanish uchun) «elektron» hisobni ijobiy holatgacha to'ldirish kifoya. Agar ketma-ket 90 kun davomida Abonent «elektron» hisobidagi mablag' nol yoki noldan past bo'lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.\n" +
                                "\n" +
                                "• «Kunlik» tarif rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish imkoni, abonent raqami faollashtirilgan kundan boshlab 20 kun o'tgach amalga oshiriladi, shuningdek  abonent raqami faol holatida bo'lishi lozim.\n" +
                                "\n" +
                                "• Narxlar QQS bilan ko’rsatilgan."
                    )
                )
                list1.add(
                    User(
                        R.drawable.bolajon,
                        "*110*538#",
                        "Bolajon",
                        "11.500 sum",
                        "*Ushbu tarifda Internet-manbalardan foydalanish cheklangan. Foydalanish mumkin bo’lgan internet manbalar ro’yxati ushbu ilovada.\n" +
                                "*  Tarif reja bo’yicha taqdim etilgan daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                                "\n" +
                                "E`tibor bering:\n" +
                                "\n" +
                                "- Tarif bolalar uchun mo'ljallangan, ushbu tarifdagi raqamlar ota-onaning birini nomiga ro'yxatdan o'tkaziladi.\n" +
                                "- Ushbu tarifda quyidagi xizmatlar amal qilmaydi: xalqaro aloqa, xalqaro SMS xabarlar, rouming va Internet (ro'yxatda ko'rsatilgan manbalar bundan mustasno). Wi-Fi tarmog'idan foydalanilganda boshqa Internet-manbalar amal qiladi.\n" +
                                "- Ushbu tarifda quyidagi qo'shimcha xizmatlardan foydalanish mumkin: \"Raqamni aniqlash\", \"Xabardor bo'l\", \"Ishonchli to'lov\", \"Avtoto’lov\", \"Beeline Club\" bonusli dasturi va mahalliy SMS-paketlar\n" +
                                "- Tarif bo’yicha taqdim etilgan Internet-trafik, daqiqalar qoldig’i  haqida ma’lumot xabarlari 06:00 dan 00:00 gacha bo’lgan vaqt oralig’ida yuboriladi.\n" +
                                "- Tarif faqat O'zbekiston Respublikasi hududida amal qiladi va xalqaro roumingda ishlamaydi.\n" +
                                "- «Bolajon» tarif rejasida mobil qurilmaning IMEI-kodini ro'yxatdan o'tkazish imkoni, abonent raqami faollashtirilgan kundan boshlab 20 kun o'tgach amalga oshiriladi, shuningdek abonent raqami faol holatida bo'lishi lozim.\n" +
                                "- Narxlar QQS bilan ko’rsatilgan.\n" +
                                "\n"
                    )
                )
                list1.add(
                    User(
                        R.drawable.uydagidek,
                        "*110*66#",
                        "Uydagidek",
                        "55.000 sum",
                        "* Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi.\n" +
                                "\n" +
                                "•  Tarif rejalarga yangi ulanganda yoki tarifga o'tganda oylik abonent to'lovining yechilishi va tarif bo’yicha trafik taqdim etilishi tungi soat 00:00 dan ertalab 06:00 gacha bo’lgan vaqtda amalga oshiriladi. Navbatdagi oylik abonent to'lovi yechilishi va tarif bo'yicha trafik taqdim etilishi 1 oylik vaqt oralig'ida (oyning birinchi sanasiga bog’liq bo’lmagan holda) amalga oshiriladi.\n" +
                                "•  Tarif rejalarga ulanganda yoki o'tishda oylik abonent to'lovi va oylik trafikka ega paket to'liq hajmda, ya'ni, abonent to'lovining yechilishi va trafik taqdim etilishi oyning qolgan kunlaridan qat'iy nazar to'liq taqdim etiladi.\n" +
                                "•  Tarif rejalar bo'yicha oylik abonent to'lovining navbatdagi yechilishida, tizim oylik abonent to'lovining yechilishi uchun to'liq miqdor mavjudligini tekshiradi. Agar u mavjud bo'lsa - oylik abonent to'lovi yechiladi va oylik trafikli paket taqdim etiladi. Abonent hisobida yetarli mablag' bo'lmagan taqdirda, oylik abonent to'lovi qarzga yechilmaydi va mos ravishda, kiritilgan trafik paketi taqdim etilmaydi. Bunday holda, aloqa xizmatlaridan foydalanish uchun to'lov tarif shartlariga muvofiq standart tarifikatsiya bo'yicha amalga oshiriladi.\n" +
                                "•  Bir oylik abonent to'lovini to'lash uchun yetarli mablag' abonent hisobida bo'lishi bilan u darhol yechiladi va bir oylik  trafik paketi taqdim etiladi, keyingi oylik abonent to'lovi yechilishi sanasi oxirgi yechilgan paytidan boshlab 1 oy muddatiga suriladi.\n" +
                                "•  Tarifda belgilangan oylik paketlaridagi trafik qoldig'i amal qilish muddati tugashi bilan kuyadi va keyingi taqdim etiladigan paketlarning trafikiga qo'shilmaydi.\n" +
                                "•  Kiritilgan daqiqalar, SMS va MBlar paketi faqatgina abonent raqami faol holatda bo’lganida sarflashi mumkin.\n" +
                                "•  Kiritilgan trafik paketi taqdim etishidan oldin internet, qo'ng'iroqlar va SMSlar tarifning standart narxida yechiladi. Tarifga kiritilgan paketlardan foydalanishni boshlashdan oldin, megabaytlar uchun - *103#, daqiqalar uchun - *106#, SMSlar uchun -*105# kodlari orqali taqdim etilgan trafiklarni tekshirib olishingizni tavsiya qilamiz.\n" +
                                "•  Kiritilgan daqiqalar, SMS va MBlar paketi tugagandan so'ng, narxlanish belgilangan tariflarga muvofiq amalga oshiriladi.\n" +
                                "•  Xizmatni ulash uchun hisobda 55 250 so’m va \"Perezagruzka\" xizmatning narxi - 2000 so'm bo'lishi kerak. «Perezagruzka» xizmati ulangandan so'ng tarifga kiritilgan oylik daqiqa, Mb va SMS paketlarining miqdori to’liq hajmda beriladi. «Perezagruzka» xizmati yoqilganidan so'ng, tarif bo'yicha avval taqdim etilgan MB, daqiqalar va SMS paketlarning qoldig'i kuyadi.\n" +
                                "•  Raqam ma'muriy blok holatiga tushirilganda blok holati uchun 421 so'm kunlik abonent to'lovi yechiladi. Shu bilan birga tarif bo’yicha abonent to’lovi yechilmaydi. Raqam blok holatidan chiqarilganidan so’ng, agar abonent hisobida yetarli mablag’ mavjud bo’lsa, tarif rejaning oylik abonent to'lovi yechiladi. Keyingi abonent to'lovi yechilishi sanasi blok holatidan chiqarilgan kundan boshlab 1 oy muddatga suriladi. Agar oylik abonent to’lovi yechilishiga yetarli mablag’ bo’lmasa, u holda aloqa xizmatlaridan foydalanish tarifda belgilangan standart narxlarga asosan amalga oshiriladi. Agar abonent hisobida tarif reja bo’yicha paketlar mavjud bo’lsa, ammo abonent to’lovi yechilishi uchun hisobda yetarli mablag’ mavjud bo’lmasa, raqam blok holatidan chiqarilgandan so’ng hisobdan mablag’ yechilmaydi, qoldiq paketlarning amal qilish muddati o’zgarmaydi va taqdim etilgan kundan 1 oy o’tgandan so’ng kuyadi. \n" +
                                "•  Abonentning balansida 180 kun davomida mablag’ 0 yoki 0 dan past bo’lsa, ushbu holatda Operator abonentni aloqa xizmatlaridan foydalanishdan bir tomonlama va butunlay voz kechganligi deb qabul qiladi.\n" +
                                "•  Mazkur narxnomaning 3-sonli bo’lim ro’yxatida ko’rsatilgan davlat va ijtimoiy ahamiyatga ega bo’lgan veb-resurslardan foydalanish O’zbekiston hududida amaldagi tarif rejalari doirasida narxlanmaydi.\n" +
                                "•  Ushbu tarif rejalarda bo'lgan abonentlar, uyali aloqa operatorlari raqamlaridan kiruvchi qo'ng'iroqlar va SMSlarini hisobda hatto nol va salbiy bo’lgan taqdirda ham qabul qilish mumkin.\n" +
                                "•  O’zbekistonning chegara hududlarda Camel-rouming xizmati uchun ortiqcha mablag’ yechilmasligi uchun (Qozog'iston, Tojikiston, Qirg'iziston, Turkmaniston, Afg'oniston), telefon apparatingizdan «Beeline Uz» tarmoqni qo’l sozlama yordamida tanlab olishingiz lozim;\n" +
                                "•  Qo’ng’iroqni qabul qiluvchi abonent tomonidan apparatida faksimil xizmati, raqamni aniqlash xizmati, ovozli pochta xizmati, modem va hokazo qurilmalardan qabul qilingan qo’ng’iroqlarning qabul qilinishi fakti hisoblanadi;\n" +
                                "•  Barcha tarif rejalarda muloqot uchun maksimal suhbat davomliyligi 40 daqiqa etib belgilagan;\n" +
                                "•  Internet sessiya ochilishi bilan Kompaniyaning tizimi balansdagi pul mablag’larini zahira qiladi, ya’ni balansda qolgan pul mablag’i boshqa pulli xizmatlardan foydalanishni imkoniyati bo’lmasligi mumkin, hamda balans tekshirilganda tizim hisobni to’ldirish zarurligi haqida ma’lumot beradi.\n" +
                                "•  Agar abonentda internet-paket mavjud bo’lsa va sessiya uchun internet-paketda (2 Mbdan kam) yetarli Mb bo’lmasa, bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (unda pulli mablag’ mavjud bo’lgan holda). Hisobingizdan rezervlangan pul miqdori foydalangan internet trafikga bog’liq. Internet sessiya tugashi bilan harajat hisoblanadi va abonent hisobidan yechiladi, qolgan pul mablag’lari boshqa xizmatlarga foydalanish imkoniyati ochiladi.\n" +
                                "•  MChJ “Unitel” mijozlarni qo’llab-quvvatlash markaziga qo’ng’iroqlar «O’zbekistonga chiquvchi qo’ng’iroq» narxi bo’yicha baholanadi.  Bizga yozma ravishda Onlayn qo'llab-quvvatlash chati orqali, Telegram +998901850055 yoki 0611@beeline.uz elektron manziliga murojaat qiling va biz siz bilan imkon qadar tezroq bog'lanamiz!"
                    )
                )
            }
            2 ->{
                internetAdapter = InternetAdapter(list2,object : InternetAdapter.RvClick{
                    override fun onClick(user: User2, position: Int) {
                            findNavController().navigate(R.id.itemlarFragment)
                            Mydata.list2 = list2
                            Mydata.position2 = position
                            Mydata.harakat = 2
                    }

                    override fun onActionDial(position: Int, context: Context) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel: ${list2[position].raqam}")
                        context.startActivity(intent)
                    }

                })
                binding.rvObshiy.adapter = internetAdapter

                binding.imageBacObshiy2.visibility = View.INVISIBLE
                binding.imageBacObshiy.visibility = View.INVISIBLE
                binding.imageBacObshiy3.visibility = View.INVISIBLE
                binding.imageBacObshiy4.visibility = View.VISIBLE
                list2.add(
                    User2("1 gb"," *1*1#", "10.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("2 gb", "*1*2#","15.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("5 gb"," *1*5#", "25.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("10 gb", " *1*10#","45.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("20 gb", "*1*20#","65.000 sum"," Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("30 gb", "*1*30#","75.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("50 gb", "*1*50#","90.000 sum"," Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("75 gb", "*1*75#","110.000 sum","- Oylik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 30 kunni tashkil etadi. Internet-paket ulangan kundan boshlab 30 kun o'tgach yangi internet-paket yoqtirilmasa, ishlatilmagan trafik qoldig’i kuyadi.\n" +
                        "- Internet-paketning amal qilish muddati davomida yana qo'shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo'shilib, amal qilish muddati oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Oylik internet paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("1.5 gb", "*1*0*5#","10.000 sum"," Haftalik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 7 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("2.5 gb", "*1*0*6#","15.000 sum"," Haftalik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 7 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("5.0 gb", "*1*0*7#","20.000 sum"," Haftalik Internet-paketlarning amal qilish muddati paket yoqtirilgan kundan boshlab 7 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("100 mb", "*1*0*1#","2.000 sum","- Kunlik Internet-paketlarning amal qilish muddati ulanish vaqtidan boshlab (keyingi kunni oxirigacha) 1 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("200 mb", "*1*0*2#","3.000 sum","- Kunlik Internet-paketlarning amal qilish muddati ulanish vaqtidan boshlab (keyingi kunni oxirigacha) 1 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("500 mb", "*1*0*3#","5.000 sum","- Kunlik Internet-paketlarning amal qilish muddati ulanish vaqtidan boshlab (keyingi kunni oxirigacha) 1 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("4 gb", "*1*0*4#","10.000 sum","- Kunlik Internet-paketlarning amal qilish muddati ulanish vaqtidan boshlab (keyingi kunni oxirigacha) 1 kunni tashkil etadi.\n" +
                        "- Taqdim etilgan trafik tugaganida yoki paket muddati yakunlanganda, internet-trafikning keyingi sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "- Internet-paketlar ketma-ket ulanganida ularning trafiki qo’shiladi. Trafikning amal qilish muddati etib ulangan paketlarning ichida eng maksimal muddat belgilanadi.\n" +
                        "- Raqam faol bo’lmagan yoki blok holatiga tushirilgan davrda oxirgi ulangan internet paketning amal qilish muddati o’zgarmaydi.\n" +
                        "- Shuni ma’lum qilamizki, internet trafik, daqiqa va SMSlar qoldig’i va boshqa qo’shimcha xizmatlar bo’yicha ma’lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "- Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi.\n" +
                        "- Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "- Paketlar O'zbekiston Respublikasi hududida oldindan to’lov tizimidagi barcha jismoniy shaxslar uchun amal qiladi. Paketlar «Shifokor», «Bolajon», «ProInternet 1GB» va «ProInternet 3GB» tarif rejalari uchun amal qilmaydi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("5 gb 4g", "*110*58#","10.000 sum","«4G KUN» internet-paketi ulanish vaqtidan boshlab 1 kun davomida amal qiladi (keyingi kunni oxirigacha).\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari faqat 4G tarmog'ida amal qiladi va 2G/3G tarmoqlarida sarflanmaydi. 4G tarmog'iga ulanganda birinchi navbatda 4G internet-paketlarining trafiki sarflanadi.\n" +
                        "\n" +
                        "4G tarmog'idan 3G yoki 2G tarmog'iga o'tilganda, trafik qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi. 3G yoki 2G tarmog'iga ulanish 4G tarmog'i qoplanmagan hududlarda va ovozli qo'ng'iroq vaqtida amalga oshadi.\n" +
                        "\n" +
                        "4G internet-paketlari bo'yicha sarflanmagan megabaytlar qoldig'i amal qilish muddati tugagach kuyadi. 4G tarmog'ida internetdan keyingi foydalanish, qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi.\n" +
                        "\n" +
                        "4G internet-paketlarining amal qilish muddati tugamasidan avval yana 4G paket xarid qilinsa ushbu paketlarning trafiki qo'shiladi. Amal qilish muddati eski va yangi paketning ichida muddati eng kattasi bo'lganiga o'zgaradi.\n" +
                        "\n" +
                        "Abonent raqami faol bo'lmasligi yoki blok holatida bo'lishi 4G paketlarining amal qilish muddatiga ta'sir etmaydi.\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari oldindan to'lov tizimi abonentlari, jismoniy shaxslar uchun O'zbekiston Respublikasi hududida amal qiladi. Paketlar «ProInternet», «Bolajon» va «Shifokor» tariflaridagi abonentlar uchun amal qilmaydi.\n" +
                        "\n" +
                        "Sizning qurilmangiz 4G tarmog'ini qo'llab-quvvatlashini tekshirish uchun *24# kodini tering. Ushbu havola bo'yicha esa https://beeline.uz/uz/coverage-and-offices 4G tarmog'i qoplagan hududlarni tekshirishingiz mumkin.\n" +
                        "\n" +
                        "Shuni ma’lum qilamizki, internet trafik qoldig’i, daqiqa, SMS paketlar, tarif bo’yicha va boshqa qo’shimcha xizmatlar ma’lumoti 06:00 dan 00:00 gacha yuboriladi\n" +
                        "\n" +
                        "Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.\n" +
                        "\n" +
                        "Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi. Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "\n" +
                        "Internet tarmog'iga ulanish xizmati «Unitel» MChJning ommaviy oferta shartnomasiga asosan amalga oshiriladi.\n" +
                        "\n" +
                        "Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("15 gb 4g", "*110*62#","30.000 sum","«4G Hafta» internet-paketi yoqilgan paytdan boshlab 7 kun amal qiladi.\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari faqat 4G tarmog'ida amal qiladi va 2G/3G tarmoqlarida sarflanmaydi. 4G tarmog'iga ulanganda birinchi navbatda 4G internet-paketlarining trafiki sarflanadi.\n" +
                        "\n" +
                        "4G tarmog'idan 3G yoki 2G tarmog'iga o'tilganda, trafik qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi. 3G yoki 2G tarmog'iga ulanish 4G tarmog'i qoplanmagan hududlarda va ovozli qo'ng'iroq vaqtida amalga oshadi.\n" +
                        "\n" +
                        "4G internet-paketlari bo'yicha sarflanmagan megabaytlar qoldig'i amal qilish muddati tugagach kuyadi. 4G tarmog'ida internetdan keyingi foydalanish, qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi.\n" +
                        "\n" +
                        "4G internet-paketlarining amal qilish muddati tugamasidan avval yana 4G paket xarid qilinsa ushbu paketlarning trafiki qo'shiladi. Amal qilish muddati eski va yangi paketning ichida muddati eng kattasi bo'lganiga o'zgaradi.\n" +
                        "\n" +
                        "Abonent raqami faol bo'lmasligi yoki blok holatida bo'lishi 4G paketlarining amal qilish muddatiga ta'sir etmaydi.\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari oldindan to'lov tizimi abonentlari, jismoniy shaxslar uchun O'zbekiston Respublikasi hududida amal qiladi. Paketlar «ProInternet», «Bolajon» va «Shifokor» tariflaridagi abonentlar uchun amal qilmaydi.\n" +
                        "\n" +
                        "Sizning qurilmangiz 4G tarmog'ini qo'llab-quvvatlashini tekshirish uchun *24# kodini tering. Ushbu havola bo'yicha esa https://beeline.uz/uz/coverage-and-offices 4G tarmog'i qoplagan hududlarni tekshirishingiz mumkin.\n" +
                        "\n" +
                        "Shuni ma’lum qilamizki, internet trafik qoldig’i, daqiqa, SMS paketlar, tarif bo’yicha va boshqa qo’shimcha xizmatlar ma’lumoti 06:00 dan 00:00 gacha yuboriladi\n" +
                        "\n" +
                        "Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.\n" +
                        "\n" +
                        "Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi. Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "\n" +
                        "Internet tarmog'iga ulanish xizmati «Unitel» MChJning ommaviy oferta shartnomasiga asosan amalga oshiriladi.\n" +
                        "\n" +
                        "Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list2.add(
                    User2("30 gb 4g", "*110*59#","60.000 sum","«4G OY» internet-paketi yoqilgan paytdan boshlab 30 kun amal qiladi.\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari faqat 4G tarmog'ida amal qiladi va 2G/3G tarmoqlarida sarflanmaydi. 4G tarmog'iga ulanganda birinchi navbatda 4G internet-paketlarining trafiki sarflanadi.\n" +
                        "\n" +
                        "4G tarmog'idan 3G yoki 2G tarmog'iga o'tilganda, trafik qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi. 3G yoki 2G tarmog'iga ulanish 4G tarmog'i qoplanmagan hududlarda va ovozli qo'ng'iroq vaqtida amalga oshadi.\n" +
                        "\n" +
                        "4G internet-paketlari bo'yicha sarflanmagan megabaytlar qoldig'i amal qilish muddati tugagach kuyadi. 4G tarmog'ida internetdan keyingi foydalanish, qo'shimcha paket bo'lmaganda, asosiy balansdan sarflanadi.\n" +
                        "\n" +
                        "4G internet-paketlarining amal qilish muddati tugamasidan avval yana 4G paket xarid qilinsa ushbu paketlarning trafiki qo'shiladi. Amal qilish muddati eski va yangi paketning ichida muddati eng kattasi bo'lganiga o'zgaradi.\n" +
                        "\n" +
                        "Abonent raqami faol bo'lmasligi yoki blok holatida bo'lishi 4G paketlarining amal qilish muddatiga ta'sir etmaydi.\n" +
                        "\n" +
                        "«4G Kun», «4G Hafta» va «4G Oy» paketlari oldindan to'lov tizimi abonentlari, jismoniy shaxslar uchun O'zbekiston Respublikasi hududida amal qiladi. Paketlar «ProInternet», «Bolajon» va «Shifokor» tariflaridagi abonentlar uchun amal qilmaydi.\n" +
                        "\n" +
                        "Sizning qurilmangiz 4G tarmog'ini qo'llab-quvvatlashini tekshirish uchun *24# kodini tering. Ushbu havola bo'yicha esa https://beeline.uz/uz/coverage-and-offices 4G tarmog'i qoplagan hududlarni tekshirishingiz mumkin.\n" +
                        "\n" +
                        "Shuni ma’lum qilamizki, internet trafik qoldig’i, daqiqa, SMS paketlar, tarif bo’yicha va boshqa qo’shimcha xizmatlar ma’lumoti 06:00 dan 00:00 gacha yuboriladi\n" +
                        "\n" +
                        "Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.\n" +
                        "\n" +
                        "Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag'larini zaxiraga olib qo'yadi, ya'ni balansdagi pul mablag'lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to'ldirish zarurligi haqida xabar beradi. Agar abonentda internet-paket mavjud bo'lsa va sessiya uchun internet-paketda yetarli MB bo'lmasa (2 MBdan kam), bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (asosiy balansda mablag’ mavjud bo'lsa). Zaxiralangan pul mablag'lari summasi ishlatiladigan internet trafigi miqdoriga bog'liq bo'ladi. Internet sessiyasi tugashi bilan va ushbu sessiya uchun pul to'langach, abonent hisobidagi qolgan pul mablag'lari ishlatish uchun ochiladi.\n" +
                        "\n" +
                        "Internet tarmog'iga ulanish xizmati «Unitel» MChJning ommaviy oferta shartnomasiga asosan amalga oshiriladi.\n" +
                        "\n" +
                        "Barcha narxlar QQS bilan ko'rsatilgan.")
                )
            }
            3 ->{
                hizmatlarAdapter = HizmatlarAdapter(list3, object : HizmatlarAdapter.RvClick{
                    override fun onClick(list: ArrayList<User3>, position: Int) {
                            findNavController().navigate(R.id.itemlarFragment)
                            Mydata.list3 = list3
                            Mydata.position3 = position
                        Mydata.harakat = 3
                    }

                    override fun onActionDial(position: Int, context: Context) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel: ${list3[position].raqam}")
                        context.startActivity(intent)
                    }
                })
                binding.rvObshiy.adapter = hizmatlarAdapter

                binding.imageBacObshiy.visibility = View.INVISIBLE
                binding.imageBacObshiy2.visibility = View.VISIBLE
                binding.imageBacObshiy3.visibility = View.INVISIBLE
                binding.imageBacObshiy4.visibility = View.INVISIBLE
                list3.add(
                    User3("Aksiya 40gb", "*110*568#","30.000 sum","- «7 kunga 40 GB» paketi yoqilgan paytdan boshlab 7 kun amal qiladi va 7 kun o'tganidan so'ng, sarflanmagan trafik qoldig’i kuyadi.\n" +
                        "\n" +
                        "- Bir vaqtning o’zida 1 kunga 100 GB, 7 kunga 40 GB va 30 kunga 150 GB paketlaridan foydalanib bo’lmaydi. Biridan foydalanishdan avval boshqa paketni *110*560# kodi bilan o’chirish lozim. Paketlar o’chirilganida sarflanmay qolgan trafik kuyadi.\n" +
                        "\n" +
                        "- Aksiya bo’yicha xarid qilingan «7 kunga 40 GB» paket trafigi aksiyadan tashqari xarid qilingan boshqa internet-paketlarning trafikiga qo’shilmaydi va amal qilish muddatini o’zgartirmaydi.\n" +
                        "\n" +
                        "- «7 kunga 40 GB» paketi trafigi quyidagi internet-paketlardan va xizmatlardan so'ng sarflanadi: «DO IT», Welcome bonuslar, «Tungi 150 GB paketi 30 kunga».\n" +
                        "\n" +
                        "- Paket O'zbekiston Respublikasi hududida «Bolajon» tarifidan tashqari, haqi oldindan to'lanuvchi to'lov tizimli barcha tariflarda amal qiladi.\n" +
                        "\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list3.add(
                    User3("Aksiya 150gb","*110*562#", "90.000 sum","- «30 kunga 150 GB» paketi yoqilgan paytdan boshlab 30 kun amal qiladi va 30 kun o'tganidan so'ng, sarflanmagan trafik qoldig’i kuyadi.\n" +
                        "\n" +
                        "- Bir vaqtning o’zida «30 kunga 150 GB» va «1 kunga 100 GB» paketlaridan foydalanib bo’lmaydi. Biridan foydalanishdan avval ikkinchisini o’chirish lozim. Paketlar o’chirilganida sarflanmay qolgan trafik kuyadi.\n" +
                        "\n" +
                        "- Aksiya bo’yicha xarid qilingan «30 kunga 150 GB» paket trafigi aksiyadan tashqari xarid qilingan boshqa internet-paketlarning trafikiga qo’shilmaydi va amal qilish muddatini o’zgartirmaydi.\n" +
                        "\n" +
                        "- «30 kunga 150 GB» paketi trafigi quyidagi internet-paketlardan va xizmatlardan so'ng sarflanadi: «DO IT», Welcome bonuslar, «Tungi 150 GB paketi 30 kunga».\n" +
                        "\n" +
                        "- Paket O'zbekiston Respublikasi hududida «Bolajon» tarifidan tashqari, haqi oldindan to'lanuvchi to'lov tizimli barcha tariflarda amal qiladi.\n" +
                        "\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.")
                )
                list3.add(
                    User3("Aksiya 100gb"," *110*561#", "15.000 smm","- «1 kunga 100 GB» paketi amal qilish muddati ulanish vaqtidan boshlab 1 kunni (keyingi kunni oxirigacha) tashkil etadi va muddati tugaganidan so’ng sarflanmagan trafik qoldig’I kuyadi.\n" +
                        "\n" +
                        "- Bir vaqtning o’zida 1 kunga 100 GB va 30 kunga 150 GB paketlaridan foydalanib bo’lmaydi. Biridan foydalanishdan avval ikkinchisini o’chirish lozim. Paketlar o’chirilganida sarflanmay qolgan trafik kuyadi.\n" +
                        "\n" +
                        "- Aksiya bo’yicha xarid qilingan internet-paketlar trafigi aksiyadan tashqari xarid qilingan boshqa internet-paketlarning trafikiga qo’shilmaydi va amal qilish muddatini o’zgartirmaydi\n" +
                        "\n" +
                        "- «1 kunga 100 GB» paketi trafigi quyidagi internet-paketlardan va xizmatlardan so'ng sarflanadi: «DO IT», Welcome bonuslar, «Tungi 150 GB paketi 30 kunga».\n" +
                        "\n" +
                        "- E'tiboringizni qarating internet trafik qoldig'i, daqiqa, SMS paketlar, tarif bo'yicha va boshqa qo'shimcha xizmatlar ma'lumoti 06:00 dan 00:00 gacha yuboriladi.\n" +
                        "\n" +
                        "- Paket O'zbekiston Respublikasi hududida «Bolajon» tarifidan tashqari, haqi oldindan to'lanuvchi to'lov tizimli barcha tariflarda amal qiladi.\n" +
                        "\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan.",)
                )
                list3.add(
                    User3("Plus 7", "*110*63#","4.900 sum","300 min", "300 sms","•    «PLUS» paketlariga «Terminal»,«Tuner», «Electronics» tarif rejalaridan tashqari, oldindan to’lov tizimining qolgan barcha tarif rejalaridagi abonentlar uchun ulanish imkoniyati mavjud.\n" +
                        "•   Istalgan vaqtda «PLUS» paketlariga ulanishingiz va aloqa xizmatlaridan qulay narxlarda foydalanishingiz mumkin!    \n" +
                        "•   «PLUS 7» yoki «PLUS 14» paketlari qayta ulanganida avvalgi «PLUS» paketida sarflanmay qolgan qoldiq yangi ulangan «PLUS» paketining qoldig'iga qo'shilib ketadi. Avvalgi va yangi ulangan paketlarning qaysi birining amal qilish muddati kattaroq bo'lsa o'sha muddat qoldiq amal qilish muddati etib belgilanadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar amal qilish muddati tugaguncha, yangi «PLUS» paketi yoqtirilmasa, amal qilish muddati tugashi bilan ishlatilmagan trafik kuyadi.    \n" +
                        "•   Taqdim etilgan trafik tugaganida yoki paket muddati nihoyasiga yetganda, aloqa xizmatlaridan keyingi foydalanish tarif rejangiz shartlariga muvofiq narxlanadi.    \n" +
                        "•   «PLUS» paketlari amalda bo'lgan vaqti boshqa qo'shimcha paketlar va xizmatlarga ulansa bo'ladi. «PLUS» paketlarining trafiki boshqa xizmatlarning trafikiga qo'shilmaydi va amal qilish muddatiga ta'sir etmaydi.\n" +
                        "\n" +
                        "E'tibor bering:    \n" +
                        "\n" +
                        "•   Shuni ma’lum qilamizki, internet-trafik balansi, paketlar va tariflar uchun daqiqalar va SMS-xabarlar, shuningdek boshqa qo'shimcha xizmatlar uchun ma'lumot berish 06:00 dan 00:00 gacha qabul qilinadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar bo'yicha taqdim etilgan daqiqalar, SMS va MBlar faqat abonent raqami faol holatida amal qiladi.\n" +
                        "•   Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag‘larini zaxiraga olib qo‘yadi, ya'ni balansdagi pul mablag‘lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to‘lash zarurligi haqida xabar beradi.    \n" +
                        "•   Agar, abonentda Internet-paket bo‘lsa va sessiya uchun Internet-paketda MВ yetarli bo‘lmasa (2 MВdan kam), keyingi hisoblar asosiy balansdan amalga oshiriladi (unda pul mablag‘lari bo‘lgan holda)\n" +
                        "•   Zaxiralangan pul mablag‘lari summasi ishlatiladigan internet trafigi miqdoriga bog‘liq bo‘ladi. Internet sessiyasi tugashi bilan va uning uchun pul to‘langach, abonent hisobidagi qolgan pul mablag‘lari ishlatish uchun ochiladi.    \n" +
                        "•   PLUS paketlari bo'yicha daqiqalar amaldaligida tarif va boshqa xizmatlar bo'yicha ham daqiqalar mavjud bo'lsa avval oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan daqiqalar, so'ng PLUS paketlari bo'yicha daqiqalar, keyin qolgan daqiqalar sarflanadi.    \n" +
                        "•   PLUS paketlari bo'yicha MB amaldaligida tarif va boshqa xizmatlar bo'yicha ham internet trafik mavjud bo'lsa unda trafik sarflanishi quyidagicha bo'ladi: avval 4G paketlar trafiki, so'ng 4G bonuslar trafiki, IMO paketlari trafiki, \"Qadamlar uchun GIGlar\" aksiyasi trafiki, 10 MB va 30 MB mini paketlari, 30 MB internet paketi trafiki, so'ng oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan internet trafik, so'ng  PLUS paketlari bo'yicha MB, keyin esa qolgan Mblar sarflanadi.    \n" +
                        "•   PLUS paketlari bo'yicha SMSlar amaldagi tarif va boshqa xizmatlar bo'yicha ham SMS trafik mavjud bo'lsa avval oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan SMSlar, so'ng PLUS paketlari bo'yicha SMSlar, keyin qolgan SMSlar sarflanadi.    \n" +
                        "•   Internet xizmatlari sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi.    \n" +
                        "•   Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar faqat O‘zbekiston hududida amal qiladi.    \n" +
                        "•   Kontent xizmatlariga va axborot xizmatlariga bo'lgan qo'ng'iroqlar, «PLUS» turkumidagi daqiqa paketidan sarflanmaydi.    \n" +
                        "•   Aloqa telekommunikatsiya kanallarini eng optimal usulda ishlatish, shuningdek, Abonentning manfaatlarini ularning qurilmalaridan beruxsat foydalanishidan himoyalash maqsadida, Kompaniya ovozli xizmatlar uchun bir ulanishning davomiyligini 40 daqiqa etib belgilaydi.")
                )
                list3.add(
                    User3("Plus 14","*110*64#", "9.900 sum","1000 min", "1000 sms","•    «PLUS» paketlariga «Terminal»,«Tuner», «Electronics» tarif rejalaridan tashqari, oldindan to’lov tizimining qolgan barcha tarif rejalaridagi abonentlar uchun ulanish imkoniyati mavjud.\n" +
                        "•   Istalgan vaqtda «PLUS» paketlariga ulanishingiz va aloqa xizmatlaridan qulay narxlarda foydalanishingiz mumkin!    \n" +
                        "•   «PLUS 7» yoki «PLUS 14» paketlari qayta ulanganida avvalgi «PLUS» paketida sarflanmay qolgan qoldiq yangi ulangan «PLUS» paketining qoldig'iga qo'shilib ketadi. Avvalgi va yangi ulangan paketlarning qaysi birining amal qilish muddati kattaroq bo'lsa o'sha muddat qoldiq amal qilish muddati etib belgilanadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar amal qilish muddati tugaguncha, yangi «PLUS» paketi yoqtirilmasa, amal qilish muddati tugashi bilan ishlatilmagan trafik kuyadi.    \n" +
                        "•   Taqdim etilgan trafik tugaganida yoki paket muddati nihoyasiga yetganda, aloqa xizmatlaridan keyingi foydalanish tarif rejangiz shartlariga muvofiq narxlanadi.    \n" +
                        "•   «PLUS» paketlari amalda bo'lgan vaqti boshqa qo'shimcha paketlar va xizmatlarga ulansa bo'ladi. «PLUS» paketlarining trafiki boshqa xizmatlarning trafikiga qo'shilmaydi va amal qilish muddatiga ta'sir etmaydi.\n" +
                        "\n" +
                        "E'tibor bering:    \n" +
                        "\n" +
                        "•   Shuni ma’lum qilamizki, internet-trafik balansi, paketlar va tariflar uchun daqiqalar va SMS-xabarlar, shuningdek boshqa qo'shimcha xizmatlar uchun ma'lumot berish 06:00 dan 00:00 gacha qabul qilinadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar bo'yicha taqdim etilgan daqiqalar, SMS va MBlar faqat abonent raqami faol holatida amal qiladi.\n" +
                        "•   Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag‘larini zaxiraga olib qo‘yadi, ya'ni balansdagi pul mablag‘lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin va balans tekshirilganda tizim hisobni to‘lash zarurligi haqida xabar beradi.    \n" +
                        "•   Agar, abonentda Internet-paket bo‘lsa va sessiya uchun Internet-paketda MВ yetarli bo‘lmasa (2 MВdan kam), keyingi hisoblar asosiy balansdan amalga oshiriladi (unda pul mablag‘lari bo‘lgan holda)\n" +
                        "•   Zaxiralangan pul mablag‘lari summasi ishlatiladigan internet trafigi miqdoriga bog‘liq bo‘ladi. Internet sessiyasi tugashi bilan va uning uchun pul to‘langach, abonent hisobidagi qolgan pul mablag‘lari ishlatish uchun ochiladi.    \n" +
                        "•   PLUS paketlari bo'yicha daqiqalar amaldaligida tarif va boshqa xizmatlar bo'yicha ham daqiqalar mavjud bo'lsa avval oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan daqiqalar, so'ng PLUS paketlari bo'yicha daqiqalar, keyin qolgan daqiqalar sarflanadi.    \n" +
                        "•   PLUS paketlari bo'yicha MB amaldaligida tarif va boshqa xizmatlar bo'yicha ham internet trafik mavjud bo'lsa unda trafik sarflanishi quyidagicha bo'ladi: avval 4G paketlar trafiki, so'ng 4G bonuslar trafiki, IMO paketlari trafiki, \"Qadamlar uchun GIGlar\" aksiyasi trafiki, 10 MB va 30 MB mini paketlari, 30 MB internet paketi trafiki, so'ng oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan internet trafik, so'ng  PLUS paketlari bo'yicha MB, keyin esa qolgan Mblar sarflanadi.    \n" +
                        "•   PLUS paketlari bo'yicha SMSlar amaldalgida tarif va boshqa xizmatlar bo'yicha ham SMS trafik mavjud bo'lsa avval oylik abonent to'lovi bor tariflarda bir kunlik abonent to'lovi uchun taqdim etilgan SMSlar, so'ng PLUS paketlari bo'yicha SMSlar, keyin qolgan SMSlar sarflanadi.    \n" +
                        "•   Internet xizmatlari sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi.    \n" +
                        "•   Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.    \n" +
                        "•   «PLUS» turkumidagi paketlar faqat O‘zbekiston hududida amal qiladi.    \n" +
                        "•   Kontent xizmatlariga va axborot xizmatlariga bo'lgan qo'ng'iroqlar, «PLUS» turkumidagi daqiqa paketidan sarflanmaydi.    \n" +
                        "•   Aloqa telekommunikatsiya kanallarini eng optimal usulda ishlatish, shuningdek, Abonentning manfaatlarini ularning qurilmalaridan beruxsat foydalanishidan himoyalash maqsadida, Kompaniya ovozli xizmatlar uchun bir ulanishning davomiyligini 40 daqiqa etib belgilaydi.")
                )
                list3.add(
                    User3("Erkin Muloqot","*110*230#", "8.400 sum","500 min,200 mb","500 sms","Shuni ma’lum qilamizki, internet-trafik, tariflar uchun daqiqalar va SMS-xabarlar, shuningdek boshqa qo'shimcha xizmatlar qoldig’i haqida ma'lumot berish 06:00 dan 00:00 gacha qabul qilinadi.\n" +
                        "\n" +
                        "- To`lovning yechilishi va trafikning taqdim etilishi, ulanish sanasidan qat'iy nazar to`liq hajmda amal qiladi.\n" +
                        "\n" +
                        "- Abonent  to`lovi yechilishi uchun hisobingizda mablag` yetarlicha bo`lmasa, yakka tartibda salbiy tarafga abonent to`lovi yechiladi va daqiqa, SMS, MB taqdim etiladi. Hisobingizning salbiy holatida abonent to`lovi yechilmaydi va trafik taqdim etilmaydi.\n" +
                        "\n" +
                        "- Tarif reja doirasida taqdim etilgan daqiqa, SMS va MB paketlar, faqat abonent raqamining faol holatida amal qiladi.\n" +
                        "\n" +
                        "- Telefon raqamining ma’muriy bloklanishi holatida abonent to`lovi yechilmaydi. Blokdan chiqarilgandan so`ng 15 kunlik abonent to`lovi to`liq yechiladi va trafik taqdim etiladi. Bu holda keyingi abonent to`lovining yechilish sanasi blokdan chiqish kunidan boshlab 15 kunga suriladi. \n" +
                        "\n" +
                        "- Ijtimoiy tarmoqlar, IMO va messenjer uchun mo`ljallangan megabaytlar ma`lum IP manzillar to`plami (ushbu xizmatlarning ilovalarini o’ziga oladi) doirasida sarflanadi. Ijtimoiy tarmoq egalari tomonidan IP manzillar o`zgartirilgan holda, hamda Ijtimoiy tarmoqlar, IMO va messenjerga (bunga smartfon operatsion tizimi tomonidan ilovalar ishlatilganda sarf qilingan trafik kiradi) kirmagan trafik sarflanganda u asosiy internet paketi hisobiga yoki tarif rejangizga binoan sarflanadi.\n" +
                        "\n" +
                        "- Ijtimoiy tarmoqlar, IMO, va messenjer uchun taqdim etiladigan megabaytlar, proksi serverlari orqali ishlaydigan ilovalardan (shu qatorda VPN ham) foydalanilganda sarflanmaydi.\n" +
                        "\n" +
                        "- Ushbu tarifda «Erkin muloqot», «Mega hafta» va «Do It» xizmatlari amal qilmaydi.\n" +
                        "\n" +
                        "- Tarif reja bo’yicha taqdim etilgan SMS va daqiqalar kontent-xizmatlarga va axborot xizmatlariga sarflanmaydi. Bunday hollarda aloqa xizmatlaridan foydalanish pullik bo'ladi va mablag’ asosiy balansingizdan tarif rejada belgilangan narxda yechiladi.\n" +
                        "\n" +
                        "- Хalqaro aloqa qiymati hisob-kitobi xalqaro aloqa qiymati va shahar telefonlariga chiquvchi qo’ng’iroq qiymatini umumlashtirish yo’li bilan aniqlanadi\n" +
                        "\n" +
                        "- Sputnik aloqa xarajatlarni hisoblashda, shahar raqamlariga chiquvchi qo'ng'iroqlar narxini o'z ichiga olmaydi. \n" +
                        "\n" +
                        "- Mahalliy manzilga yo'naltirilgan chaqiriqlar deb uy mintaqasidagi shahar yoki boshqa mobil operatorlar raqamlari (jumladan, uy mintaqasidagi tarmoq ichidagi raqamlar)ga qayta yo‘llangan chaqiriqlar tushuniladi. Boshqa manzilga qayta yo‘llangan chaqiriqni qabul qiluvchi abonent suhbat uchun tarif rejasidan kelib chiqib, dastlabki chaqiriq unga boshqa raqam orqali emas, bevosita chiqqandek haq to‘laydi. \n" +
                        "\n" +
                        "- Internet paket xarid qilinganda yoki tarif reja o`zgartirilganda, internet sessiyalarning noto`g`ri tariflanishining oldini olish uchun, amal qilayotgan internet sessiyangizni,  yakunlashingiz va yangisini boshlashingiz  lozim. Xizmatlar sessiya davomida jo‘natilgan/qabul qilingan ma’lumotlar hajmi bo‘yicha tariflanadi. Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.\n" +
                        "\n" +
                        "- «Elektron» hisobda mablag’lar to’liq sarflanib bo’lganda Operator Abonentga aloqa xizmatlarini cheklash, jumladan tugallanmagan suhbatini uzish va uni bloklangan holatga o’tkazish huquqiga ega. Bunda, Abonent ham tarmoq abonentlaridan, ham boshqa mobil operatorlari abonentlaridan qo’ng’iroqlar va SMS qabul qilish, shuningdek 0611 raqamiga ma’lumot xizmatiga qo’ng’iroq qilish imkoniyatiga ega. \n" +
                        "\n" +
                        "- Bloklangan holatdan chiqish uchun (ya’ni pullik tranzaksiyalar – qo’ng’iroqlar, SMS yuborish, Internetdan foydalanish va b.) «elektron» hisobni ijobiy ko’rsatkichgacha to’ldirish kifoya. Agar ketma-ket 90 kun ichida Abonent «elektron» hisobidagi mablag’ nol yoki noldan past bo’lsa, Operator uchun bu abonentning aloqa xizmatlaridan foydalanishdan voz kechganligini anglatadi.\n" +
                        "\n" +
                        "- Aloqa telekommunikatsiya kanallarini eng optimal usulda ishlatish, shuningdek, Abonentning manfaatlarini ularning qurilmalaridan beruxsat foydalanishidan himoyalash maqsadida, Kompaniya ovozli xizmatlar uchun bir ulanishning davomiyligini 40 daqiqa etib belgilaydi. \n" +
                        "\n" +
                        "- Kompaniya boshqa mobil operatorlarning aniqlanmagan raqamidan va noto’g’ri prefiksdan kelgan kiruvchi qo’ng’iroqlar tariflanishining to’g’riligi yuzasidan javobgarlikni o’z zimmasiga olmaydi. Tariflash shahar raqamlari va boshqa mobil operatorlarining raqamlarini xalqaro formatda terishda to’g’ri bo’ladi (+99893, +99894xxx-xxxx Ucell; +99897xxx-xxxx Mobiuz; +99899xxx-xxxx UzMobile GSM; +99895xxx-xxxx UzMobile CDMA; +99898xxx-xxxx Perfectum Mobile). \n" +
                        "\n" +
                        "- Tarif reja o`zgartirilganida unga kiruvchi trafik (daqiqa/MB/SMS) kuyib ketadi. Xarid qilingan internet va SMS paketlari bo`yicha trafik saqlanadi.\n" +
                        "\n" +
                        "- Narxlar QQS bilan ko’rsatilgan\n" +
                        "Siz muddatidan avval, «Perezagruzka» xizmatini ulab daqiqa, SMS va MB paketlariga ega bo’lishingiz mumkin.\n" +
                        "\n" +
                        "\"Bir Oy\", \"Erkin muloqot\", \"Bravo Mix\", \"Click+\" va \"XIT\", «XIT+» turkumidagi tariflar uchun \"Perezagruzka\" xizmat narxi - 2000 so'm.\n" +
                        "\n" +
                        "Boshqa tarif rejalar uchun xizmat narxi - 0 so'm.\n" +
                        "\n" +
                        "Ulanish uchun hisobdagi minimal mablag' miqdori - 15 750 so’m.\n" +
                        "\n" +
                        "«Erkin muloqot» tarif rejasida «Perezagruzka» xizmatni ulaganda, tarif reja bo’yicha abonent to'lov - 13 500 so’m, hamda xizmat uchun 2000 so'm yechiladi va daqiqa, SMS va MB paketlarining miqdori to’liq hajmda beriladi.\n" +
                        "\n" +
                        "Xizmat yoqilganidan so'ng, avvalgi ya’ni oxirgi taqdim etilgan daqiqalar, SMS va MB paketlarning qoldig'i barchasi kuyadi.\n" +
                        "\n" +
                        "Keyingi abonent to'lov yechilishi va trafik taqdim etish vaqti 15 kun oralig’i bilan, ya’ni oxirgi yechilgan abonent to’lov sanasi asosida amalga oshiriladi.\n" +
                        "\n" +
                        "«Perezagruzka» xizmati «Status», «Status+» turkumidagi tariflarda, «XIT», «XIT+» turkumidagi tariflarida, shuningdek «Bir Oy», «Erkin muloqot», «Bravo MIX» va «Click+» tarif rejalarida amal qiladi.\n" +
                        "\n" +
                        "Xizmatga ulanish kodi: *5#.")
                )
                list3.add(
                    User3("Erkin Muloqot+","*110*225#", "12.600 sum","- Shuni ma’lum qilamizki, internet-trafik balansi, paketlar va tariflar uchun daqiqalar va SMS-xabarlar, shuningdek boshqa qo'shimcha xizmatlar uchun ma'lumot berish 06:00 dan 00:00 gacha qabul qilinadi.\n" +
                        "- Abonentda «Erkin muloqot» xizmatlari mavjud bo’lsa va «SMS non-stop» xizmati faollashtirilgan bo’lsa, barcha SMS lar jamlanadi va SMS ning amal qilish muddati bir kunga qadar qisqartiriladi. «SMS non-stop» xizmati o'chirilganda, «Erkin muloqot» va «SMS non-stop» xizmatlari bo’yicha taqdim etilgan SMSlar, joriy kunning oxirigacha amal qiladi.\n" +
                        "- Abonentda «Erkin muloqot » xizmatlari mavjud bo’lganda va «Mega hafta» xizmatlari faollashtirilganda «Erkin muloqot» xizmatlariga taqdim qilingan barcha bonuslar kuyadi.\n" +
                        "- Messenjerlar uchun mo’ljallangan MB, faqat  Viber, Telegram, Whatsapp messenjerlari, va Facebook.com, Odnoklassniki.ru, TAS-IX saytlari uchun mo’ljallangan.\n" +
                        "- Ijtimoiy tarmoqlarga va Messenjerlarga taqdim etilgan Internet trafik, ma'lum IP-manzillar doirasida sarflanadi.\n" +
                        "- Ijtimoiy tarmoqlar va Messenjerlarning IP manzili o'zgarsa, internetdan foydalanilgan mablag' hisobdan yoki boshqa paketlardan yechiladi.\n" +
                        "- Messenjerlardan tashqari foydalanadigan trafik (ushbu toifaga smartfon sistemasidagi operatsion tizim trafiki ilovalar orqali foydalanganda paydo bo'ladi) sizning tarif rejangizga muvofiq narxlanadi.\n" +
                        "- Messenjerlar uchun mo’ljallangan MB, proksi server (shu jumladan VPN) orqali foydalanilgan ilovalarda sarflanmaydi.\n" +
                        "Daqiqa va MB *100# \n" +
                        "SMS *105#\n" +
                        "Facebook, Odnoklassniki, TAS-IX, Telegram, WhatsApp va Viber *109#")
                )
                list3.add(
                    User3("Beeline app","", "1.300/kun 25.000/oy","- Xizmat oldindan to'lov tizimidagi tarif rejalari abonentlari uchun amal qiladi.\n" +
                        "- «Beeline App» bo’yicha cheksiz va tariflanmaydigan trafik aksiyasi brauzerlar orqali, proksi serverlar (shu jumladan VPN) orqali foydalanganda, boshqa saytlar va internet manbalarida bo’lgan rasmlar, videolar, o'yinlar va boshqa media kontentlarga amal qilmaydi.\n" +
                        "- Proksi-serverlar (shu jumladan VPN) orqali o'tadigan brauzerlardan foydalanganda, «Beeline App» xizmatining ilovasida birinchi marta ro'yxatdan o’tish imkoniyati bo’lmasligi mumkin, shuningdek imtiyozli obuna narxi ham.\n" +
                        "- Amal qilish muddati: abonent hisobidan mablag' yechilgan kundan boshlab 1 kun. Kunlik obuna uchun  mablag' har kuni soat 00:00 dan 06:00 gacha bo'lgan vaqtda yechiladi.\n" +
                        "- Obuna bir marta faollashtirilishi kerak, shundan so'ng u har kuni avtomatik ravishda uzaytiriladi.\n" +
                        "- Cheksiz va narxlanmaydigan trafik (promo-muddatdan tashqari) obuna to'lovi muvaffaqiyatli hisobdan yechilgandan so'ng taqdim etiladi.\n" +
                        "- Pullik obuna o'chirilgandan so'ng xizmatdan foydalanish va yuklab olingan o'yinlardan oflayn rejimida foydalanish imkoni bo'lmaydi.\n" +
                        "- Onlayn o'yinlar uchun internet tarmog’iga kirish imkoniyatiga ega bo'lish kerak.\n" +
                        "- Agar abonent raqami 60 kundan ortiq blok holatida bo'lsa, xizmat avtomatik ravishda o'chiriladi.\n" +
                        "- O'yinni o'rnatayotganda mobil qurilmangizning operatsion tizimini yangilash kerak bo'lishi mumkin. To'lov sizning tarif rejangiz shartlariga muvofiq yechiladi.\n" +
                        "- Xizmat «Lux Content» XK tomonidan taqdim etiladi.\n" +
                        "- Barcha narxlar QQS bilan ko'rsatilgan. Yosh chegarasi: 18+\n" +
                        "\n" +
                        "«Beeline App» xizmatining Taqdim etish qoidalari va Ko'p so'raladigan savollar haqida tanishib chiqishingiz mumkin.")
                )
                list3.add(
                    User3("Beeline Visa","", "10.000 sum","Beeline Uzbekistan Ravnaq Bank bilan hamkorlikda «Beeline VISA» xizmatini ishga tushiradi, bu esa Beeline abonentlariga uydan chiqmagan holda VISA virtual kartasini ochish orqali bank xizmatidan foydalanish imkonini beradi.\n" +
                        "\n" +
                        "Beeline VISA - bu internet xaridlar uchun mo'ljallangan karta.\n" +
                        "\n" +
                        "Internetda xavfsiz va ishonchli xaridlardan bahramand bo'lish uchun Visa virtual kartasini yarating\n" +
                        "Virtual karta oddiy to'lov kartasining barcha xususiyatlariga ega\n" +
                        "\n" +
                        "Siz butun dunyo bo’ylab onlayn xaridlarni amalga oshirishingiz, pullik xizmatlar obunasi uchun to’lovlarni amalga oshirishingiz, pullik funksiyalarni xarid qilish orqali telefoningiz yoki shaxsiy kompyuteringizdagi ilovalarning imkoniyatlarini kengaytirishingiz mumkin.\n" +
                        "Shuningdek, virtual kartadan bank kartalari ma’lumotlarini talab qiladigan xizmatlarga ro’yxatdan o’tkazish uchun foydalanishingiz mumkin.\n" +
                        "Kartani ochish uchun komissiya narxi - 10 000 so'm\n" +
                        "- Beeline Uzbekistan ilovasiga kiring\n" +
                        "- Beeline VISA bo'limini oching\n" +
                        "- Shartlar bilan tanishib chiqing va kartani chiqarish tugmasini bosing.\n" +
                        "\n" +
                        "Beeline Uzbekistan ilovasini o'rnatish uchun telefondan *1# ni tering yoki quyidagi elektron manzilga o’ting:\n" +
                        "\n" +
                        "App Store\n" +
                        "\n" +
                        "Play Market\n" +
                        "\n" +
                        "HUAWEI AppGallery\n" +
                        "\n" +
                        "Android uchun Beeline Uzbekistan apk ni quyidagi elektron manzil orqali yuklab olish mumkin.\n" +
                        " \n" +
                        "Beeline Visa xizmati bo'yicha oferta haqida tanishib o'ting.")
                )
                list3.add(
                    User3("Imo 20 paketi","*110*45#", "5.000","20 soat","«IMO 20» internet paketi oldindan to'lov tizimining barcha tariflari uchun amal qiladi («Bolajon» tarifida va «ProInternet» tarif rejalari turkumidan tashqari).\n" +
                        "\n" +
                        "«IMO 20» internet paketi bo'yicha «IMO» ilovasi orqali ovozli qo'ng'iroqlar uchun 600 Mb yoki 20 soat taqdim etiladi (IMO statistikasi bo’yicha 1 daqiqa uchun 0.5 Mb hisoblanadi).\n" +
                        "\n" +
                        "«IMO 20» internet paketi bo'yicha taqdim etilgan trafik faqat «IMO» ilovasi orqali amalga oshirilgan ovozli qo'ng'iroqlar uchun sarflanadi\n" +
                        "\n" +
                        "«IMO 20» internet paketi bilan birga tarif bo'yicha yoki boshqa internet paketlar orqali taqdim etilgan Mblar bo'lgan vaqtda «IMO» ilovasi orqali qo'ng'iroqlar amalga oshirilsa avval «IMO 20» internet paketi bo'yicha olingan Mblar, so'ng tarif va boshqa internet paketlarning Mblari sarflanadi.\n" +
                        "\n" +
                        "«IMO 20» internet paketi faqat abonent raqami faol holatida amal qiladi «IMO 20» Internet paketining amal qilish muddati - ulangan kundan boshlab 30 kun.\n" +
                        "\n" +
                        "«IMO 20» Internet paketining amal qilish muddati davomida yana qo’shimcha paket xarid qilinsa, barcha sarflanmagan trafik hajmi qo’shiladi va oxirgi yoqtirilgan paket kunidan boshlab 30 kunga uzaytiriladi.\n" +
                        "\n" +
                        "«IMO 20» Internet paketi ulangan kunidan 30 kun o'tgach ishlatilmagan trafik kuyadi.\n" +
                        "\n" +
                        "Taqdim etilgan trafik tugaganida yoki paket muddati nihoyasiga yetganidan keyin «IMO» ilovasi orqali qo'ng'iroqlar amalga oshirilsa, internet trafikning sarflanishi tarif rejangiz shartlariga muvofiq narxlanadi.\n" +
                        "\n" +
                        "«IMO 20» Internet paketi bo'yicha taqdim etilgan Mblar boshqa internet paketlarning Mblariga qo'shilmaydi va ularning amal qilish muddatiga ta'sir qilmaydi.\n" +
                        "\n" +
                        "«IMO 20» Internet paketi bo'yicha taqdim etilgan Mblar proksi-serverlar (jumladan VPN) orqali ishlaydigan ilovadan foydalanganda sarflanmaydi va muayyan IP-manzillar doirasida sarf etiladi.\n" +
                        "\n" +
                        "«IMO 20» Internet paketi faqat O‘zbekiston hududida amal qiladi.\n" +
                        "\n" +
                        "Shuni ma’lum qilamizki, internet trafik qoldig’i, daqiqa, SMS paketlar, tarif bo’yicha va boshqa qo’shimcha xizmatlar ma’lumoti 06:00 dan 00:00 gacha yetkaziladi. Internet sessiyasi ochilganda, Kompaniya tizimi balansdagi pul mablag‘larini zaxiraga olib qo‘yadi, ya'ni balansdagi pul mablag‘lari boshqa pullik xizmatlardan foydalanish uchun yopilishi mumkin.\n" +
                        "\n" +
                        "Agar abonentda internet-paket mavjud bo’lsa va sessiya uchun internet-paketda (2 MBdan kam) yetarli Mb bo’lmasa, bu holda keyingi hisoblashlar asosiy balansdan amalga oshiriladi (unda pullik mablag’ mavjud bo’lgan holda). Zaxiralangan pul mablag‘lari miqdori ishlatiladigan internet trafigi miqdoriga bog‘liq bo‘ladi. Internet sessiyasi tugashi bilan va uning uchun pul to‘langach, abonent hisobidagi qolgan pul mablag‘lari ishlatish uchun ochiladi.\n" +
                        "\n" +
                        "Xizmatlar sessiya davomida jo‘natilgan / qabul qilingan ma’lumotlar hajmi bo‘yicha baholanadi.\n" +
                        "\n" +
                        "Foydalanilgan trafik hajmi yuqori tomonga 16 KB aniqlikda yaxlitlanadi.")
                )
            }
            4 ->{
                smsAdapter = SmsAdapter(list4, object : SmsAdapter.RvClick{
                    override fun onClick(user: User4, position: Int) {
                            findNavController().navigate(R.id.itemlarFragment)
                            Mydata.list4 = list4
                            Mydata.position4 = position
                        Mydata.harakat = 4
                    }

                    override fun onActionDial(position: Int, context: Context) {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel: ${list4[position].raqam}")
                        context.startActivity(intent)
                    }
                })
                binding.rvObshiy.adapter = smsAdapter

                binding.imageBacObshiy.visibility = View.INVISIBLE
                binding.imageBacObshiy2.visibility = View.INVISIBLE
                binding.imageBacObshiy3.visibility = View.VISIBLE
                binding.imageBacObshiy4.visibility = View.INVISIBLE

                list4.add(
                    User4("Paket 100 sms","*110*06#", "3.500 sum","Mahalliy SMS-paketlar O'zbekistonning barcha uyali aloqa operatorlariga jo'natilishi mumkin.\n" +
                        "\n" +
                        "SMS bilan siz quyidagilarni amalga oshirishingiz mumkin:\n" +
                        "\n" +
                        "bir vaqtning o'zida bir necha kishiga muhim ma'lumotlarni yuborish;\n" +
                        "noqulay bo’lgan vaziyatda  javob bering;\n" +
                        "o'zingizni aloqada cheklamasdan pulni tejash.\n" +
                        "100, 500, 1000 SMS dan tashkil topgan Mahalliy SMS-paketlarni ulashingiz mumkin.\n" +
                        "\n" +
                        "Xizmat,  barcha haqi keyin to'lanadigan billing tizimi (POSTPAID) tarif rejalari uchun amal qiladi.\n" +
                        "\n" +
                        "«Beeline Business» ning yangi SMS-paketlari bilan yanada ko'proq muloqot qiling!\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Bitta paketning amal qilish muddati – ulangan kundan boshlab oy oxirigacha;\n" +
                        "Sarflanmagan SMS lar keyingi oyga o'tmaydi;\n" +
                        "Oy davomida abonent bitta paket xarid qilishi mumkin;\n" +
                        "Tarif reja o’zgartirilganida paketlar saqlanadi;\n" +
                        "Kiritilgan SMS lar soni tugaganda yoki paketning amal qilish muddati tugaganidan keyin har 1 SMS tarif reja asosida hisoblanadi;\n" +
                        "Qoldiq tekshirilganda qolgan trafik haqida ma`lumot donalarda ko’rsatiladi;\n" +
                        "Mahalliy SMS to'plamlari faqat O'zbekistonda amal qiladi;\n" +
                        "Kiritilgan SMS lar va xizmat uchun mablag' belgilanishi ulanish kuniga  va oy oxirigacha qolgan kunlar soniga asoslanib belgilanadi;\n" +
                        "Xizmatni yoqish yoki o’chirish uchun Korporativ Abonentlarga xizmat ko’rsatish bo’limiga yozma ko’rinishda ariza berish, 0611@beeline.uz manziliga jo’natish lozim;\n" +
                        "Barcha narxlar QQS hisobga olinmagan holda ko'rsatilgan.")
                )
                list4.add(
                    User4("Paket 500 sms", "*110*06#","11.000 sum","Mahalliy SMS-paketlar O'zbekistonning barcha uyali aloqa operatorlariga jo'natilishi mumkin.\n" +
                        "\n" +
                        "SMS bilan siz quyidagilarni amalga oshirishingiz mumkin:\n" +
                        "\n" +
                        "bir vaqtning o'zida bir necha kishiga muhim ma'lumotlarni yuborish;\n" +
                        "noqulay bo’lgan vaziyatda  javob bering;\n" +
                        "o'zingizni aloqada cheklamasdan pulni tejash.\n" +
                        "100, 500, 1000 SMS dan tashkil topgan Mahalliy SMS-paketlarni ulashingiz mumkin.\n" +
                        "\n" +
                        "Xizmat,  barcha haqi keyin to'lanadigan billing tizimi (POSTPAID) tarif rejalari uchun amal qiladi.\n" +
                        "\n" +
                        "«Beeline Business» ning yangi SMS-paketlari bilan yanada ko'proq muloqot qiling!\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Bitta paketning amal qilish muddati – ulangan kundan boshlab oy oxirigacha;\n" +
                        "Sarflanmagan SMS lar keyingi oyga o'tmaydi;\n" +
                        "Oy davomida abonent bitta paket xarid qilishi mumkin;\n" +
                        "Tarif reja o’zgartirilganida paketlar saqlanadi;\n" +
                        "Kiritilgan SMS lar soni tugaganda yoki paketning amal qilish muddati tugaganidan keyin har 1 SMS tarif reja asosida hisoblanadi;\n" +
                        "Qoldiq tekshirilganda qolgan trafik haqida ma`lumot donalarda ko’rsatiladi;\n" +
                        "Mahalliy SMS to'plamlari faqat O'zbekistonda amal qiladi;\n" +
                        "Kiritilgan SMS lar va xizmat uchun mablag' belgilanishi ulanish kuniga  va oy oxirigacha qolgan kunlar soniga asoslanib belgilanadi;\n" +
                        "Xizmatni yoqish yoki o’chirish uchun Korporativ Abonentlarga xizmat ko’rsatish bo’limiga yozma ko’rinishda ariza berish, 0611@beeline.uz manziliga jo’natish lozim;\n" +
                        "Barcha narxlar QQS hisobga olinmagan holda ko'rsatilgan.")
                )
                list4.add(
                    User4("Paket 1000 sms", "*110*06#","17.555 sum","Mahalliy SMS-paketlar O'zbekistonning barcha uyali aloqa operatorlariga jo'natilishi mumkin.\n" +
                        "\n" +
                        "SMS bilan siz quyidagilarni amalga oshirishingiz mumkin:\n" +
                        "\n" +
                        "bir vaqtning o'zida bir necha kishiga muhim ma'lumotlarni yuborish;\n" +
                        "noqulay bo’lgan vaziyatda  javob bering;\n" +
                        "o'zingizni aloqada cheklamasdan pulni tejash.\n" +
                        "100, 500, 1000 SMS dan tashkil topgan Mahalliy SMS-paketlarni ulashingiz mumkin.\n" +
                        "\n" +
                        "Xizmat,  barcha haqi keyin to'lanadigan billing tizimi (POSTPAID) tarif rejalari uchun amal qiladi.\n" +
                        "\n" +
                        "«Beeline Business» ning yangi SMS-paketlari bilan yanada ko'proq muloqot qiling!\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Bitta paketning amal qilish muddati – ulangan kundan boshlab oy oxirigacha;\n" +
                        "Sarflanmagan SMS lar keyingi oyga o'tmaydi;\n" +
                        "Oy davomida abonent bitta paket xarid qilishi mumkin;\n" +
                        "Tarif reja o’zgartirilganida paketlar saqlanadi;\n" +
                        "Kiritilgan SMS lar soni tugaganda yoki paketning amal qilish muddati tugaganidan keyin har 1 SMS tarif reja asosida hisoblanadi;\n" +
                        "Qoldiq tekshirilganda qolgan trafik haqida ma`lumot donalarda ko’rsatiladi;\n" +
                        "Mahalliy SMS to'plamlari faqat O'zbekistonda amal qiladi;\n" +
                        "Kiritilgan SMS lar va xizmat uchun mablag' belgilanishi ulanish kuniga  va oy oxirigacha qolgan kunlar soniga asoslanib belgilanadi;\n" +
                        "Xizmatni yoqish yoki o’chirish uchun Korporativ Abonentlarga xizmat ko’rsatish bo’limiga yozma ko’rinishda ariza berish, 0611@beeline.uz manziliga jo’natish lozim;\n" +
                        "Barcha narxlar QQS hisobga olinmagan holda ko'rsatilgan.")
                )
            }
            5 ->{
                findNavController().navigate(R.id.yangiliklarFragment)
            }
        }
        return binding.root
    }
}