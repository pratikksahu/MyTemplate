package com.pratik.mytemplate.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.pratik.mytemplate.MainActivity.MainActivityViewModel
import com.pratik.mytemplate.MainActivity.MainActivityViewModelFactory
import com.pratik.mytemplate.ViewModelFactory.GenericSavedStateViewModelFactory
import com.pratik.mytemplate.databinding.FragmentBlankBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BlankFragment : Fragment() {

    @Inject
    internal lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    private val mainActivityViewModel: MainActivityViewModel by activityViewModels{
        GenericSavedStateViewModelFactory(mainActivityViewModelFactory,this)
    }

    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener{
            mainActivityViewModel.getBitcoin()
        }
    }
}