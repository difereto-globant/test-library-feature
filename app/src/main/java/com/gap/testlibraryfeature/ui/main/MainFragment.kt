package com.gap.testlibraryfeature.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gap.hellogiver.gateway.HelloGiverActivityService
import com.gap.hellogiver.gateway.HelloGiverActivityService.HelloProvider.HelloDesc
import com.gap.hellogiver.gateway.HelloGiverActivityService.HelloProvider.HelloGiver
import com.gap.hellogiver.gateway.provider.HelloGiverActivityProvider
import com.gap.hellogiver.gateway.provider.HelloGiverColorProvider
import com.gap.testlibraryfeature.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private val helloActivityProvider = HelloGiverActivityProvider.getInstance()
    private val helloColorProvider = HelloGiverColorProvider.getInstance()

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel

        binding.buttonHelloGiver.setOnClickListener { launchHelloActivity(HelloGiver) }
        binding.buttonHelloDesc.setOnClickListener { launchHelloActivity(HelloDesc) }
        
        val colorService = helloColorProvider.getColorServiceImpl()
        binding.buttonHelloGiver.setTextColor(resources.getColor(colorService.getPrimaryColor(), null))
    }

    private fun launchHelloActivity(helloProviderType: HelloGiverActivityService.HelloProvider) {
        val helloService = helloActivityProvider.getHelloServiceImpl(helloProviderType)
        helloService?.launchHelloGiverActivity(requireContext(), "Diego Recalde")
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}