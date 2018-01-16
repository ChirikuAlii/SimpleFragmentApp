package com.example.chiriku711.myflexiblefragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose , btnClose;
    private RadioGroup rgOptions;
    private OnOptionDialogListener onOptionDialogListener;
    private RadioButton rbSaf, rbMou , rbLvg , rbMoyes;

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }



    public OptionDialogFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);;
        btnChoose = view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);

        btnClose = view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        rgOptions = view.findViewById(R.id.rg_options);

        rbSaf = view.findViewById(R.id.rb_saf);
        rbLvg = view.findViewById(R.id.rb_lvg);
        rbMou = view.findViewById(R.id.rb_mou);
        rbMoyes = view.findViewById(R.id.rb_moyes);
        return view;

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_close){
            getDialog().cancel();
        }

        if (v.getId() == R.id.btn_choose){
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

            if (checkedRadioButtonId != 0){
                String coach =null;

                switch (checkedRadioButtonId){

                    case R.id.rb_saf:
                        coach = rbSaf.getText().toString().trim();
                        break;

                    case R.id.rb_lvg:
                        coach = rbLvg.getText().toString().trim();
                        break;
                    case R.id.rb_mou:
                        coach = rbMou.getText().toString().trim();
                        break;

                    case R.id.rb_moyes :
                        coach =rbMoyes.getText().toString().trim();
                }
                getOnOptionDialogListener().onOptionChoosen(coach);
                getDialog().cancel();
            }
        }
    }


    public  interface OnOptionDialogListener{
        void onOptionChoosen (String text);
    }
}
