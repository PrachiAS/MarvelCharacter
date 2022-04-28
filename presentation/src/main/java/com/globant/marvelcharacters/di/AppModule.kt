package com.globant.marvelcharacters.di

import com.globant.marvelcharacter.data.source.remote.service.ApiService
import com.globant.marvelcharacters.data.mapper.MarvelCharacterDetailResponseMapper
import com.globant.marvelcharacters.data.mapper.MarvelCharacterListResponseMapper
import com.globant.marvelcharacters.data.repositoryimpl.MarvelCharactersDetailRepositoryImpl
import com.globant.marvelcharacters.data.repositoryimpl.MarvelCharactersListRepositoryImpl
import com.globant.marvelcharacters.data.source.DataSource
import com.globant.marvelcharacters.data.source.remote.RemoteDataSourceImpl
import com.globant.marvelcharacters.domain.repository.MarvelCharacterDetailRepository
import com.globant.marvelcharacters.domain.repository.MarvelCharacterListRepository
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase
import com.globant.marvelcharacters.helper.Constants
import com.globant.marvelcharacters.helper.GetKeys
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
    fun provideRemoteDataSource(apiService: ApiService,responseListMapper: MarvelCharacterListResponseMapper,
                                responseDetailMapper: MarvelCharacterDetailResponseMapper): DataSource.RemoteDataSource =
        RemoteDataSourceImpl(apiService,responseListMapper,responseDetailMapper)


    @Singleton
    @Provides
    fun provideMarvelCharacterListResponseMapper() = MarvelCharacterListResponseMapper()
    @Singleton

    @Provides
    fun provideMarvelCharacterDetailsResponseMapper() = MarvelCharacterDetailResponseMapper()

    @Singleton
    @Provides
    fun provideMarvelCharacterRepository(
        remoteDataSource: DataSource.RemoteDataSource,
      //  responseMapper: MarvelCharacterListResponseMapper
    ): MarvelCharacterListRepository =
        MarvelCharactersListRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun provideMarvelCharacterDetailsRepository(
        remoteDataSource: DataSource.RemoteDataSource,
      //  responseMapper: MarvelCharacterDetailResponseMapper
    ): MarvelCharacterDetailRepository =
        MarvelCharactersDetailRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun provideMarvelCharacterUseCase(repository: MarvelCharacterListRepository): MarvelCharacterListUseCase =
        MarvelCharacterListUseCase(repository)


    @Singleton
    @Provides
    fun provideHomeViewModel(
        searchCharacterUseCase: MarvelCharacterListUseCase
    ): HomeViewModel =
        HomeViewModel(searchCharacterUseCase)

    @Provides
    fun provideDetailsViewModel(
        searchCharacterUseCase: MarvelCharacterDetailsUseCase
    ): DetailsViewModel =
        DetailsViewModel(
            searchCharacterUseCase
        )
}