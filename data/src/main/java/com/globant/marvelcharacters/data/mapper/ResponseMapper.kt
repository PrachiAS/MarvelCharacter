package com.globant.marvelcharacters.data.mapper

import com.globant.marvelcharacters.domain.usecase.BaseUseCase

interface ResponseMapper<P, Q : BaseUseCase.Response> {
    fun toModel(response: P?): Q
}