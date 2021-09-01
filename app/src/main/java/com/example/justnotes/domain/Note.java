package com.example.justnotes.domain;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Note implements Parcelable {

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
    @StringRes
    private final int nameNote;
    @StringRes
    private final int bodyNote;

    public Note(int nameNote, int bodyNote) {
        this.nameNote = nameNote;
        this.bodyNote = bodyNote;
    }

    protected Note(Parcel in) {
        nameNote = in.readInt();
        bodyNote = in.readInt();
    }

    public int getNameNote() {
        return nameNote;
    }

    public int getBodyNote() {
        return bodyNote;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(nameNote);
        parcel.writeInt(bodyNote);
    }
}
