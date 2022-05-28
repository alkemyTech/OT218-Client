package com.melvin.ongandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melvin.ongandroid.businesslogic.repository.HomeRepository
import com.melvin.ongandroid.model.APIServices
import com.melvin.ongandroid.model.data.slides.Slide
import com.melvin.ongandroid.model.data.testimonials.Testimonial
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel() : ViewModel() {


    /* ---------------------------SLIDES REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _slidesStatus = MutableLiveData<State>()
    private val _slidesList = MutableLiveData<List<Slide>>()
    //External LiveData
    val slidesStatus: LiveData<State> = _slidesStatus
    val slidesList: LiveData<List<Slide>> = _slidesList

    suspend fun getSlides() {
        _slidesStatus.value = State.Loading()
        viewModelScope.launch {
           // val homeSlides = homeRepository.getHomeSlides()
        }
    }

    /* ---------------------------TESTIMONIALS REQUEST--------------------------- */
    //Internal MutableLiveData
    private val _testimonialsStatus = MutableLiveData<State>()
    private val _testimonialsList = MutableLiveData<List<Testimonial>?>()
    //External LiveData
    val testimonialsStatus: LiveData<State> = _testimonialsStatus
    val testimonialsList: LiveData<List<Testimonial>?> = _testimonialsList

    suspend fun getTestimonials(){
        _testimonialsStatus.value = State.Loading()
        viewModelScope.launch {
            try {
              //  val testimonials = homeRepository.getTestimonials().testimonialsList
                _testimonialsStatus.value = State.Success()
              //  _testimonialsList.value = testimonials
            }
            catch (e: Exception){
                _testimonialsStatus.value = State.Failure(e)
            }
        }
    }

    sealed class State() {
        class Success() : State()
        class Failure(val cause: Throwable) : State()
        class Loading() : State()
    }
}