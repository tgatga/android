package kz.intellection.easypaint;

import android.graphics.Path;

class FingerPath {
    public int strokeWidth;
    public Path path;

    public FingerPath(int strokeWidth, Path path){
        this.strokeWidth = strokeWidth;
        this.path = path;

    }
}
