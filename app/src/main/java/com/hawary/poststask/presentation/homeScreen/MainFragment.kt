package com.hawary.poststask.presentation.homeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.hawary.poststask.data.ApiResult
import com.hawary.poststask.databinding.FragmentMainBinding
import com.hawary.poststask.presentation.PostsViewModel
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    val viewModel: PostsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getPosts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PostsAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.posts.observe(viewLifecycleOwner) {
                    when (it) {
                        is ApiResult.Success -> {
                            binding.progressBar.visibility = View.GONE
                            adapter.submitList(it.data)
                            showSuccess()
                        }
                        is ApiResult.Error -> {
                            binding.progressBar.visibility = View.GONE
                            showError(it.errorMessage)
                        }
                        is ApiResult.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }

            }
        }

    }

    private fun showSuccess() {
            AestheticDialog.Builder(requireActivity(), DialogStyle.EMOTION, DialogType.SUCCESS)
            .setTitle("Success")
            .show()
    }

    private fun showError(message: String) {
        AestheticDialog.Builder(requireActivity(), DialogStyle.EMOTION, DialogType.ERROR)
            .setTitle("Failed")
            .setMessage(message)
            .show()
    }

}