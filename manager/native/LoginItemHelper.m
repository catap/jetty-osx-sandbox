#import <Cocoa/Cocoa.h>
#import <ServiceManagement/ServiceManagement.h>

#include <jni.h>


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_setEnabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    return SMLoginItemSetEnabled((__bridge CFStringRef)bundleID, true);
}


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_setDisabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    return SMLoginItemSetEnabled((__bridge CFStringRef)bundleID, false);
}


JNIEXPORT jboolean JNICALL Java_com_github_catap_jetty_1osx_1sandbox_LoginItemHelper_getEnabled
  (JNIEnv *env, jclass thisObj, jstring identifier) {
    const char *nativeID = (*env)->GetStringUTFChars(env, identifier, 0);
    NSString *bundleID = [NSString stringWithFormat:@"%s", nativeID];

    CFArrayRef ref = SMCopyAllJobDictionaries(kSMDomainUserLaunchd);
    NSArray *jobs = (__bridge NSArray *)ref;

    if((jobs != nil) && [jobs count] > 0) {

        for(NSDictionary *job in jobs) {

            if ([bundleID isEqualToString:[job objectForKey:@"Label"]]) {
                    CFRelease(ref);
                    return JNI_TRUE;
            }
        }

        CFRelease(ref);
    }

    return JNI_FALSE;
}

