aapt package -f \
    --min-sdk-version 17 \
    --target-sdk-version 17 \
    -M AndroidManifest.xml \
    -S res \
    -F game.raw.apk \
    -I "android.jar" \
    output
