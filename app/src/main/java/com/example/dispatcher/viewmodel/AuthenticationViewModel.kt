package com.example.dispatcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dispatcher.model.extensions.await
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthenticationViewModel : ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth
    private var user: MutableLiveData<FirebaseUser?> = MutableLiveData()

    private fun getSignedInUser(): LiveData<FirebaseUser?> {
        if (user.value != auth.currentUser) user.value = auth.currentUser
        return user
    }

    fun isUserSignedIn(): Boolean {
        return getSignedInUser().value != null
    }

    fun signIn(email: String, password: String, onComplete: OnCompleteListener<AuthResult>) {
        firebaseAuthTask(auth.signInWithEmailAndPassword(email, password), onComplete)
    }

    fun signUp(email: String, password: String, onComplete: OnCompleteListener<AuthResult>) {
        firebaseAuthTask(auth.createUserWithEmailAndPassword(email, password), onComplete)
    }

    private fun firebaseAuthTask(task: Task<AuthResult>, onComplete: OnCompleteListener<AuthResult>) {
        viewModelScope.launch {
            try {
                val data = task.await()
                user.value = data.user
                onComplete.onComplete(task)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}