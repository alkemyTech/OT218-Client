package com.melvin.ongandroid.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.melvin.ongandroid.databinding.ActivityMainBinding
import com.melvin.ongandroid.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> e7b752f (Testimonials layout created)
    private val viewModel by viewModels<MainActivityViewModel>()
=======
    private lateinit var mainActivityViewModel: MainActivityViewModel
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 827da8a (Testimonials layout created)
=======
    private lateinit var mainActivityViewModel: MainActivityViewModel
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 827da8a (Testimonials layout created)
=======
//    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 5e4589c (Testimony fragment added)
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
=======
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 827da8a (Testimonials layout created)
>>>>>>> e7b752f (Testimonials layout created)
=======
    private lateinit var mainActivityViewModel: MainActivityViewModel
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
    private val viewModel by viewModels<MainActivityViewModel>()
>>>>>>> 827da8a (Testimonials layout created)
=======
=======
>>>>>>> ee97f54 (post PR en local)
//    private lateinit var mainActivityViewModel: MainActivityViewModel
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Show Spinner Loading
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
>>>>>>> e7b752f (Testimonials layout created)
        viewModel.isShowProgress()
=======
        mainActivityViewModel.isShowProgress()
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
<<<<<<< HEAD
<<<<<<< HEAD
=======
        viewModel.isShowProgress()
>>>>>>> 827da8a (Testimonials layout created)
=======
        mainActivityViewModel.isShowProgress()
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
        viewModel.isShowProgress()
>>>>>>> 827da8a (Testimonials layout created)
=======
        viewModel.isShowProgress()
>>>>>>> 5e4589c (Testimony fragment added)
=======
        //viewModel.isShowProgress()
>>>>>>> fa6b629 (spinner)

        binding.button.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
=======
>>>>>>> c555745 (Hilt dependencies and spinner  added)
=======
=======
        viewModel.isShowProgress()
>>>>>>> 827da8a (Testimonials layout created)
>>>>>>> e7b752f (Testimonials layout created)
=======
        mainActivityViewModel.isShowProgress()
>>>>>>> bb72910 (Hilt dependencies and spinner  added)
=======
        viewModel.isShowProgress()
>>>>>>> 827da8a (Testimonials layout created)

    }
<<<<<<< HEAD
}
=======
=======
        viewModel.isShowProgress()
=======
        //viewModel.isShowProgress()
>>>>>>> fa6b629 (spinner)

    }
>>>>>>> 5e4589c (Testimony fragment added)

=======
        viewModel.isShowProgress()
    }
>>>>>>> ee97f54 (post PR en local)
}


>>>>>>> dd3c420 (Testimony fragment added)
