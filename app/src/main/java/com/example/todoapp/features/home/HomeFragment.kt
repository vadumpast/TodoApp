package com.example.todoapp.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(), HomeContract{

    @Inject
    lateinit var presenter: HomePresenter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.bind(inflater.inflate(R.layout.fragment_home, container, false))
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }




    companion object{
        fun start(navController: NavController){
            navController.navigate(R.id.action_to_home)
        }
    }
}