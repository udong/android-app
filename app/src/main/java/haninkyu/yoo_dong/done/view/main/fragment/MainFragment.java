package haninkyu.yoo_dong.done.view.main.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import org.json.JSONObject;

import haninkyu.yoo_dong.R;
import haninkyu.yoo_dong.done.view.main.gridview.MainGridView;
import haninkyu.yoo_dong.done.presenter.communication.HttpPostConnection;
import haninkyu.yoo_dong.done.view.activity.BaseMainActivity;

public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BaseMainActivity mActivity;
    private GridLayout grid;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
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
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        grid = (GridLayout) rootView.findViewById(R.id.grid);

        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();
        new HttpPostConnection(mActivity).execute("club", "list");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseMainActivity) activity;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
    @Override
    public void onResume() {
        super.onResume();
        mActivity.nowBtn("main");
    }

    public void setResult(JSONObject result){
        for(int i=0; i<2; i++){
            MainGridView view = new MainGridView(mActivity);
            view.addTestView();
            grid.addView(view);
        }
        MainGridView view = new MainGridView(mActivity);
        view.addPlusView();
        grid.addView(view);
        /*JSONArray temp = null;
        try {
            temp = result.getJSONArray("clubList");
            for(int i=0; i<temp.length(); i++){
                MainGridView view = new MainGridView(mActivity);
                view.addView(temp.getJSONObject(i));
                Log.i(Constant.LOG, i+"번째");
                grid.addView(view);
            }
            grid.invalidate();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}
