package com.example.dispatcher.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dispatcher.databinding.FragmentSignupBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.AuthenticationViewModel

class SignupFragment: BaseFragment<FragmentSignupBinding>() {
    val viewModel: AuthenticationViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<FragmentSignupBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentSignupBinding.inflate(layoutInflater))
    }

    override fun setup() {
        setClickListenerForLogin()

        setClickListenerForSignup()
    }

    private fun navigateToMain() {
        findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenToMainFragment())
    }

    private fun setClickListenerForSignup() {
        withBinding {
            signupButton.setOnClickListener {
                signUp(email.text.toString(), password.text.toString())
            }
        }
    }

    private fun setClickListenerForLogin() {
        withBinding {
            loginButton.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun signUp(email: String, password: String) {
        viewModel.signUp(email, password) { task ->
            if (task.isSuccessful && viewModel.isUserSignedIn()) navigateToMain()
        }
    }
}