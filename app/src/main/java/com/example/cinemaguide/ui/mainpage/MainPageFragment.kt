package com.example.cinemaguide.ui.mainpage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cinemaguide.App
import com.example.cinemaguide.R
import com.example.cinemaguide.databinding.FragmentMainPageBinding
import javax.inject.Inject

class MainPageFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainPageViewModel: MainPageViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main_page, container, false
        )

        binding.mainPageViewModel = mainPageViewModel

        binding.lifecycleOwner = this

        val adapter = MovieAdapter()
        binding.moviesList.adapter = adapter

        mainPageViewModel.films.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}