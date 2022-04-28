package com.globant.marvelcharacters.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.globant.marvelcharacters.R
import com.globant.marvelcharacters.databinding.FragmentDetailsBinding
import com.globant.marvelcharacters.ui.details.adapter.ComicListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    val binding: FragmentDetailsBinding
        get() = _binding!!
    private val viewModel by viewModels<DetailsViewModel>()
    private lateinit var adapter: ComicListAdapter
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_details, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ComicListAdapter()
        with(binding) {
            lifecycleOwner = this@DetailsFragment
            viewModel = this.viewModel
            recyclerViewComicList.adapter = adapter
            recyclerViewComicList.layoutManager =
                LinearLayoutManager(recyclerViewComicList.context)
        }
        args.characterId?.let {
            viewModel.getMarvelCharacterDetails(it)
        }
        viewModel.characterDetailsModelLiveData.observe(viewLifecycleOwner) {
            binding.characterDetails = it
            adapter.setList(it?.comicNames)
        }
    }
}