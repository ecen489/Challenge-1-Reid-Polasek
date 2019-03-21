package com.example.challengeproject1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
int currID = 1;
//int failed = 0;
SQLiteDatabase images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = openOrCreateDatabase("pictures",MODE_PRIVATE,null);
    }

    public void getImage(android.view.View a){
        //
    }

    public void takeAPicture(android.view.View a){
        //images.execSQL();

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 123);

        /*Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
            c.takePicture(null,null, jpegOut);
            if (c != null){
                c.release();        // release the camera for other applications
                c = null;
            }
            Bitmap bmp = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "output.jpg");
            ImageView img= (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(bmp);

        }
        catch (Exception e){
            String stackTrace = Log.getStackTraceString(e);
            Toast.makeText(this,stackTrace, Toast.LENGTH_LONG).show();
        }

        if (failed == 1){
            Toast.makeText(this,"File IO failed", Toast.LENGTH_LONG).show();
        }*/
        /*Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File cameraOut = new File("out.jpg");
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraOut));
        startActivity(cameraIntent);*/

        currID = currID + 1;
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == 123
                && resultCode == RESULT_OK) {
            Bitmap bmp= (Bitmap) intent.getExtras().get("data");

            ImageView img= (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap(bmp);
            /*Environment.getExternalStorageDirectory();

            try {
                PrintStream output = new PrintStream( openFileOutput("in.txt", MODE_PRIVATE));
                output.println("Hello, world!");
                output.println("How are you?");
                output.close();
                String inloc ="in.txt";
                InputStream in = openFileInput(inloc);
                OutputStream out = openFileOutput("out.txt", MODE_PRIVATE);
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();

                Scanner scan = new Scanner(
                        openFileInput("out.txt"));
                while (scan.hasNextLine()) {
                    String line=scan.nextLine();
                    Toast.makeText(this,line, Toast.LENGTH_SHORT).show();
                }
                scan.close();

            } catch (Exception e){
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
            }*/

        }
    }

    /*private Camera.PictureCallback jpegOut = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            try {
                FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() + "output.jpg");
                fos.write(data);
                fos.close();
            } catch (Exception e) {
                failed = 1;
            }
        }
    };*/
}