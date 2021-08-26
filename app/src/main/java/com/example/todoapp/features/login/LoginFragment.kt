package com.example.todoapp.features.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentLoginBinding

class LoginFragment: BaseFragment<FragmentLoginBinding>(), LoginContract {

    private val presenter by lazy { LoginPresenter() }

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

    override fun getEmail(): String {
        return binding.editEmailLogin.text.toString()
    }

    override fun getPassword(): String {
        return binding.editPasswordLogin.text.toString()
    }

    private fun initListeners(){
        binding.btnLogin.setOnClickListener {
            presenter.onButtonLoginClicked()
        }
        binding.btnNoAccountLogin.setOnClickListener {
            presenter.onButtonNoAccountClicked()
        }
    }
}