package com.globant.marvelcharacters.mapper

interface ModelMapper<P, Q> {
    fun toModel(request: P?): Q
}