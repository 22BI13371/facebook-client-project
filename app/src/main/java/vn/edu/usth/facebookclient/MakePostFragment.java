package vn.edu.usth.facebookclient;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.share.Share;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MakePostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MakePostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ShareButton sbPhoto;
    private ShareButton sbLink;
    private CallbackManager callbackManager;
    private ActivityResultLauncher<Intent> activityResultLauncher;


    public MakePostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MakePostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MakePostFragment newInstance(String param1, String param2) {
        MakePostFragment fragment = new MakePostFragment();
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
        View view = inflater.inflate(R.layout.fragment_make_post, container, false);

        sbPhoto = view.findViewById(R.id.sb_photo);
        sbLink = view.findViewById(R.id.sb_link);

        ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.facebook.com/profile.php?id=61565407254332"))
                .setShareHashtag(new ShareHashtag.Builder()
                        .setHashtag("#FacebookClientProject").build())
                .build();

        sbLink.setShareContent(shareLinkContent);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.a7, null);
        Bitmap bitmap = bitmapDrawable.getBitmap();

        SharePhoto sharePhoto = new SharePhoto.Builder()
                .setBitmap(bitmap)
                .build();

        SharePhotoContent sharePhotoContent = new SharePhotoContent.Builder()
                .addPhoto(sharePhoto)
                .build();

        sbPhoto.setShareContent(sharePhotoContent);

        // Inflate the layout for this fragment
        return view;
    }
}