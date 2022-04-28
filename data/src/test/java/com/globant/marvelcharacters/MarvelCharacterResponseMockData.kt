package com.globant.marvelcharacters

import com.globant.marvelcharacters.data.model.Comics
import com.globant.marvelcharacters.data.model.Data
import com.globant.marvelcharacters.data.model.Item
import com.globant.marvelcharacters.data.model.Events
import com.globant.marvelcharacters.data.model.Series
import com.globant.marvelcharacters.data.model.Stories
import com.globant.marvelcharacters.data.model.MarvelCharactersResponse
import com.globant.marvelcharacters.data.model.ItemX
import com.globant.marvelcharacters.data.model.ItemXX
import com.globant.marvelcharacters.data.model.ItemXXX
import com.globant.marvelcharacters.data.model.Thumbnail
import com.globant.marvelcharacters.data.model.Url
import com.globant.marvelcharacters.data.model.Result
import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.domain.model.MarvelCharacterNameModel
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterDetailsUseCase
import com.globant.marvelcharacters.domain.usecase.MarvelCharacterListUseCase


val mockMarvelCharacterListDataResponse = MarvelCharactersResponse(
    "\"<a href=\\\"http://marvsel.com\\\">Data provided by Marvel.MARVXEL</a>\",",
    "\"Data provided by Marvel. MARXVEL\"",
    200,
    "MARVXEL",
    Data(
        2, 2, 0,
        listOf(
            Result(
                Comics(
                    4, "http://gatesway.marvel.com/v1",
                    listOf(
                        Item(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gatesway.marvel.com/v1"
                        )
                    ),
                    4
                ),
                "Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction!",
                Events(
                    4,
                    "",
                    listOf(
                        ItemX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1"
                        )
                    ),
                    2
                ),
                1,
                "2013-09-18T15:54:04-0400",
                "abc",
                "http://gateway.marvel.com/v1/public/characters/5",
                Series(
                    4,
                    "",
                    listOf(
                        ItemXX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1"
                        )
                    ),
                    2
                ),
                Stories(
                    4,
                    "",
                    listOf(
                        ItemXXX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1",
                            "type"
                        )
                    ),
                    2
                ),
                Thumbnail("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/d/03/58dd080719806"),
                listOf(Url("detail", ""))
            ),
            Result(
                Comics(
                    5, "http://gateway.marvel.com/v1",
                    listOf(
                        Item(
                            "PAID COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1"
                        )
                    ),
                    4
                ),
                "AIM is a terrorist organization bent on destroying the world.",
                Events(
                    4,
                    "",
                    listOf(
                        ItemX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1"
                        )
                    ),
                    2
                ),
                5,
                "2013-09-18T15:54:04-0400",
                "A.I.M",
                "http://gateway.marvel.com/v1/public/characters/5",
                Series(
                    3,
                    "",
                    listOf(
                        ItemXX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1"
                        )
                    ),
                    2
                ),
                Stories(
                    4,
                    "",
                    listOf(
                        ItemXXX(
                            "FREE COMIC BOOK DAY 2013 1 (2013) #1",
                            "http://gateway.marvel.com/v1",
                            "type"
                        )
                    ),
                    2
                ),
                Thumbnail("jpg", "http://i.annihil.us/u/prod/marvel/i/mg/d/03/58dd080719806"),
                listOf(Url("detail", ""))
            )
        ),
        2),
    "abcb4bf444a41e6b9849388fb33bd9xyz",
    "ok"
)


val mockGetMarvelCharacterListResponse = MarvelCharacterListUseCase.MarvelCharacterListResponse(
    characterModel = listOf(
        MarvelCharacterNameModel(1, "abc"),
        MarvelCharacterNameModel(2, "abcde")
    )
)

val mockMarvelCharacterDetailsResponse =
    MarvelCharacterDetailsUseCase.MarvelCharacterDetailResponse(
        characterModel = MarvelCharacterDetails(
            id = 5,
            name = "abc",
            thumbnailUrl = "http://thumbnail.url.jpg",
            description = "This is dummy data",
            availableComics = 4,
            comicNames = listOf("ABC", "XYZ"),
            availableSeries = 5,
            availableStories = 3,
            availableEvents = 2
        )
    )




