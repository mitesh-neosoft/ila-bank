package com.ilabank.practical.mvvm.ui.main.viewmodel

import android.text.TextUtils
import androidx.lifecycle.*
import com.ilabank.practical.mvvm.R
import com.ilabank.practical.mvvm.data.model.Animal
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val animalList = ArrayList<Animal>()
    private val _animal = MutableLiveData<List<Animal>>()
    val animal: LiveData<List<Animal>>
        get() = _animal

    private val animalBreedsList = ArrayList<Animal>()
    private val _animalBreeds = MutableLiveData<List<Animal>>()
    val animalBreeds: LiveData<List<Animal>>
        get() = _animalBreeds

    init {
        fetchAnimals()
    }

    private fun fetchAnimals() {
        viewModelScope.launch {
            animalList.add(Animal("Dog", R.drawable.dog))
            animalList.add(Animal("Cat", R.drawable.cat))
            animalList.add(Animal("Horse", R.drawable.horse))
            animalList.add(Animal("Lion", R.drawable.download))
            animalList.add(Animal("Tiger", R.drawable.tiger))
            _animal.postValue(animalList)
        }
    }

    fun fetchAnimalBreeds(animal: String) {
        viewModelScope.launch {
            animalBreedsList.clear()
            if (TextUtils.equals(animal, "Dog")) {
                for (i in 0..19) {
                    animalBreedsList.add(Animal("Dog ${i.plus(1)}", R.drawable.dog))
                }
            }
            if (TextUtils.equals(animal, "Cat")) {
                for (i in 0..19) {
                    animalBreedsList.add(Animal("Cat ${i.plus(1)}", R.drawable.cat))
                }
            }
            if (TextUtils.equals(animal, "Horse")) {
                for (i in 0..19) {
                    animalBreedsList.add(Animal("Horse ${i.plus(1)}", R.drawable.horse))
                }
            }
            if (TextUtils.equals(animal, "Lion")) {
                for (i in 0..19) {
                    animalBreedsList.add(Animal("Lion ${i.plus(1)}", R.drawable.download))
                }
            }
            if (TextUtils.equals(animal, "Tiger")) {
                for (i in 0 until 19) {
                    animalBreedsList.add(Animal("Tiger ${i.plus(1)}", R.drawable.tiger))
                }
            }
            _animalBreeds.postValue(animalBreedsList)
        }
    }
}