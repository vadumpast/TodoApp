package com.example.todoapp.features.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentRegisterBinding
import com.example.todoapp.features.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment: BaseFragment<FragmentRegisterBinding>(), RegisterContract {

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRegisterBinding {
        return FragmentRegisterBinding.bind(inflater.inflate(R.layout.fragment_register, container, false))
    }

    override fun initView() {
        initListeners()
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }

    /**
     * Contract
     */

    override fun getName(): String {
        return binding.editNameRegister.text.toString()
    }

    override fun getEmail(): String {
        return binding.editEmailRegister.text.toString()
    }

    override fun getPassword(): String {
        return binding.editPasswordRegister.text.toString()
    }

    override fun getAge(): String {
        return binding.editAgeRegister.text.toString()
    }

    override fun openHomeFragment() {
        HomeFragment.start(findNavController())
    }

    /**
     * Help fun-s
     */

    private fun initListeners(){
        binding.btnRegister.setOnClickListener {
            presenter.onRegisterButtonClicked()
        }
    }

    companion object{
        fun start(navController: NavController){
            navController.navigate(R.id.action_to_register)
        }
    }
}