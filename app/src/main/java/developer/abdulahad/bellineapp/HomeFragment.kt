package developer.abdulahad.bellineapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulahad.bellineapp.Utils.Sanoq
import developer.abdulahad.bellineapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.apply {
            tariflar.setOnClickListener {
                Sanoq.raqam = 1
                findNavController().navigate(R.id.hizmatlarFragment)
            }
            internet.setOnClickListener {
                Sanoq.raqam = 2
                findNavController().navigate(R.id.hizmatlarFragment)
            }
            xiznatlar.setOnClickListener {
                Sanoq.raqam = 3
                findNavController().navigate(R.id.hizmatlarFragment)
            }
            sms.setOnClickListener {
                Sanoq.raqam = 4
                findNavController().navigate(R.id.hizmatlarFragment)
            }
            yangiliklar.setOnClickListener {
                Sanoq.raqam = 5
                findNavController().navigate(R.id.hizmatlarFragment)
            }
        }

        return binding.root
    }
}