#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_globant_cleanmvvm_ui_MainActivity_getApi(JNIEnv *env, jobject instance) {
return (*env)-> NewStringUTF(env, "developer key");
}

JNIEXPORT jstring JNICALL
Java_com_globant_sampleapp_helper_GetKeys_getApiKey(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "b98042256c6f6ab2043755eecba38f34");
}

JNIEXPORT jstring JNICALL
Java_com_globant_sampleapp_helper_GetKeys_getMD5Hash(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "3644a20f68f955a83ffbbd7cbe354f7e");
}

JNIEXPORT jstring JNICALL
Java_com_globant_sampleapp_helper_GetKeys_getPrivateKey(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "d51052a9aa8fe646b9a2ca7011a81c09e64816b4");
}

JNIEXPORT jstring JNICALL
Java_com_globant_sampleapp_helper_GetKeys_getPublicKey(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "b98042256c6f6ab2043755eecba38f34");
}
