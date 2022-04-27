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
    private lateinit var adapter: MarvelCharacterListAdapter
    var bundle: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onItemClickListener: (position: Int) -> Unit = {
            viewModel.onListItemClickListener(it)
        }
        adapter = MarvelCharacterListAdapter(onItemClickListener)
        with(viewModel) {
            characterNameList.observe(this@HomeFragment, {
                adapter.setList(it)
            })
            /*characterDetail.observe(this@HomeFragment, {
                bundle.putParcelable(CHARACTER_DETAIL, it)
                navigateToDetails(it)
            })*/
        }
        viewModel.getMarvelCharacter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        with(binding) {
            lifecycleOwner = this@HomeFragment
            viewModel = this@HomeFragment.viewModel
            recyclerViewCharacterList.adapter = adapter
            recyclerViewCharacterList.layoutManager =
                LinearLayoutManager(recyclerViewCharacterList.context)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.itemClickListener {
            findNavController().navigate(
                HomeFragmentDirections.navigateToDetailsFragment(
                    it.id.toString()
                )
            )
        }
    }
    private fun navigateToDetails(bundle: Bundle) {
        findNavController().navigate(
            HomeFragmentDirections.navigateToDetailsFragment()
        )
    }

    companion object {
        private const val CHARACTER_DETAIL = "CHARACTER_DETAIL"
    }
}