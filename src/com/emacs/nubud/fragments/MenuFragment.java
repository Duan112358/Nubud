package com.emacs.nubud.fragments;

import com.emacs.nubud.MainActivity;
import com.emacs.nubud.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment {
	private String[] menus;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		menus = getResources().getStringArray(R.array.menus);
		ArrayAdapter<String> menuAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, menus);
		setListAdapter(menuAdapter);
	}
	
	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = new EntryListFragment();
		Bundle bundle = new Bundle();
		bundle.putString("category", menus[position]);
		newContent.setArguments(bundle);
		if (newContent != null)
			switchFragment(newContent);
	}
	
	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof MainActivity) {
			MainActivity ra = (MainActivity) getActivity();
			ra.switchContent(fragment);
		}
	}
}
