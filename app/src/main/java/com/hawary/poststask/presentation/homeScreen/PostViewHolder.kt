package com.hawary.poststask.presentation.homeScreen

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hawary.poststask.R
import com.hawary.poststask.databinding.PostItemBinding
import com.hawary.poststask.domain.models.Post
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType

class PostViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.title.text = post.title
        binding.body.text = post.body
        binding.body.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPostDetailsFragment(post)
            binding.root.findNavController().navigate(action)
        }
    }

}