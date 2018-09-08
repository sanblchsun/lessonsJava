package com.example.javacode.androidclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ProgressFragment extends Fragment {
    View focusView = null;
    private Socket sock;
    private DataInputStream in;
    private DataOutputStream out;
    private final String SERVER_ADDR = "192.168.10.186";
    private final int SERVER_PORT = 8189;
    View view;
    private EditText login;
    private EditText password;
    private Intent intent;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_progress, container, false);

        Button btnFetch = (Button)view.findViewById(R.id.downloadBtn);

        login = view.findViewById(R.id.editText1);
        password = view.findViewById(R.id.editText2);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new ProgressTask().execute((Void) null);
            }
        });
        return view;
    }

    private class ProgressTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {

            try{
                sock = new Socket(SERVER_ADDR,SERVER_PORT);
                out = new DataOutputStream(sock.getOutputStream());
                out.writeUTF("/auth " + login.getText() + " " + password.getText());
                out.flush();
                ProgressFragment fragment = (ProgressFragment) getFragmentManager()
                        .findFragmentById(R.id.contentFragment);
            }
            catch (IOException ex){
                ex.printStackTrace();
                System.out.println("нет авторизации");
            }finally {
            }
            return false;
        }
    }
}
