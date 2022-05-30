package com.melvin.ongandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.view.adapters.SlidesAdapter
import com.melvin.ongandroid.view.adapters.TestimonyAdapter
import com.melvin.ongandroid.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater)


        setSlides(viewModel, binding) //Load activities
        setNews(viewModel,binding) //Load news
        setTestimony(viewModel, binding) //Load testimony

        return binding.root
    }



    override fun onDestroyView() {

        super.onDestroyView()
        onDestroyNews()


    }


    private fun setSlides(viewModel : HomeViewModel, binding: FragmentHomeBinding){
        val slidesList = viewModel.slidesList.value
        //Initialize slides adapter
        if (slidesList != null)
        binding.rvSlides.adapter = SlidesAdapter(slidesList)
    }

    private fun setNews(viewModel: HomeViewModel, binding: FragmentHomeBinding){
/*        val newsList //Add news
        //Initialize news adapter
        binding.vpNews.adapter = NewsViewPagerAdapter()

        //Set starting page for news viewpager
        val currentPageIndex = 0
        binding.vpNews.currentItem = currentPageIndex

        //Registering for page change callback
        binding.vpNews.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            }
        )*/
    }

    private fun setTestimony(viewModel: HomeViewModel, binding: FragmentHomeBinding) {
        val testimonyList = viewModel.testimonialsList.value
        //Initialize testimony adapter
        if (testimonyList != null)
            binding.rvTestimony.adapter = TestimonyAdapter(testimonyList)

    }

    private fun onDestroyNews(){
        val viewpager = view?.findViewById<ViewPager2>(R.id.vp_news)
        //Unregistering the onPageChangedCallback
        viewpager?.unregisterOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){}
        )
    }

}