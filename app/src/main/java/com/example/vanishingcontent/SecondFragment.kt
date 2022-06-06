package com.example.vanishingcontent

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.findNavController
import com.example.vanishingcontent.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.the_transition)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        activity?.window?.apply {
            val windowInsetsControllerCompat = WindowInsetsControllerCompat(this, decorView)
            windowInsetsControllerCompat.isAppearanceLightStatusBars = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        sharedElementReturnTransition =
            TransitionInflater.from(requireContext()).inflateTransition(R.transition.the_transition)

        activity?.window?.apply {
            val windowInsetsControllerCompat = WindowInsetsControllerCompat(this, decorView)
            windowInsetsControllerCompat.isAppearanceLightStatusBars = true
        }
        _binding = null
    }
}