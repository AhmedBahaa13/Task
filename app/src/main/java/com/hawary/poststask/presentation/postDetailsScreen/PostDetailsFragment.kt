package com.hawary.poststask.presentation.postDetailsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hawary.poststask.R
import com.hawary.poststask.databinding.FragmentPostDetailsBinding

class PostDetailsFragment : Fragment() {
    lateinit var binding:FragmentPostDetailsBinding
    val args: PostDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.body.text = args.post.body
        binding.title.text = args.post.title
        binding.userId.text = getString(R.string.user_id, args.post.userId.toString())
        binding.postId.text = getString(R.string.user_id, args.post.id.toString())
    }

}