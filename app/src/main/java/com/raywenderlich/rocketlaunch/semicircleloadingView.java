package com.raywenderlich.rocketlaunch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import static com.raywenderlich.rocketlaunch.R.attr.colorPrimary;
import static com.raywenderlich.rocketlaunch.R.color.colorPrimaryAlpha;

/**
 * Created by sean on 1/17/17.
 */


public class semicircleloadingView extends View {



    public semicircleloadingView(Context context)
    {
        super(context);

    }
    public semicircleloadingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }
    public semicircleloadingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        // TODO Auto-generated method stub
        super.onDraw(canvas);
        float width = (float) getWidth();
        float height = (float) getHeight();
        float radius;

        if (width > height) {
            radius = height / 4;
        } else {
            radius = width / 2.1f;
        }


        Path path = new Path();
        path.addCircle(width ,
                height , radius,
                Path.Direction.CW);

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        new Color();
        paint.setStrokeWidth(10);
        paint.setAlpha(200);
        paint.setStyle(Paint.Style.FILL);

        Paint alphaPaint = new Paint();
        //alphaPaint.setColor(Color.BLUE);
        alphaPaint.setStrokeWidth(10);
        alphaPaint.setAlpha(200);
        alphaPaint.setStyle(Paint.Style.FILL);
        //alphaPaint.setStyle(Paint.Style.STROKE);
        alphaPaint.setShader(new LinearGradient(0, 0, 0, getHeight() ,
                 Color.parseColor("#00000000"), getResources().getColor(R.color.colorPrimary) , Shader.TileMode.MIRROR));



        float center_x, center_y;
        final RectF oval = new RectF();
        paint.setStyle(Paint.Style.STROKE);
        alphaPaint.setStyle(Paint.Style.STROKE);

        center_x = width / 2;
        center_y = height / 2;

        //Shader gradient = new SweepGradient(center_x,center_y, Color.WHITE, Color.parseColor("#00000000"));
        //alphaPaint.setShader(gradient);

        oval.set(center_x - radius,
                center_y - radius,
                center_x + radius,
                center_y + radius);

        canvas.drawArc(oval, 0, 90, false, alphaPaint);
        canvas.drawArc(oval, 90, 180, false, paint);


        float percent = 50;
        float arcRadius = 360;
        float angle = arcRadius * (percent/100);
        double startX = Math.cos(Math.toRadians(270)) * radius + center_x;
        double startY = Math.sin(Math.toRadians(270)) * radius + center_y;
        double endX = Math.cos(Math.toRadians(270 + angle)) * radius + center_x;
        double endY = Math.sin(Math.toRadians(270 + angle)) * radius + center_y;

        Paint paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        paint2.setStrokeWidth(5);
        paint2.setStyle(Paint.Style.FILL);

        canvas.drawCircle((float)startX, (float)startY, 7, paint2);
        //canvas.drawCircle((float)endX, (float)endY, 5, paint2);


    }
}