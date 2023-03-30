package com.example.pha.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pha.AddHealthInfo;
import com.example.pha.R;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
/*
    String[] items = {"A+","A-","B+","B-","AB","O+"};
    AutoCompleteTextView auto_c_txt;
    ArrayAdapter<String> adapterItems;
*/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText age_edTxt, height_ft_edTxt, height_in_edTxt, weight_edTxt;
    private RadioGroup bp_rGp,sg_rGp,v_rGp;
    private ImageButton back_imBtn;
    private Button next_Btn;
    private Spinner bloodGroup_spinner;
    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_2, container, false);

        age_edTxt = view.findViewById(R.id.frag2_age_edTxt);
        height_ft_edTxt = view.findViewById(R.id.frag2_height_ft_edTxt);
        height_in_edTxt = view.findViewById(R.id.frag2_height_inc_edTxt);
        weight_edTxt = view.findViewById(R.id.frag2_weight_edTxt);



        next_Btn=view.findViewById(R.id.frag2_next_btn);
        back_imBtn=view.findViewById(R.id.frag2_back_imBtn);


        String[] items = {"A+","A-","B+","B-","AB","O+"};

        //spinner for blood group not working
       bloodGroup_spinner = view.findViewById(R.id.spinner_blood);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        bloodGroup_spinner.setAdapter(arrayAdapter);




        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AddHealthInfo)getActivity()).replaceFragments(3);
            }
        });

        back_imBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AddHealthInfo)getActivity()).replaceFragments(1);
            }
        });
/*

        //int age = Integer.parseInt(age_edTxt.getText().toString());
        //int height_in = Integer.parseInt(height_in_edTxt.getText().toString());
        //int height_ft = Integer.parseInt(height_ft_edTxt.getText().toString());
        //int weight = Integer.parseInt(weight_edTxt.getText().toString());
        String age = age_edTxt.getText().toString();
        String height_in = height_in_edTxt.getText().toString();
        String height_ft = height_ft_edTxt.getText().toString();
        String weight = weight_edTxt.getText().toString();
        String bp_hgh = bp_high_edTxt.getText().toString();
        String bp_low = bp_low_edTxt.getText().toString();
        String sgr_yes = sgr_yes_edTxt.getText().toString();
        String sgr_no = sgr_no_edTxt.getText().toString();
        String vac_yes = vac_yes_edTxt.getText().toString();
        String vac_no = vac_no_edTxt.getText().toString();

        //check
        if(TextUtils.isEmpty(age)){
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(height_in)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(height_ft)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(weight)){
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(bp_hgh)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(bp_low)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(sgr_yes)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(sgr_no)){
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(vac_yes)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else if (TextUtils.isEmpty(vac_no)) {
            age_edTxt.setError("Please fill the info");
            age_edTxt.requestFocus();
        } else {
            //done

        }*/



        return view;
    }
}