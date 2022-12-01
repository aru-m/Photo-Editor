package com.example.photoeditor;

import static com.example.photoeditor.MainActivity.imgUri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoeditor.databinding.ActivityFinalBinding;
import com.example.photoeditor.databinding.ActivityMainBinding;

public class finalActivity extends AppCompatActivity {

    @NonNull ActivityFinalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Toast.makeText(this, imgUri.toString(), Toast.LENGTH_SHORT).show();
        binding = ActivityFinalBinding.inflate(getLayoutInflater());

        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);

        dsPhotoEditorIntent.setData(imgUri);

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "my editor");

        // int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};

        //dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);


        startActivityForResult(dsPhotoEditorIntent, 200);
    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK) {

                switch (requestCode) {

                    case 200:

                        Uri outputUri = data.getData();

                        // handle the result uri as you want, such as display it in an imageView;

                        binding.imgview.setImageURI(outputUri);

                        break;

                }

            }



    }
}