package developer.abdulahad.bellineapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import developer.abdulahad.bellineapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}