package com.kemalurekli.runhandapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kemalurekli.runhandapp.databinding.FragmentHomePageFagmentBinding

class HomePageFagment : Fragment() {

    private var _binding: FragmentHomePageFagmentBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePageFagmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvUpdated.visibility = View.INVISIBLE
        binding.tvCheckingData.visibility = View.INVISIBLE
        binding.tvTime.visibility = View.INVISIBLE


        binding.buttonStart.setOnClickListener {
            number = 0
            //if user press the start button runnable can continue at back tread.
            runnable = object : Runnable
            {
                override fun run()
                {
                    number = number + 1
                    binding.tvTime.text = "Time: $number"
                    binding.tvTime.visibility = View.VISIBLE
                    binding.tvUpdated.visibility = View.INVISIBLE

                    if(number%5==0){
                        binding.tvCheckingData.visibility = View.VISIBLE
                    }else{
                        binding.tvCheckingData.visibility = View.INVISIBLE
                        binding.tvUpdated.visibility = View.VISIBLE
                    }
                    //Number increase every second.
                    handler.postDelayed(this,1000)
                }
            }
            handler.post(runnable)
        }





        binding.buttonStop.setOnClickListener {

            //This is for stopping runnable.
            handler.removeCallbacks(runnable)
            number = 0
            binding.tvTime.text = "Time: 0"

        }






    }


    // For the memory control.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}