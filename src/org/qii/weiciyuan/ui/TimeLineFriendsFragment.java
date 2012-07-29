package org.qii.weiciyuan.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.dao.FriendsTimeLineMsg;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qii
 * Date: 12-7-29
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */
public class TimeLineFriendsFragment extends TimeLineAbstractFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        Bundle args = getArguments();

        View view = inflater.inflate(R.layout.timeline, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        timeLineAdapter = new TimeLineAdapter();
        listView.setAdapter(timeLineAdapter);


        new AsyncTask<Void, List<Map<String, String>>, List<Map<String, String>>>() {


            @Override
            protected List<Map<String, String>> doInBackground(Void... params) {

                return new FriendsTimeLineMsg().getMsgList();

            }

            @Override
            protected void onPostExecute(List<Map<String, String>> o) {
                list = o;
                timeLineAdapter.notifyDataSetChanged();

                super.onPostExecute(o);
            }
        }.execute();

        return view;
    }

}

