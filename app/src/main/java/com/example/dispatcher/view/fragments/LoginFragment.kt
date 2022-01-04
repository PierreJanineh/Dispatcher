package com.example.dispatcher.view.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dispatcher.R
import com.example.dispatcher.databinding.FragmentLoginBinding
import com.example.dispatcher.view.base.BaseFragment
import com.example.dispatcher.viewmodel.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginFragment: BaseFragment<FragmentLoginBinding>() {
    private val viewModel: AuthenticationViewModel by viewModels()

    override fun attachBinding(
        list: MutableList<FragmentLoginBinding>,
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToRoot: Boolean
    ) {
        list.add(0, FragmentLoginBinding.inflate(layoutInflater))
    }

    override fun setup() {
        setClickListenerForLogin()

        setClickListenerForSignup()
    }

    private fun navigateToMain() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
    }

    private fun navigateToSignUp() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
    }

    private fun setClickListenerForLogin() {
        withBinding {
            loginButton.setOnClickListener {
                signIn(email.text.toString(), password.text.toString())
            }
        }
    }

    private fun setClickListenerForSignup() {
        withBinding {
            signupButton.setOnClickListener {
                navigateToSignUp()
            }
        }
    }

    private fun signIn(email: String, password: String) {
        viewModel.signIn(email, password) { task ->
            if (task.isSuccessful && viewModel.isUserSignedIn()) {
                navigateToMain()
            } else {
                val binding = withBinding {}
                when {
                    (task.exception is FirebaseAuthInvalidUserException) ->
                        binding.email.error = getString(R.string.email_error)

                    (task.exception is FirebaseAuthInvalidCredentialsException) ->
                        binding.password.error = getString(R.string.password_error)
                }
            }
        }
    }

}