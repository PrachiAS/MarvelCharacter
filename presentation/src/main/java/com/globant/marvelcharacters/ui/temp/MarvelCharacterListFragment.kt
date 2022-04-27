package com.globant.marvelcharacters.ui.temp

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
class MarvelCharacterListFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<MarvelCharacterListViewModel>()
    private lateinit var adapter: MarvelCharacterListAdapter
    var bundle: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  viewModel = ViewModelProvider(this).get(MarvelCharacterListViewModel::class.java)

        val onItemClickListener: (position: Int) -> Unit = {
            viewModel.onListItemClickListener(it)
        }
        adapter = MarvelCharacterListAdapter(onItemClickListener)
        with(viewModel) {
            characterNameList.observe(this@MarvelCharacterListFragment, {
                adapter.setList(it.characterNamesList)
            })
            characterDetail.observe(this@MarvelCharacterListFragment, {
                bundle.putParcelable(CHARACTER_DETAIL, it)
                navigateToDetails(bundle)
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )
        with(binding) {
            lifecycleOwner = this@MarvelCharacterListFragment
           // viewModel = this@MarvelCharacterListFragment.viewModel
          //  searchViewCharacterSearch.setOnQueryTextListener(viewModel?.queryTextListener)
            recyclerViewCharacterList.adapter = adapter
            recyclerViewCharacterList.layoutManager =
                LinearLayoutManager(recyclerViewCharacterList.context)
        }
        return binding.root
    }

    private fun navigateToDetails(bundle: Bundle) {
        findNavController().navigate(
            R.id.navigateToDetailsFragment,
            bundle
        )
    }

    companion object {
        private const val CHARACTER_DETAIL = "CHARACTER_DETAIL"
    }
}