package com.globant.marvelcharacters.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.marvelcharacters.R
import com.globant.marvelcharacters.databinding.FragmentHomeBinding
import com.globant.marvelcharacters.ui.home.adapter.MarvelCharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var marvelCharacterListAdapter: MarvelCharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        marvelCharacterListAdapter = MarvelCharacterListAdapter()
        binding.recyclerViewCharacterList.apply {
            adapter = marvelCharacterListAdapter
        }

        with(binding) {
            lifecycleOwner = this@HomeFragment
            viewModel = this@HomeFragment.viewModel
            recyclerViewCharacterList.layoutManager =
                LinearLayoutManager(recyclerViewCharacterList.context)
        }

        with(viewModel) {
            characterNameList.observe(viewLifecycleOwner) {
                marvelCharacterListAdapter.setList(it)
            }
        }
        viewModel.getMarvelCharacter()
        marvelCharacterListAdapter.itemClickListener {
            findNavController().navigate(
                HomeFragmentDirections.navigateToDetailsFragment(
                    it.id.toString()
                )
            )
        }
    }
}