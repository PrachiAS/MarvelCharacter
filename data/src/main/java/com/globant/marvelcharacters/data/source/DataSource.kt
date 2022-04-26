package com.globant.marvelcharacters.data.source

import com.globant.marvelcharacters.data.model.MarvelCharactersResponse

interface DataSource {
    interface RemoteDataSource {
        suspend fun getMarvelCharacterList(): MarvelCharactersResponse?
    }
}