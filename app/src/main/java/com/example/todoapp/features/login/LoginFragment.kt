package com.example.todoapp.features.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentLoginBinding
import com.example.todoapp.features.home.HomeFragment
import com.example.todoapp.features.register.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginBinding>(), LoginContract {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(inflater, container, false)
    }

    override fun attachToPresenter() {
        presenter.attachView(this)
    }

    override fun initView() {
        initListeners()
    }

    /**
     * Contract
     */

    override fun getEmail(): String {
        return binding.editEmailLogin.text.toString()
    }

    override fun getPassword(): String {
        return binding.editPasswordLogin.text.toString()
    }

    override fun openRegisterFragment() {
        RegisterFragment.start(findNavController())
    }

    override fun openHomeFragment() {
        HomeFragment.start(findNavController())
    }

    /**
     * Help fun-s
     */

    private fun initListeners(){
        binding.btnLogin.setOnClickListener {
            presenter.onButtonLoginClicked()
        }
        binding.layoutNoAccountLogin.setOnClickListener {
            presenter.onButtonNoAccountClicked()
        }
    }
}