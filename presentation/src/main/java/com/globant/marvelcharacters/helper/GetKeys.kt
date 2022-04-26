package com.globant.marvelcharacters.helper

object GetKeys {
    init {
        System.loadLibrary("keys")
    }

    external fun getApiKey(): String
    external fun getMD5Hash(): String
    external fun getPublicKey(): String
    external fun getPrivateKey(): String
    external fun getTimestamp(): String
}