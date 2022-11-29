package com.pratik.mytemplate.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pratik.mytemplate.R
import com.pratik.mytemplate.ViewModelFactory.GenericSavedStateViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    internal lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    //For activity
    private val mainActivityViewModel: MainActivityViewModel by viewModels{
        GenericSavedStateViewModelFactory(mainActivityViewModelFactory,this)
    }

    //For fragment
//    private val mainActivityViewModel: MainActivityViewModel by activityViewModels{
//        GenericSavedStateViewModelFactory(mainActivityViewModelFactory,this)
//    }
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel.getBitcoin()
    }
}