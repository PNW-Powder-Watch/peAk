package com.twelvesixty.peak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateGroupActivity extends AppCompatActivity {
    // id variables for category names
    final int partyHardyID = R.id.checkBox_PartyHardy;
    final int offPisteID = R.id.checkBox_OffPiste;
    final int terrainParkID = R.id.checkBox_TerrainPark;
    final int familyFriendlyID = R.id.checkBox_FamilyFriendly;

    // id variables for difficulties
    final int greenCircleID = R.id.checkBox_GreenCircle;
    final int blueSquareID = R.id.checkBox_BlueSquare;
    final int blackDiamondID = R.id.checkBox_BlackDiamonds;
    final int doubleblackDiamondID = R.id.checkBox_DoubleBlackDiamonds;

    // difficulty tags stored as class variables for use across methods
    boolean greenCircleTag = false;
    boolean blueSquareTag = false;
    boolean blackDiamondTag = false;
    boolean doubleBlackDiamondTag = false;

    // group category tags stored as class variables for use across methods
    boolean partyHardyTag = false;
    boolean offPisteTag = false;
    boolean terrainParkTag = false;
    boolean familyFriendlyTag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
    }

    // on click method that takes in all of that data
    // need to account for when users don't fill in certain fields

    // submit takes me to the newly created group view

    public void onCreateTeamButtonClick(View view){
        // send that data off to the backend in a post body

        EditText capacityEditText = findViewById(R.id.editText_capacity);
        EditText groupNameEditText = findViewById(R.id.editText_groupName);
        EditText dateGoingEditText = findViewById(R.id.editText_groupDateGoing);
        EditText timeGoingEditText = findViewById(R.id.editText_groupTimeMeeting);
        EditText descriptionEditText = findViewById(R.id.editText_groupDescription);

        int capacityFormInput = Integer.parseInt(capacityEditText.getText().toString());
        String groupNameFormInput = groupNameEditText.getText().toString();
        String dateGoingFormInput = dateGoingEditText.getText().toString();
        String timeGoingFormInput = timeGoingEditText.getText().toString();
        String desciptionFormInput = descriptionEditText.getText().toString();

        List<HashMap<String,Boolean>> tagsList = generateTagsList();

        Team newTeam = new Team(capacityFormInput, groupNameFormInput, dateGoingFormInput, timeGoingFormInput, desciptionFormInput, tagsList);

        // need HTTP request sent back to backend
        // need to then populate the new form with these data
    }


    // checkbox click method inspired by: https://developer.android.com/guide/topics/ui/controls/checkbox
    public void onCategoryCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case partyHardyID:
                if (checked)
                    partyHardyTag = true;
                break;
            case offPisteID:
                if (checked)
                    offPisteTag = true;
                break;
            case terrainParkID:
                if (checked)
                    terrainParkTag = true;
                break;
            case familyFriendlyID:
                if (checked)
                    familyFriendlyTag = true;
                break;
        }
    }

    public void onDifficultyCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case greenCircleID:
                if (checked)
                    greenCircleTag = true;
                break;
            case blueSquareID:
                if (checked)
                    blueSquareTag = true;
                break;
            case blackDiamondID:
                if (checked)
                    blackDiamondTag = true;
                break;
            case doubleblackDiamondID:
                if (checked)
                    doubleBlackDiamondTag = true;
        }
    }

    private List<HashMap<String, Boolean>> generateTagsList() {
        List<HashMap<String, Boolean>> tagsMapList = new ArrayList<>();

        HashMap<String, Boolean> greenCircleMap = constructTagMaps("greenCircle", greenCircleTag);
        HashMap<String, Boolean> blueSquareMap = constructTagMaps("blueSquare", blueSquareTag);
        HashMap<String, Boolean> blackDiamondMap = constructTagMaps("blackDiamond", blackDiamondTag);
        HashMap<String, Boolean> doubleBlackDiamondMap = constructTagMaps("doubleBlackDiamond", doubleBlackDiamondTag);

        HashMap<String, Boolean> partyHardyMap = constructTagMaps("partyHardy", partyHardyTag);
        HashMap<String, Boolean> offPisteMap = constructTagMaps("offPiste", offPisteTag);
        HashMap<String, Boolean> terrainParkMap = constructTagMaps("terrainPark", terrainParkTag);
        HashMap<String, Boolean> familyFriendlyMap = constructTagMaps("familyFriendly", familyFriendlyTag);

        tagsMapList.add(greenCircleMap);
        tagsMapList.add(blueSquareMap);
        tagsMapList.add(blackDiamondMap);
        tagsMapList.add(doubleBlackDiamondMap);

        tagsMapList.add(partyHardyMap);
        tagsMapList.add(offPisteMap);
        tagsMapList.add(terrainParkMap);
        tagsMapList.add(familyFriendlyMap);

        return tagsMapList;
    }

    private HashMap<String, Boolean> constructTagMaps(String tagName, Boolean tagIsChecked) {
        HashMap<String, Boolean> tagMap = new HashMap<>();
        tagMap.put(tagName, tagIsChecked);
        return tagMap;
    }


}
