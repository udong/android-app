package haninkyu.yoo_dong.done.presenter.communication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import haninkyu.yoo_dong.done.model.Constant;
import haninkyu.yoo_dong.done.view.main.fragment.MainFragment;
import haninkyu.yoo_dong.doing.model.ClubData;

/**
 * Created by IVE on 2015-10-06.
 */
public class HttpPostConnection extends AsyncTask<Object, Void, Boolean> {
    private String protocol;
    private String table;
    private ProgressDialog mDlg;
    private Activity mContext;
    private JSONObject resultObj;
    private RestTemplate restTemplate;

    public HttpPostConnection(Activity mContext) {
        // 버전 테스트
        this.mContext = mContext;
        this.mDlg = new ProgressDialog(mContext);
    }

    @Override
    protected void onPreExecute() {
        mDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDlg.setMessage("Loading..");
        mDlg.setCancelable(false);
        mDlg.show();
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Object... params) {
        protocol = (String) params[0];

        String url = Constant.IP+"/"+protocol;

        ClubData temp = new ClubData();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.postForObject(url, temp, String.class);
//        restTemplate.put(url, temp, parameter);

        /*
        try {

            // The connection URL
            String url = Constant.IP + table + "/" + protocol;

            // Create a new RestTemplate instance
            restTemplate = new RestTemplate();

            // Add the String message converter
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            // Make the HTTP GET request, marshaling the response to a String
            String result = restTemplate.getForObject(url, String.class, "Android");
            resultObj = new JSONObject(result);

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        mDlg.dismiss();
        switch (protocol) {
            case "list":
                if (table.equals("club")) {
                    ((MainFragment) mContext.getFragmentManager().findFragmentByTag("main")).setResult(resultObj);
                }
                break;
            case "clubs":
                if (table.equals("club")) {
                    ((MainFragment) mContext.getFragmentManager().findFragmentByTag("main")).setResult(resultObj);
                }
                break;
        }
    }

}
