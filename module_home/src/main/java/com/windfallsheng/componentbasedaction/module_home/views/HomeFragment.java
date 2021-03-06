package com.windfallsheng.componentbasedaction.module_home.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.windfallsheng.componentbasedaction.component_lib.util.Logger;
import com.windfallsheng.componentbasedaction.module_base.command.BaseApplication;
import com.windfallsheng.componentbasedaction.module_base.util.RouteConsts;
import com.windfallsheng.componentbasedaction.module_home.R;

/**
 * @Author: lzsheng
 */
@Route(path = RouteConsts.HOME_FRAGMENT_HOME)
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AppCompatButton mBtnGoToLogin;
    AppCompatButton mBtnIntent;
    AppCompatButton mBtnToMainOtherFragment;
    AppCompatButton mBtnGetDialog;
    AppCompatButton mBtnUri;
    AppCompatButton mBtnForResult;
    AppCompatButton mBtnPay;
    View mView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        mView = inflater.inflate(R.layout.home_fragment_home, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.dl("onActivityCreated#application=" + BaseApplication.getInstance());
        mBtnGoToLogin = mView.findViewById(R.id.btn_goto_login);
        mBtnIntent = mView.findViewById(R.id.btn_intent);
        mBtnGetDialog = mView.findViewById(R.id.btn_get_dialog);
        mBtnToMainOtherFragment = mView.findViewById(R.id.btn_to_main_other_fragment);
        mBtnUri = mView.findViewById(R.id.btn_uri);
        mBtnForResult = mView.findViewById(R.id.btn_for_result);
        mBtnPay = mView.findViewById(R.id.btn_pay);

        mBtnGoToLogin.setOnClickListener(v -> {
            // ???????????????????????????
            ARouter.getInstance()
                    .build(RouteConsts.LOGIN_ACTIVITY_LOGIN)
                    .navigation();
        });
        mBtnIntent.setOnClickListener(v -> {

        });
        mBtnToMainOtherFragment.setOnClickListener(v -> {
            // ?????? MainActivity ????????????fragment???????????????????????????
            // ??????????????? MainActivity ?????????????????????
            ARouter.getInstance()
                    .build(RouteConsts.MAIN_ACTIVITY_MAIN)
                    .withInt("index", 1)
                    .navigation();
        });
        mBtnGetDialog.setOnClickListener(v -> {
            // ???????????????????????? Dialog, ???????????????
            DialogFragment identityChoiceDialogFragment = (DialogFragment) ARouter.getInstance()
                    .build(RouteConsts.MessageModule.MESSAGE_MODULE_FRAGMENT_IDENTITY_CHOICE)
                    .navigation();
            FragmentManager fragmentManager = ((FragmentActivity) getActivity()).getSupportFragmentManager();
            identityChoiceDialogFragment.show(fragmentManager, "identityChoiceDialogFragment");
        });

        mBtnUri.setOnClickListener(v -> {

        });

        mBtnForResult.setOnClickListener(v -> {
//            ??????????????????????????????startActivityForResult
//            navigation???????????????????????????Activity????????????????????????RequestCode
            ARouter.getInstance()
                    .build(RouteConsts.LOGIN_ACTIVITY_FOR_RESULT, "ap")
                    .withInt("index", 1)
                    .navigation(getActivity(), 102);
        });
        mBtnPay.setOnClickListener(v -> {
            ARouter.getInstance()
                    .build(RouteConsts.PayModule.PAY_ACTIVITY_PAY)
                    .navigation(getActivity());
        });
    }

}