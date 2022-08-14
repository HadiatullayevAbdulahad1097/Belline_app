package developer.abdulahad.bellineapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulahad.bellineapp.databinding.FragmentYangiliklarBinding


class YangiliklarFragment : Fragment() {
    lateinit var binding: FragmentYangiliklarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentYangiliklarBinding.inflate(layoutInflater)

        binding.btnChiqish.setOnClickListener { 
            findNavController().navigate(R.id.homeFragment)
        }

        return binding.root
    }
}