package com.globant.marvelcharacters.di

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.repositoryimpl.MarvelCharactersListRepositoryImpl
import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.data.source.remote.RemoteDataSourceImpl
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.helper.Constants
import com.globant.marvelcharacters.helper.GetKeys
import com.globant.marvelcharacters.mapper.CharacterDetailMapper
import com.globant.marvelcharacters.mapper.CharacterListMapper
import com.globant.marvelcharacters.ui.details.DetailsViewModel
import com.globant.marvelcharacters.ui.home.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import om.globant.marvelcharacters.mapper.CharacterInfoMapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.Url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideOkhttpClientWithInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val httpUrl: HttpUrl = original.url
            val newhttpUrl: HttpUrl = httpUrl.newBuilder()
                .addQueryParameter(Constants.timestamp, GetKeys.getTimestamp())
                .addQueryParameter(Constants.apikey, GetKeys.getApiKey())
                .addQueryParameter(Constants.hash, GetKeys.getMD5Hash())
                .build()
            val requestBuilder: Request.Builder = original.newBuilder().url(newhttpUrl)
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): DataSource.RemoteDataSource =
        RemoteDataSourceImpl(apiService)

    @Singleton
    @Provides
    fun provideMarvelCharacterListResponseMapper() = MarvelCharacterListResponseMapper()

    @Singleton
    @Provides
    fun provideMarvelCharacterRepository(
        remoteDataSource: DataSource.RemoteDataSource, responseMapper: MarvelCharacterListResponseMapper
    ): MarvelCharacterListRepository =
        MarvelCharactersListRepositoryImpl(responseMapper, remoteDataSource)

    @Singleton
    @Provides
    fun provideMarvelCharacterUseCase(repository: MarvelCharacterListRepository): MarvelCharacterListUseCase =
        MarvelCharacterListUseCase(repository)

    @Singleton
    @Provides
    fun provideCharacterDetailModelMapper() = CharacterInfoMapper()

    @Singleton
    @Provides
    fun provideCharacterNameModelMapper() = CharacterListMapper()

    @Singleton
    @Provides
    fun provideCharacterDetailMapper() = CharacterDetailMapper()

    @Singleton
    @Provides
    fun provideHomeViewModel(
        searchCharacterUseCase: MarvelCharacterListUseCase,
        characterInfoMapper: CharacterInfoMapper,
        characterNameMapper: CharacterListMapper
    ): HomeViewModel =
        HomeViewModel(searchCharacterUseCase, characterInfoMapper, characterNameMapper)

    @Provides
    fun provideDetailsViewModel(
        characterDetailMapper: CharacterDetailMapper
    ): DetailsViewModel =
        DetailsViewModel(
            characterDetailMapper
        )
}