package com.example.dispatcher.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationViewModel : ViewModel() {
    private var auth: FirebaseAuth = Firebase.auth
    private var user: MutableLiveData<FirebaseUser?> = MutableLiveData()

    private fun getSignedInUser(): LiveData<FirebaseUser?> {
        user.value = auth.currentUser
        return user
    }

    fun isUserSignedIn(): Boolean {
        return getSignedInUser().value != null
    }

    fun signIn(email: String, password: String, onComplete: OnCompleteListener<AuthResult>) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                user.value = auth.currentUser
            }
            onComplete.onComplete(task)
        }
    }

    fun signUp(email: String, password: String, onComplete: OnCompleteListener<AuthResult>) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                user.value = auth.currentUser
            }
            onComplete.onComplete(task)
        }
    }
}