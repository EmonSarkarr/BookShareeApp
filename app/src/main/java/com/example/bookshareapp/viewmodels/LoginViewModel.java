package com.example.bookshareapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModel {
    public enum AuthState {
        AUTHENTICATED, UNAUTHENTICATED
    }
    private MutableLiveData<AuthState> stateLiveData;
    private MutableLiveData<String> errMsgLiveData;
    private FirebaseAuth auth;
    private FirebaseUser user;

    public LoginViewModel() {
        stateLiveData = new MutableLiveData<>();
        errMsgLiveData = new MutableLiveData<>();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        if (user == null) {
            stateLiveData.postValue(AuthState.UNAUTHENTICATED);
        }else {
            stateLiveData.postValue(AuthState.AUTHENTICATED);
        }
    }
    public LiveData<AuthState> getStateLiveData() {
        return stateLiveData;
    }
    public LiveData<String> getErrMsgLiveData() {
        return errMsgLiveData;
    }
    public FirebaseUser getUser() {
        return user;
    }
    public void login(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    user = authResult.getUser();
                    stateLiveData.postValue(AuthState.AUTHENTICATED);}).addOnFailureListener(e -> {
                    errMsgLiveData.postValue(e.getLocalizedMessage());
                });
    }
    public void register(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    user = authResult.getUser();
                    stateLiveData.postValue(AuthState.AUTHENTICATED);
                }).addOnFailureListener(e -> {
                    errMsgLiveData.postValue(e.getLocalizedMessage());
                });
    }
}
