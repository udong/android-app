/*
 * Copyright (c) 2015.  In-Kyu Heyden Han
 * 문의 : dlsrb0412@naver.com
 */

package haninkyu.yoo_dong.doing.control;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import haninkyu.yoo_dong.doing.model.BoardData;
import haninkyu.yoo_dong.doing.model.MyData;
import haninkyu.yoo_dong.done.model.Constant;

/**
 * Created by IVE on 2015-10-06.
 */
public class HttpTestConnection extends AsyncTask<Object, Void, Boolean> {
    private String protocol;
    private String table;
    private ProgressDialog mDlg;
    private Activity mContext;
    private ResponseEntity<String> resultObj;
    private ResponseEntity<MyData> requestObj;
    private RestTemplate restTemplate;
    private MyData data;
    private MultiValueMap<String, String> header;

    public HttpTestConnection(Activity mContext) {
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

        String url = Constant.IP+"boards";

        List<HttpMessageConverter<?>> messageConverters = new  ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        data = new BoardData();
        header = new HttpHeaders();
        header.set("Connection", "Close");
        requestObj = new ResponseEntity<MyData>(data, header, HttpStatus.OK);

     /*   // POST 동아리 생성
        data = new ClubData();
        RestTemplate restTemplate = new RestTemplate();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new FormHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        resultObj = restTemplate.exchange(url, HttpMethod.POST, requestObj, String.class);
        Log.i("?!?!?!?!?", resultObj.toString());


*/
        // POST 게시판 생성
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        resultObj = restTemplate.exchange(url, HttpMethod.POST, requestObj, String.class);
        Log();

        // GET 게시판 조회
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        resultObj = restTemplate.exchange(url+"/1", HttpMethod.GET, requestObj, String.class);
        Log();

        // PUT 게시판 수정
        ((BoardData)requestObj.getBody()).setTitle("안녕히계세요");
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        resultObj = restTemplate.exchange(url+"/1", HttpMethod.PUT, requestObj, String.class);
        Log();


        // DELETE 게시판 삭제
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(messageConverters);
        header.set("Content-Length", "0");
        requestObj = new ResponseEntity<MyData>(data, header, HttpStatus.OK);
        resultObj = restTemplate.exchange(url+"/1", HttpMethod.DELETE, requestObj, String.class);
        Log();

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
            /*case "list":
                if (table.equals("club")) {
                    //((MainFragment) mContext.getFragmentManager().findFragmentByTag("main")).setResult(resultObj);
                }
                break;
            case "clubs":
                if (table.equals("club")) {
                    //((MainFragment) mContext.getFragmentManager().findFragmentByTag("main")).setResult(resultObj);
                }
                break;*/
        }
    }

    private void Log(){
        Log.i("?!?!?!?!?", resultObj.getStatusCode() + " : " + resultObj.getBody());
        Log.i("?!?!?!?!?", ((BoardData)requestObj.getBody()).getTitle() + " / " + ((BoardData)requestObj.getBody()).getSubscript() + " / "+ ((BoardData)requestObj.getBody()).getId() + " / ");
    }
}
