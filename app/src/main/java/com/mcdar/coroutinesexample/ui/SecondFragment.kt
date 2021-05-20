package com.mcdar.coroutinesexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mcdar.coroutinesexample.R
import com.mcdar.coroutinesexample.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    
    private val args: SecondFragmentArgs by navArgs()
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second, container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.employee = args.employee
        binding.buttonSecond.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
