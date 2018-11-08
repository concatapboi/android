package com.example.hien.ot;

class Prisoner {
    private String name;
    private int gt;
    private int cmnd;
    private String phone;

    public Prisoner(String name, int gt, int cmnd, String phone) {
        this.name = name;
        this.gt = gt;
        this.cmnd = cmnd;
        this.phone = phone;
    }

    public Prisoner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGt() {
        return gt;
    }

    public void setGt(int gt) {
        this.gt = gt;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
