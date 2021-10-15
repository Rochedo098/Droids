package com.github.rochedo098.droidsapi.api;

/**
 *  This interface is a extension of MixinPlayerEntity to facility the access of player parts
 *  and this not is working
 */
@Deprecated
public interface PlayerExpansion {
    /* Getting Values */
    boolean getEntityModified();
    int[] getModules();

    String getBrain();
    String getHeart();
    String getLungs();
    String getEyes();

    String getLeftArm();
    String getLeftLeg();

    String getRightArm();
    String getRightLeg();

    String getStomach();
    String getHead();

    /* Setting Values */
    void setEntityModified(boolean entityModified);
    void setModules(int[] modules);

    void setBrain(String brain);
    void setHeart(String heart);
    void setLungs(String lungs);
    void setEyes(String eyes);

    void setLeftArm(String leftArm);
    void setLeftLeg(String leftLeg);

    void setRightArm(String rightArm);
    void setRightLeg(String rightLeg);

    void setStomach(String stomach);
    void setHead(String head);
}
