/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.ondevicepersonalization;

import android.annotation.NonNull;
import android.os.Parcelable;

import com.android.ondevicepersonalization.internal.util.AnnotationValidations;
import com.android.ondevicepersonalization.internal.util.DataClass;

/**
 * App installed status for app installed history.
 *
 * @hide
 */
@DataClass(genBuilder = true, genEqualsHashCode = true)
public final class AppInstallStatus implements Parcelable {
    /** Package name. */
    @NonNull String mPackageName;

    /** Installed status: installed - true; uninstalled - false. */
    @NonNull boolean mInstalled;



    // Code below generated by codegen v1.0.23.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/packages/modules/OnDevicePersonalization/framework/java/android/ondevicepersonalization/AppInstallStatus.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    @DataClass.Generated.Member
    /* package-private */ AppInstallStatus(
            @NonNull String packageName,
            @NonNull boolean installed) {
        this.mPackageName = packageName;
        AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mInstalled = installed;
        AnnotationValidations.validate(
                NonNull.class, null, mInstalled);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * Package name.
     */
    @DataClass.Generated.Member
    public @NonNull String getPackageName() {
        return mPackageName;
    }

    /**
     * Installed status: installed - true; uninstalled - false.
     */
    @DataClass.Generated.Member
    public @NonNull boolean isInstalled() {
        return mInstalled;
    }

    @Override
    @DataClass.Generated.Member
    public boolean equals(@android.annotation.Nullable Object o) {
        // You can override field equality logic by defining either of the methods like:
        // boolean fieldNameEquals(AppInstallStatus other) { ... }
        // boolean fieldNameEquals(FieldType otherValue) { ... }

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("unchecked")
        AppInstallStatus that = (AppInstallStatus) o;
        //noinspection PointlessBooleanExpression
        return true
                && java.util.Objects.equals(mPackageName, that.mPackageName)
                && mInstalled == that.mInstalled;
    }

    @Override
    @DataClass.Generated.Member
    public int hashCode() {
        // You can override field hashCode logic by defining methods like:
        // int fieldNameHashCode() { ... }

        int _hash = 1;
        _hash = 31 * _hash + java.util.Objects.hashCode(mPackageName);
        _hash = 31 * _hash + Boolean.hashCode(mInstalled);
        return _hash;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        byte flg = 0;
        if (mInstalled) flg |= 0x2;
        dest.writeByte(flg);
        dest.writeString(mPackageName);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ AppInstallStatus(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        byte flg = in.readByte();
        boolean installed = (flg & 0x2) != 0;
        String packageName = in.readString();

        this.mPackageName = packageName;
        AnnotationValidations.validate(
                NonNull.class, null, mPackageName);
        this.mInstalled = installed;
        AnnotationValidations.validate(
                NonNull.class, null, mInstalled);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<AppInstallStatus> CREATOR
            = new Parcelable.Creator<AppInstallStatus>() {
        @Override
        public AppInstallStatus[] newArray(int size) {
            return new AppInstallStatus[size];
        }

        @Override
        public AppInstallStatus createFromParcel(@NonNull android.os.Parcel in) {
            return new AppInstallStatus(in);
        }
    };

    /**
     * A builder for {@link AppInstallStatus}
     */
    @SuppressWarnings("WeakerAccess")
    @DataClass.Generated.Member
    public static final class Builder {

        private @NonNull String mPackageName;
        private @NonNull boolean mInstalled;

        private long mBuilderFieldsSet = 0L;

        /**
         * Creates a new Builder.
         *
         * @param packageName
         *   Package name.
         * @param installed
         *   Installed status: installed - true; uninstalled - false.
         */
        public Builder(
                @NonNull String packageName,
                @NonNull boolean installed) {
            mPackageName = packageName;
            AnnotationValidations.validate(
                    NonNull.class, null, mPackageName);
            mInstalled = installed;
            AnnotationValidations.validate(
                    NonNull.class, null, mInstalled);
        }

        public Builder() {
        }

        /**
         * Package name.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setPackageName(@NonNull String value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x1;
            mPackageName = value;
            return this;
        }

        /**
         * Installed status: installed - true; uninstalled - false.
         */
        @DataClass.Generated.Member
        public @NonNull Builder setInstalled(@NonNull boolean value) {
            checkNotUsed();
            mBuilderFieldsSet |= 0x2;
            mInstalled = value;
            return this;
        }

        /** Builds the instance. This builder should not be touched after calling this! */
        public @NonNull AppInstallStatus build() {
            checkNotUsed();
            mBuilderFieldsSet |= 0x4; // Mark builder used

            AppInstallStatus o = new AppInstallStatus(
                    mPackageName,
                    mInstalled);
            return o;
        }

        private void checkNotUsed() {
            if ((mBuilderFieldsSet & 0x4) != 0) {
                throw new IllegalStateException(
                        "This Builder should not be reused. Use a new Builder instance instead");
            }
        }
    }

    @DataClass.Generated(
            time = 1676499861915L,
            codegenVersion = "1.0.23",
            sourceFile = "packages/modules/OnDevicePersonalization/framework/java/android/ondevicepersonalization/AppInstallStatus.java",
            inputSignatures = " @android.annotation.NonNull java.lang.String mPackageName\n @android.annotation.NonNull boolean mInstalled\nclass AppInstallStatus extends java.lang.Object implements [android.os.Parcelable]\n@com.android.ondevicepersonalization.internal.util.DataClass(genBuilder=true, genEqualsHashCode=true)")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
