package com.example.cinemaguide.ui.mainpage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cinemaguide.App
import com.example.cinemaguide.R
import com.example.cinemaguide.databinding.FragmentMainPageBinding
import com.example.cinemaguide.repository.RemoteRepository
import javax.inject.Inject

class MainPageFragment : Fragment() {

    @Inject
    lateinit var remoteRepository: RemoteRepository

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

        val viewModelFactory = MainPageViewModelFactory(remoteRepository)

        val mainPageViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainPageViewModel::class.java)

        binding.mainPageViewModel = mainPageViewModel

        mainPageViewModel.fetchPopularMovies()

        mainPageViewModel.films.observe(viewLifecycleOwner, Observer { films ->

        })

        return binding.root
    }
}