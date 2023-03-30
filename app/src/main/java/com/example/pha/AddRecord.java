package com.example.pha;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.io.IOException;

public class AddRecord extends AppCompatActivity {
    private ImageView photo_imgVw;
    private EditText docName_et,phone_et,specialist_et,disease_et,medicine_et;
    private ListView medicine_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);


        photo_imgVw=findViewById(R.id.addrecA_photo_imgVw);
        docName_et=findViewById(R.id.addrecA_docname_edtTxt);
        phone_et=findViewById(R.id.addrecA_phnno_edtTxt);
        specialist_et=findViewById(R.id.addrecA_specialist_edtTxt);
        disease_et=findViewById(R.id.addrecA_disease_edtTxt);
        medicine_et=findViewById(R.id.addrecA_med_edtTxt);
        medicine_lv=findViewById(R.id.addrecA_med_listVw);






    }

    private void imageChooser() {
        if (Build.VERSION.SDK_INT <19){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            launchSomeActivity.launch(intent);
        } else {
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            launchSomeActivity.launch(intent);
        }
    }
        ActivityResultLauncher<Intent> launchSomeActivity
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    Uri originalUri;
                    // do your operation from here....


                    if (Build.VERSION.SDK_INT < 19) {
                        originalUri= data.getData();
                    } else {
                        originalUri= data.getData();
                        final int takeFlags = data.getFlags()
                                & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

                        try {
                            AddRecord.this.getContentResolver().takePersistableUriPermission(originalUri, takeFlags);
                        }
                        catch (SecurityException e){
                            e.printStackTrace();
                        }
                    }
                    Bitmap selectedImageBitmap = null;



                    try {
                        selectedImageBitmap
                                = MediaStore.Images.Media.getBitmap(
                                AddRecord.this.getContentResolver(),
                                originalUri);
                        photo_imgVw.setImageBitmap(selectedImageBitmap);

                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                        // Code for showing progressDialog while uploading
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setPhotoUri(originalUri)
                                .build();

                        user.updateProfile(profileUpdates)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "User profile updated.");
                                            Toast.makeText(AddRecord.this, "Profile successfully updated", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                });


                    } catch (IOException e) {
                        e.printStackTrace();
                    }








/*



                    if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap = null;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    AddRecord.this.getContentResolver(),
                                    selectedImageUri);
                            photo_imgVw.setImageBitmap(selectedImageBitmap);

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            // Code for showing progressDialog while uploading
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setPhotoUri(selectedImageUri)
                                    .build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d(TAG, "User profile updated.");
                                                Toast.makeText(AddRecord.this, "Profile successfully updated", Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });


                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }*/
                }
            });




}