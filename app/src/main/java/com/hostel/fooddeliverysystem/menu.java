package com.hostel.fooddeliverysystem;

import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
        import android.widget.ExpandableListView;
        import android.widget.ExpandableListView.OnChildClickListener;
        import android.widget.ExpandableListView.OnGroupClickListener;
        import android.widget.ExpandableListView.OnGroupCollapseListener;
        import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.NumberPicker;
import android.widget.Toast;

public class menu extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        CollapsingToolbarLayout coll =(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        Intent intent=getIntent();
        String title=intent.getStringExtra("Name");
        coll.setTitle(title);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Soups");
        listDataHeader.add("Quick Bites");
        listDataHeader.add("Chats");
        listDataHeader.add("Starters");
        listDataHeader.add("Indian Breads");
        listDataHeader.add("Hyd Navab Biryani");
        listDataHeader.add("Veg Dishes");
        listDataHeader.add("Egg Dishes");
        listDataHeader.add("Chinese");
        listDataHeader.add("Biryani Combo");
        listDataHeader.add("Chicken");
        listDataHeader.add("Prawn");
        listDataHeader.add("Mutton");
        listDataHeader.add("Thali Combo");
        listDataHeader.add("Salads");
        listDataHeader.add("Desserts");
        listDataHeader.add("Hot&Cold Beverages");
        // Adding child data
        List<String> Soups = new ArrayList<String>();
        Soups.add("Veg Soup");
        Soups.add("Tomato Soup");
        Soups.add("Mushroom Soup");
        Soups.add("Chicken Clear Soup");
        Soups.add("Sweet Corn Chicken Soup");
        Soups.add("Hot & Sour Chicken Soup");
        Soups.add("Chicken Noodle Soup");
        Soups.add("Mix Noodle Soup");

        List<String> QuickBites = new ArrayList<String>();
        QuickBites.add("Veg Roll");
        QuickBites.add("Egg Roll");
        QuickBites.add("Chicken Roll");
        QuickBites.add("Veg Sandwich");
        QuickBites.add("Egg Sandwich");
        QuickBites.add("Chicken Sandwich");
        QuickBites.add("Bread Omlette");
        QuickBites.add("Onion/Gobi Pakoda");

        List<String> Chats = new ArrayList<String>();
        Chats.add("Paani Puri");
        Chats.add("Dahi Puri");
        Chats.add("Bhel Puri");
        Chats.add("Samosa");
        Chats.add("Chaana");
        Chats.add("Chaana Samosa");
        Chats.add("Masala Puri");
        Chats.add("Pav Bhaaji");

        listDataChild.put(listDataHeader.get(0), Soups); // Header, Child data
        listDataChild.put(listDataHeader.get(1), QuickBites);
        listDataChild.put(listDataHeader.get(2), Chats);
    }
}