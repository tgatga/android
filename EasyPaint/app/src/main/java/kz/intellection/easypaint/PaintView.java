package kz.intellection.easypaint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class PaintView extends View {
    public static int brush_Size = 10;
    public static final int BG_COLOR = Color.WHITE;
    public static final int DEF_COLOR = Color.BLACK;

    public static final float TOLERANCE = 0;
    private float mX, mY;
    private Path mPath;
    private Paint mPaint;
    private ArrayList<FingerPath> paths = new ArrayList<>();
    private int backgroundColor = BG_COLOR;
    private int strokeWidth;
    private Bitmap mBitmap;
    private Canvas mCanvas;



    public PaintView(Context context, @Nullable AttributeSet atts){
        super(context, atts);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(DEF_COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

    }

    public void init(DisplayMetrics metrics) {
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        strokeWidth = brush_Size;
    }

    public void clear() {
        backgroundColor = BG_COLOR;
        paths.clear();
        invalidate();
    }

    protected void onDraw(Canvas canvas){
        canvas.save();
        mCanvas.drawColor(backgroundColor);
        for(FingerPath fp:paths){
            mPaint.setStrokeWidth(fp.strokeWidth);
            mCanvas.drawPath(fp.path, mPaint);

        }
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        canvas.restore();
    }

    private void startTouch(float x, float y){
        mPath = new Path();
        FingerPath fp = new FingerPath(strokeWidth,mPath);
        paths.add(fp);
        mPath.reset();
        mPath.moveTo(x,y);
        mX = x;
        mY = y;

    }

    private void moveTouch(float x, float y){
        float dX = Math.abs(x-mX);
        float dY = Math.abs(y-mY);

        if(dX >= TOLERANCE || dY >= TOLERANCE){
            mPath.quadTo(mX,mY,(x+mX)/2, (y+mY)/2);
            mX = x;
            mY = y;
        }

    }

    public  boolean onTouchEvent(MotionEvent event){
        float X = event.getX();
        float Y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startTouch(X,Y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(X,Y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }

    public void setColor(int color){
        mPaint.setColor(color);
    }

    private void upTouch() {
        mPath.lineTo(mX,mY);
    }

    public void setBrushSize(int brushSize) {
        this.strokeWidth = brushSize;
    }
}
