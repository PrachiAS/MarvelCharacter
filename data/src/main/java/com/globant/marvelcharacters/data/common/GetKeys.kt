package com.globant.marvelcharacters.data.common

object GetKeys {

    init {
        TODO("Remove unwanted code/logs")
        System.loadLibrary("keys")
        System.out.println("@@@...api key " + getApiKey())
        System.out.println("@@@...hash " + getMD5Hash())
        System.out.println("@@@....private key " + getPrivateKey())
        System.out.println("@@@...public key " + getPublicKey())
    }

    external fun getApiKey(): String
    external fun getMD5Hash(): String
    external fun getPublicKey(): String
    external fun getPrivateKey(): String
}