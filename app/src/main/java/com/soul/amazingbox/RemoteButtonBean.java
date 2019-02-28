package com.soul.amazingbox;

/**
 * Created by Administrator on 2018/7/19.
 */
public class RemoteButtonBean {
    String mPos;
    String mKeyName;

    public RemoteButtonBean(String mPos, String mKeyName, String mFlag) {
        this.mPos = mPos;
        this.mKeyName = mKeyName;
        this.mFlag = mFlag;
    }

    String mFlag;

    public RemoteButtonBean() {
    }

    public String getmPos() {
        return mPos;
    }

    public void setmPos(String mPos) {
        this.mPos = mPos;
    }

    public String getmFlag() {
        return mFlag;
    }

    public void setmFlag(String mFlag) {
        this.mFlag = mFlag;
    }

    public String getmKeyName() {
        return mKeyName;
    }

    public void setmKeyName(String mKeyName) {
        this.mKeyName = mKeyName;
    }
}
