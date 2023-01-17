package com.pratik.mytemplate.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding


abstract class BaseBindingFragment<T : ViewBinding>(private val bindingInflater: (layoutInflater:LayoutInflater) -> T) :
    Fragment() {

    // Bindings
    private var _binding: T? = null

    protected val parentNavController
        get() = requireParentFragment().findNavController()

    /**
     * Binding
     */
    protected val binding:T
        get() = _binding ?: throw IllegalStateException(
            "binding is not available before onCreateView() and in or after onDestroyView()"
        )


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelSetup()
        viewSetup()
    }

    abstract fun viewModelSetup()

    abstract fun viewSetup()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}