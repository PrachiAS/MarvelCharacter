package om.globant.marvelcharacters.mapper

import com.globant.marvelcharacters.domain.model.MarvelCharacterDetails
import com.globant.marvelcharacters.mapper.ModelMapper
import com.globant.marvelcharacters.model.CharacterInfoModel

class CharacterInfoMapper :
    ModelMapper<MarvelCharacterDetails, CharacterInfoModel> {

    override fun toModel(request: MarvelCharacterDetails?): CharacterInfoModel {
        return CharacterInfoModel(
            request?.name,
            request?.thumbnailUrl,
            request?.description,
            request?.availableComics,
            request?.comicNames,
            request?.availableSeries,
            request?.availableStories,
            request?.availableEvents
        )
    }
}