package com.example.pha.Fragments;

import static androidx.constraintlayout.widget.Constraints.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pha.AddHealthInfo;
import com.example.pha.AddRecord;
import com.example.pha.HomeActivity;
import com.example.pha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView dp_imVw;
    private Button done_btn;
    private ImageButton back_imBtn;
    int SELECT_PICTURE = 200;

    FirebaseAuth mFireBaseAuth;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;

    FirebaseStorage storage;
    StorageReference storageReference;

    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        dp_imVw = view.findViewById(R.id.dr_rcy_item_dp);
        done_btn = view.findViewById(R.id.frag3_done_btn);
        back_imBtn = view.findViewById(R.id.frag3_back_imBtn);

        mFireBaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = mFirebaseDatabase.getReference("UserInfo");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        dp_imVw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((AddHealthInfo) getActivity()).getDataFromFragments();


                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i); // invoke the SecondActivity.
                getActivity().finish();
            }
        });

        back_imBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AddHealthInfo) getActivity()).replaceFragments(2);
            }
        });


        return view;
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




      /*  Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        launchSomeActivity.launch(i);*/
    }

    ActivityResultLauncher<Intent> launchSomeActivity
            = registerForActivityResult(
            new ActivityResultContracts
                    .StartActivityForResult(),
            result -> {
                if (result.getResultCode()
                        == Activity.RESULT_OK) {
                    Intent data = result.getData();




                  //  Intent data = result.getData();
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
                            getActivity().getContentResolver().takePersistableUriPermission(originalUri, takeFlags);
                        }
                        catch (SecurityException e){
                            e.printStackTrace();
                        }
                    }
                    Bitmap selectedImageBitmap = null;



                    try {
                        selectedImageBitmap
                                = MediaStore.Images.Media.getBitmap(
                                getActivity().getContentResolver(),
                                originalUri);
                        dp_imVw.setImageBitmap(selectedImageBitmap);

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
                                            Toast.makeText(getActivity(), "Profile successfully updated", Toast.LENGTH_LONG).show();

                                        }
                                    }
                                });


                    } catch (IOException e) {
                        e.printStackTrace();
                    }











                    // do your operation from here....
               /*     if (data != null
                            && data.getData() != null) {
                        Uri selectedImageUri = data.getData();
                        Bitmap selectedImageBitmap = null;
                        try {
                            selectedImageBitmap
                                    = MediaStore.Images.Media.getBitmap(
                                    getActivity().getContentResolver(),
                                    selectedImageUri);
                            dp_imVw.setImageBitmap(selectedImageBitmap);

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
                                                Toast.makeText(getActivity(), "Profile successfully updated", Toast.LENGTH_LONG).show();

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