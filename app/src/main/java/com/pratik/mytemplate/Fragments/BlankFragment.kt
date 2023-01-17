package com.pratik.mytemplate.Fragments

import androidx.fragment.app.activityViewModels
import com.pratik.mytemplate.MainActivity.MainActivityViewModel
import com.pratik.mytemplate.MainActivity.MainActivityViewModelFactory
import com.pratik.mytemplate.ViewModelFactory.GenericSavedStateViewModelFactory
import com.pratik.mytemplate.databinding.FragmentBlankBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BlankFragment : BaseBindingFragment<FragmentBlankBinding>(FragmentBlankBinding::inflate) {

    @Inject
    internal lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    private val mainActivityViewModel: MainActivityViewModel by activityViewModels{
        GenericSavedStateViewModelFactory(mainActivityViewModelFactory,this)
    }

    override fun viewModelSetup() {
    }

    override fun viewSetup() {
        binding.button.setOnClickListener{
            mainActivityViewModel.getBitcoin()
        }
    }
}