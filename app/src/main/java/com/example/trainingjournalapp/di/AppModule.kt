package com.example.trainingjournalapp.di

import com.example.trainingjournalapp.data.repository.AuthRepositoryImpl
import com.example.trainingjournalapp.domain.models.AuthRepository
import com.example.trainingjournalapp.util.UserUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(firebaseAuth)

    @Provides
    fun provideUserUtils(): UserUtils = UserUtils()

    @Singleton
    @Provides
    fun provideDb(): FirebaseFirestore = Firebase.firestore
}
