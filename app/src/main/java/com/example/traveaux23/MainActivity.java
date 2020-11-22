package com.example.traveaux23;



import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {
    private Button ButtonWeb;
    private EditText site;
    private EditText location;
    private Button ButtonLocation;
    private ImageView imV ;
    private Button buttonCamera;
 /*   Uri image_uri;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int PERMISSION_CODE = 1000;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("question1","new Intent(String action)\n");
        Log.d("question3","Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);");
        Log.d("question2","Ne spécifiez pas l'activité ou autre composant spécifique à lancer");
        ButtonWeb=(Button)findViewById(R.id.button1);
        site=(EditText)findViewById(R.id.web);
        location=(EditText)findViewById(R.id.location);
        ButtonLocation=(Button)findViewById(R.id.button2);
        imV=(ImageView)findViewById(R.id.imageView);
        buttonCamera=(Button)findViewById(R.id.button4);}
    public void ouvreWeb(View view) {

        String url = site.getText().toString();


        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void OpLocation(View view){
        String url=location.getText().toString();
        Uri locat=Uri.parse("geo:0,0?q=\\" +url);
        Intent intent=new Intent(Intent.ACTION_VIEW,locat);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
    public void Share(View view) {
        String text=location.getText().toString();
        String type="text/plain";
        ShareCompat.IntentBuilder.from(this).setType(type).setChooserTitle(R.string.share).setText(text).startChooser();
    }



       /* buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if system os is >= marshmallow, request runtime permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED){
                        //permission not enabled, request it
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //show popup to request permissions
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        openCamera();
                    }
                }
                else {
                    //system os < marshmallow
                    openCamera();
                }
            }
        });*/


   /* private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //Camera intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
        imV.setImageURI(image_uri);
    }
*/





 /*   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //this method is called, when user presses Allow or Deny from Permission Request Popup
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    //permission from popup was granted
                    openCamera();
                }
                else {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //called when image was captured from camera

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //set the image captured to our ImageView
            imV.setImageURI(image_uri);
        }
    }*/

}