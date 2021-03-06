package com.melvin.ongandroid.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.view.adapters.NewsViewPagerAdapter
import com.melvin.ongandroid.view.adapters.SlidesAdapter
import com.melvin.ongandroid.view.adapters.TestimonialsAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //Loads data and updates on changes
        viewModel.slidesList.observe(viewLifecycleOwner, Observer {
            setSlides(viewModel, binding) //Load Slides


        })
        viewModel.testimonialsList.observe(viewLifecycleOwner, Observer{
            setTestimonials(viewModel, binding) //Load testimonials
        })
        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            setNews(viewModel, binding) //Load news
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyNews()
    }


    private fun setSlides(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val slidesList = viewModel.slidesList.value

        if (slidesList == null || !slidesList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!slidesList.slide.isNullOrEmpty()) {
                binding.rvSlides.adapter = SlidesAdapter(slidesList.slide)
            } else {
                //TODO ERROR IMPLEMENTATION
            }
        }
    }

    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val newsList = viewModel.newsList.value

        if (newsList == null || !newsList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!newsList.data.isNullOrEmpty()) {
                //Initialize news adapter
                binding.vpNews.adapter = NewsViewPagerAdapter(newsList.data)
                //Set starting page for news viewpager
                val currentPageIndex = 0
                binding.vpNews.currentItem = currentPageIndex
                //Registering for page change callback
                binding.vpNews.registerOnPageChangeCallback(
                    object : ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                        }
                    }
                )
            } else {
                //TODO ERROR IMPLEMENTATION
            }
        }
    }

    private fun setTestimonials(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val testimonialsList = viewModel.testimonialsList.value

        if (testimonialsList == null || !testimonialsList.success) {
            //TODO ERROR IMPLEMENTATION
        } else {
            if (!testimonialsList.testimonials.isNullOrEmpty()) {
                binding.rvTestimony.adapter =
                    TestimonialsAdapter(testimonialsList.testimonials, true)
            } else {
                //TODO ERROR IMPLEMENTATION

            }
        }
    }

    private fun onDestroyNews() {
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {}
        )
    }

}