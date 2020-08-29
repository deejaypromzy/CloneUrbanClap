package com.sundram.urbanclapclone.datamodel;

public class dataModelGuranteeSection {

    private String gurantee_tv1, gurantee_subtile_tv;
    private int drawable;

    public dataModelGuranteeSection(){}

    public dataModelGuranteeSection(String gurantee_tv1, String gurantee_subtile_tv, int drawable) {
        this.gurantee_tv1 = gurantee_tv1;
        this.gurantee_subtile_tv = gurantee_subtile_tv;
        this.drawable = drawable;
    }



    public String getGurantee_tv1() {
        return gurantee_tv1;
    }

    public void setGurantee_tv1(String gurantee_tv1) {
        this.gurantee_tv1 = gurantee_tv1;
    }

    public String getGurantee_subtile_tv() {
        return gurantee_subtile_tv;
    }

    public void setGurantee_subtile_tv(String gurantee_subtile_tv) {
        this.gurantee_subtile_tv = gurantee_subtile_tv;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
