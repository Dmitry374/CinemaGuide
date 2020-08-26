package com.example.cinemaguide.ui.mainpage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cinemaguide.R
import com.example.cinemaguide.databinding.FragmentMainPageBinding
import com.example.cinemaguide.repository.Repository

class MainPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMainPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main_page, container, false
        )

        val repository = Repository()

        val viewModelFactory = MainPageViewModelFactory(repository)

        val mainPageViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainPageViewModel::class.java)

        binding.mainPageViewModel = mainPageViewModel

        mainPageViewModel.films.observe(viewLifecycleOwner, Observer { films ->
            binding.tvFilms.text = films.toString()
        })

        return binding.root
    }
}