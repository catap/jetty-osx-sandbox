#import <Cocoa/Cocoa.h>
#import <ServiceManagement/ServiceManagement.h>

#include <jni.h>


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_setEnabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    return SMLoginItemSetEnabled(bundleID, true);
}


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_setDisabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    return SMLoginItemSetEnabled(bundleID, false);
}


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_getEnabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    NSArray * jobDicts = nil;

    jobDicts = (NSArray *)SMCopyAllJobDictionaries( kSMDomainUserLaunchd );

    if ( (jobDicts != nil) && [jobDicts count] > 0 ) {

        for ( NSDictionary * job in jobDicts ) {

            if ( [bundleID isEqualToString:[job objectForKey:@"Label"]] ) {
                    CFRelease((CFDictionaryRef)jobDicts); jobDicts = nil;
                    return JNI_TRUE;
            }
        }

        CFRelease((CFDictionaryRef)jobDicts); jobDicts = nil;
    }

    return JNI_FALSE;
}

