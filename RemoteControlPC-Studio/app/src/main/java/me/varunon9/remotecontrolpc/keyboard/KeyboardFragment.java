package me.varunon9.remotecontrolpc.keyboard;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import me.varunon9.remotecontrolpc.MainActivity;
import me.varunon9.remotecontrolpc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment implements View.OnClickListener {

    /*private EditText typeHereEditText;
    private Button ctrlButton, altButton, shiftButton, enterButton, tabButton, escButton, printScrButton, backspaceButton;
    private Button deleteButton, clearTextButton;
    private Button nButton, tButton, wButton, rButton, fButton, zButton;
    private Button cButton, xButton, vButton, aButton, oButton, sButton;
    private Button ctrlAltTButton, ctrlShiftZButton, altF4Button;
    private String previousText = "";*/

    private Button intButton,nointButton;
    private Button adeButton,noadeButton;
    private Button o1Button,o2Button,o3Button,o4Button;
    private Button f1Button,f2Button,f3Button,f4Button;
    private Button v1Button,v2Button,v3Button,v4Button;
    private Button c1Button,c2Button,c3Button,c4Button;
    private Button contButton,repButton;
    //private int[] buttonState=new int[20];
    private HashMap<Integer,Integer> buttonMap=new HashMap<Integer,Integer>();
    private HashMap<Integer,Integer> buttonMapInverse=new HashMap<Integer,Integer>();
    private ArrayList<ArrayList<Integer>> buttonMatrix=new ArrayList<ArrayList<Integer>>();

    private int[] options=new int[6];

    public KeyboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_keyboard2, container, false);
        initialization(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.keyboard));
    }

    private void initialization(View rootView) {


        intButton = (Button) rootView.findViewById(R.id.intButton);
        nointButton = (Button) rootView.findViewById(R.id.nointButton);

        adeButton = (Button) rootView.findViewById(R.id.adeButton);
        noadeButton = (Button) rootView.findViewById(R.id.noadeButton);

        o1Button = (Button) rootView.findViewById(R.id.o1Button);
        o2Button = (Button) rootView.findViewById(R.id.o2Button);
        o3Button = (Button) rootView.findViewById(R.id.o3Button);
        o4Button = (Button) rootView.findViewById(R.id.o4Button);

        f1Button = (Button) rootView.findViewById(R.id.f1Button);
        f2Button = (Button) rootView.findViewById(R.id.f2Button);
        f3Button = (Button) rootView.findViewById(R.id.f3Button);
        f4Button = (Button) rootView.findViewById(R.id.f4Button);

        v1Button = (Button) rootView.findViewById(R.id.v1Button);
        v2Button = (Button) rootView.findViewById(R.id.v2Button);
        v3Button = (Button) rootView.findViewById(R.id.v3Button);
        v4Button = (Button) rootView.findViewById(R.id.v4Button);

        c1Button = (Button) rootView.findViewById(R.id.c1Button);
        c2Button = (Button) rootView.findViewById(R.id.c2Button);
        c3Button = (Button) rootView.findViewById(R.id.c3Button);
        c4Button = (Button) rootView.findViewById(R.id.c4Button);

        contButton = (Button) rootView.findViewById(R.id.contButton);
        repButton = (Button) rootView.findViewById(R.id.repButton);




        intButton.setOnClickListener(this);
        nointButton.setOnClickListener(this);

        adeButton.setOnClickListener(this);
        noadeButton.setOnClickListener(this);

        o1Button.setOnClickListener(this);
        o2Button.setOnClickListener(this);
        o3Button.setOnClickListener(this);
        o4Button.setOnClickListener(this);

        f1Button.setOnClickListener(this);
        f2Button.setOnClickListener(this);
        f3Button.setOnClickListener(this);
        f4Button.setOnClickListener(this);

        v1Button.setOnClickListener(this);
        v2Button.setOnClickListener(this);
        v3Button.setOnClickListener(this);
        v4Button.setOnClickListener(this);

        c1Button.setOnClickListener(this);
        c2Button.setOnClickListener(this);
        c3Button.setOnClickListener(this);
        c4Button.setOnClickListener(this);

        contButton.setOnClickListener(this);
        repButton.setOnClickListener(this);

        contButton.setTag(0);
        repButton.setTag(0);

        intButton.setTag(0);
        nointButton.setTag(0);

        adeButton.setTag(0);
        noadeButton.setTag(0);

        o1Button.setTag(0);
        o2Button.setTag(0);
        o3Button.setTag(0);
        o4Button.setTag(0);

        f1Button.setTag(0);
        f2Button.setTag(0);
        f3Button.setTag(0);
        f4Button.setTag(0);

        v1Button.setTag(0);
        v2Button.setTag(0);
        v3Button.setTag(0);
        v4Button.setTag(0);

        c1Button.setTag(0);
        c2Button.setTag(0);
        c3Button.setTag(0);
        c4Button.setTag(0);

        contButton.setTag(0);
        repButton.setTag(0);

        buttonMap=getButtonsMap();
        buttonMatrix=getButtonMatrix();
        buttonMapInverse=getButtonMapInverse();

    }


    private HashMap<Integer,Integer> getButtonsMap(){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(R.id.intButton,ButtonEnum.INTELIGIBLE);
        map.put(R.id.nointButton,ButtonEnum.NOINTELIGIBLE);

        map.put(R.id.adeButton,ButtonEnum.ADECUADO);
        map.put(R.id.noadeButton,ButtonEnum.NOADECUADO);

        map.put(R.id.o1Button,ButtonEnum.OMISIONES1);
        map.put(R.id.o2Button,ButtonEnum.OMISIONES2);
        map.put(R.id.o3Button,ButtonEnum.OMISIONES3);
        map.put(R.id.o4Button,ButtonEnum.OMISIONES4);

        map.put(R.id.f1Button,ButtonEnum.FLUIDEZ1);
        map.put(R.id.f2Button,ButtonEnum.FLUIDEZ2);
        map.put(R.id.f3Button,ButtonEnum.FLUIDEZ3);
        map.put(R.id.f4Button,ButtonEnum.FLUIDEZ4);

        map.put(R.id.v1Button,ButtonEnum.VELOCIDAD1);
        map.put(R.id.v2Button,ButtonEnum.VELOCIDAD2);
        map.put(R.id.v3Button,ButtonEnum.VELOCIDAD3);
        map.put(R.id.v4Button,ButtonEnum.VELOCIDAD4);

        map.put(R.id.c1Button,ButtonEnum.CURVA1);
        map.put(R.id.c2Button,ButtonEnum.CURVA2);
        map.put(R.id.c3Button,ButtonEnum.CURVA3);
        map.put(R.id.c4Button,ButtonEnum.CURVA4);

        map.put(R.id.contButton,ButtonEnum.CONTINUAR);
        map.put(R.id.repButton,ButtonEnum.REPETIR);
        return map;
    }

    private ArrayList<ArrayList<Integer>> getButtonMatrix(){
        ArrayList<ArrayList<Integer>> buttonMatrix=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1=new ArrayList<Integer>();
        row1.add(R.id.intButton);
        row1.add(R.id.nointButton);
        buttonMatrix.add(row1);

        ArrayList<Integer> row2=new ArrayList<Integer>();
        row2.add(R.id.adeButton);
        row2.add(R.id.noadeButton);
        buttonMatrix.add(row2);

        ArrayList<Integer> row3=new ArrayList<Integer>();
        row3.add(R.id.o1Button);
        row3.add(R.id.o2Button);
        row3.add(R.id.o3Button);
        row3.add(R.id.o4Button);
        buttonMatrix.add(row3);

        ArrayList<Integer> row4=new ArrayList<Integer>();
        row4.add(R.id.f1Button);
        row4.add(R.id.f2Button);
        row4.add(R.id.f3Button);
        row4.add(R.id.f4Button);
        buttonMatrix.add(row4);

        ArrayList<Integer> row5=new ArrayList<Integer>();
        row5.add(R.id.v1Button);
        row5.add(R.id.v2Button);
        row5.add(R.id.v3Button);
        row5.add(R.id.v4Button);
        buttonMatrix.add(row5);

        ArrayList<Integer> row6=new ArrayList<Integer>();
        row6.add(R.id.c1Button);
        row6.add(R.id.c2Button);
        row6.add(R.id.c3Button);
        row6.add(R.id.c4Button);
        buttonMatrix.add(row6);

        ArrayList<Integer> row7=new ArrayList<Integer>();
        row7.add(R.id.contButton);
        row7.add(R.id.repButton);
        buttonMatrix.add(row7);

        return buttonMatrix;
    }

    private HashMap<Integer,Integer> getButtonMapInverse(){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

        map.put(R.id.intButton,ButtonEnum.NSINTELIGIBLE);
        map.put(R.id.nointButton,ButtonEnum.NSINTELIGIBLE);

        map.put(R.id.adeButton,ButtonEnum.NSADECUADO);
        map.put(R.id.noadeButton,ButtonEnum.NSADECUADO);

        map.put(R.id.o1Button,ButtonEnum.NSOMISIONES);
        map.put(R.id.o2Button,ButtonEnum.NSOMISIONES);
        map.put(R.id.o3Button,ButtonEnum.NSOMISIONES);
        map.put(R.id.o4Button,ButtonEnum.NSOMISIONES);

        map.put(R.id.f1Button,ButtonEnum.NSFLUIDEZ);
        map.put(R.id.f2Button,ButtonEnum.NSFLUIDEZ);
        map.put(R.id.f3Button,ButtonEnum.NSFLUIDEZ);
        map.put(R.id.f4Button,ButtonEnum.NSFLUIDEZ);

        map.put(R.id.v1Button,ButtonEnum.NSVELOCIDAD);
        map.put(R.id.v2Button,ButtonEnum.NSVELOCIDAD);
        map.put(R.id.v3Button,ButtonEnum.NSVELOCIDAD);
        map.put(R.id.v4Button,ButtonEnum.NSVELOCIDAD);

        map.put(R.id.c1Button,ButtonEnum.NSCURVA);
        map.put(R.id.c2Button,ButtonEnum.NSCURVA);
        map.put(R.id.c3Button,ButtonEnum.NSCURVA);
        map.put(R.id.c4Button,ButtonEnum.NSCURVA);

        map.put(R.id.contButton,0);
        map.put(R.id.repButton,0);

        return map;
    }


    private void changeButtonState(int buttonId){
        int buttonRow=0;
        int keyCode = 17;//dummy initialization
        String action = "TYPE_KEY";

        for(int i=0;i<buttonMatrix.size();i++){
            ArrayList<Integer> row=buttonMatrix.get(i);
            for(Integer id:row){
                if(id==buttonId){
                    buttonRow=i;
                }
            }
        }
        for(Integer id:buttonMatrix.get(buttonRow)){
            if(id==buttonId){
                Button currentButton=(Button)getActivity().findViewById(id);
                if((int)currentButton.getTag()==0){
                    currentButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    currentButton.setTag(1);
                    keyCode=buttonMap.get(buttonId);
                    sendKeyCodeToServer(action, keyCode);
                }
                else{
                    currentButton.getBackground().clearColorFilter();
                    currentButton.setTag(0);
                    keyCode=buttonMapInverse.get(buttonId);
                    sendKeyCodeToServer(action, keyCode);
                }
            }
            else{
                Button currentButton=(Button)getActivity().findViewById(id);
                currentButton.getBackground().clearColorFilter();
                currentButton.setTag(0);
            }
        }

        if(buttonId==R.id.contButton || buttonId==R.id.repButton){
            clearAllButtonColors();
        }
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        changeButtonState(id);

            /*int keyCode = 17;//dummy initialization
            String action = "TYPE_KEY";

            //Button currentButton=(Button)getActivity().findViewById(id);
            //if(currentButton!=null){

            //}

            keyCode=buttonMap.get(id);
            if(keyCode!=0){
                sendKeyCodeToServer(action, keyCode);

                return;
            }*/



            /*switch (id) {
                case R.id.intButton:
                    if(options[4]!=1) {
                        intButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        nointButton.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.INTELIGIBLE;
                        options[4] = 1;
                    }
                    else{
                        intButton.getBackground().clearColorFilter();
                        options[4] = 0;
                    }
                    break;
                case R.id.nointButton:
                    if(options[4]!=2) {
                        nointButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        intButton.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.NOINTELIGIBLE;
                        options[4] = 2;
                    }
                    else{
                        nointButton.getBackground().clearColorFilter();
                        options[4] = 0;
                    }
                    break;
                case R.id.adeButton:
                    if(options[5]!=1) {
                        adeButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        noadeButton.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.ADECUADO;
                        options[5] = 1;
                    }
                    else{
                        adeButton.getBackground().clearColorFilter();
                        options[5] = 0;
                    }
                    break;
                case R.id.noadeButton:
                    if(options[5]!=2) {
                        noadeButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        adeButton.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.NOADECUADO;
                        options[5] = 2;
                    }
                    else{
                        noadeButton.getBackground().clearColorFilter();
                        options[5] = 0;
                    }
                    break;
                case R.id.o1Button:
                    if(options[0]!=1) {
                        o1Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        o2Button.getBackground().clearColorFilter();
                        o3Button.getBackground().clearColorFilter();
                        o4Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.OMISIONES1;
                        options[0] = 1;
                    }
                    else{
                        o1Button.getBackground().clearColorFilter();
                        options[0] = 0;
                    }
                    break;
                case R.id.o2Button:
                    if(options[0]!=2) {
                        o2Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        o1Button.getBackground().clearColorFilter();
                        o3Button.getBackground().clearColorFilter();
                        o4Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.OMISIONES2;
                        options[0] = 2;
                    }
                    else{
                        o2Button.getBackground().clearColorFilter();
                        options[0] = 0;
                    }
                    break;
                case R.id.o3Button:
                    if(options[0]!=3) {
                        o3Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        o2Button.getBackground().clearColorFilter();
                        o1Button.getBackground().clearColorFilter();
                        o4Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.OMISIONES3;
                        options[0] = 3;
                    }
                    else{
                        o3Button.getBackground().clearColorFilter();
                        options[0] = 0;
                    }
                    break;
                case R.id.o4Button:
                    if(options[0]!=4) {
                        o4Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        o2Button.getBackground().clearColorFilter();
                        o3Button.getBackground().clearColorFilter();
                        o1Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.OMISIONES4;
                        options[0] = 4;
                    }
                    else{
                        o4Button.getBackground().clearColorFilter();
                        options[0] = 0;
                    }
                    break;

                case R.id.f1Button:
                    if(options[2]!=1) {
                        f1Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        f2Button.getBackground().clearColorFilter();
                        f3Button.getBackground().clearColorFilter();
                        f4Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.FLUIDEZ1;
                        options[2] = 1;
                    }
                    else{
                        f1Button.getBackground().clearColorFilter();
                        options[2] = 0;
                    }
                    break;
                case R.id.f2Button:
                    if(options[2]!=2) {
                        f2Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                        f1Button.getBackground().clearColorFilter();
                        f3Button.getBackground().clearColorFilter();
                        f4Button.getBackground().clearColorFilter();
                        keyCode = ButtonEnum.FLUIDEZ2;
                        options[2] = 2;
                    }
                    else{
                        f2Button.getBackground().clearColorFilter();
                        options[2] = 0;
                    }
                    break;
                case R.id.f3Button:
                    f3Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    f2Button.getBackground().clearColorFilter();
                    f1Button.getBackground().clearColorFilter();
                    f4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.FLUIDEZ3;
                    options[2]=3;
                    break;
                case R.id.f4Button:
                    f4Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    f2Button.getBackground().clearColorFilter();
                    f3Button.getBackground().clearColorFilter();
                    f1Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.FLUIDEZ4;
                    options[2]=4;
                    break;

                case R.id.v1Button:
                    v1Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    v2Button.getBackground().clearColorFilter();
                    v3Button.getBackground().clearColorFilter();
                    v4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.VELOCIDAD1;
                    options[1]=1;
                    break;
                case R.id.v2Button:
                    v2Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    v1Button.getBackground().clearColorFilter();
                    v3Button.getBackground().clearColorFilter();
                    v4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.VELOCIDAD2;
                    options[1]=2;
                    break;
                case R.id.v3Button:
                    v3Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    v2Button.getBackground().clearColorFilter();
                    v1Button.getBackground().clearColorFilter();
                    v4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.VELOCIDAD3;
                    options[1]=3;
                    break;
                case R.id.v4Button:
                    v4Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    v2Button.getBackground().clearColorFilter();
                    v3Button.getBackground().clearColorFilter();
                    v1Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.VELOCIDAD4;
                    options[1]=4;
                    break;

                case R.id.c1Button:
                    c1Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    c2Button.getBackground().clearColorFilter();
                    c3Button.getBackground().clearColorFilter();
                    c4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.CURVA1;
                    options[3]=1;
                    break;
                case R.id.c2Button:
                    c2Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    c1Button.getBackground().clearColorFilter();
                    c3Button.getBackground().clearColorFilter();
                    c4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.CURVA2;
                    options[3]=2;
                    break;
                case R.id.c3Button:
                    c3Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    c2Button.getBackground().clearColorFilter();
                    c1Button.getBackground().clearColorFilter();
                    c4Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.CURVA3;
                    options[3]=3;
                    break;
                case R.id.c4Button:
                    c4Button.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    c2Button.getBackground().clearColorFilter();
                    c3Button.getBackground().clearColorFilter();
                    c1Button.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.CURVA4;
                    options[3]=4;
                    break;

                case R.id.contButton:
                    contButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    repButton.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.CONTINUAR;
                    options[5]=1;
                    clearAllButtonColors();
                    break;
                case R.id.repButton:
                    repButton.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    contButton.getBackground().clearColorFilter();
                    keyCode=ButtonEnum.REPETIR;
                    options[5]=2;
                    clearAllButtonColors();
                    break;
                //case R.id.aceptButton:
                    //if(almostOneOfEachButtonTypePressed()){

                    //}
                    //else{
                      //  Toast.makeText(getActivity(), "Tienes que pulsar al menos una opción de cada criterio", Toast.LENGTH_SHORT).show();
                    //}
                    //break;
                /*case me.varunon9.remotecontrolpc.R.id.enterButton:
                    keyCode = 10;
                    break;
                case me.varunon9.remotecontrolpc.R.id.tabButton:
                    keyCode = 9;
                    break;
                case me.varunon9.remotecontrolpc.R.id.escButton:
                    keyCode = 27;
                    break;
                case me.varunon9.remotecontrolpc.R.id.printScrButton:
                    keyCode = 154;
                    break;
                case me.varunon9.remotecontrolpc.R.id.deleteButton:
                    keyCode = 127;
                    break;
                case me.varunon9.remotecontrolpc.R.id.nButton:
                    keyCode = 78;
                    break;
                case me.varunon9.remotecontrolpc.R.id.tButton:
                    keyCode = 84;
                    break;
                case me.varunon9.remotecontrolpc.R.id.wButton:
                    keyCode = 87;
                    break;
                case me.varunon9.remotecontrolpc.R.id.rButton:
                    keyCode = 82;
                    break;
                case me.varunon9.remotecontrolpc.R.id.fButton:
                    keyCode = 70;
                    break;
                case me.varunon9.remotecontrolpc.R.id.zButton:
                    keyCode = 90;
                    break;
                case me.varunon9.remotecontrolpc.R.id.cButton:
                    keyCode = 67;
                    break;
                case me.varunon9.remotecontrolpc.R.id.xButton:
                    keyCode = 88;
                    break;
                case me.varunon9.remotecontrolpc.R.id.vButton:
                    keyCode = 86;
                    break;
                case me.varunon9.remotecontrolpc.R.id.aButton:
                    keyCode = 65;
                    break;
                case me.varunon9.remotecontrolpc.R.id.oButton:
                    keyCode = 79;
                    break;
                case me.varunon9.remotecontrolpc.R.id.sButton:
                    keyCode = 83;
                    break;
                case me.varunon9.remotecontrolpc.R.id.backspaceButton:
                    keyCode = 8;
                    break;*/
            //}
            //sendKeyCodeToServer(action, keyCode);
        //}

    }
    private void sendKeyCodeToServer(String action, int keyCode) {
        MainActivity.sendMessageToServer(action);
        MainActivity.sendMessageToServer(keyCode);
    }

    private boolean almostOneOfEachButtonTypePressed(){
        for(int value:options){
            if(value==0){
                return false;
            }
        }
        return true;
    }

    private void clearAllButtonColors(){

        intButton.getBackground().clearColorFilter();
        nointButton.getBackground().clearColorFilter();

        adeButton.getBackground().clearColorFilter();
        noadeButton.getBackground().clearColorFilter();

        o1Button.getBackground().clearColorFilter();
        o2Button.getBackground().clearColorFilter();
        o3Button.getBackground().clearColorFilter();
        o4Button.getBackground().clearColorFilter();

        f1Button.getBackground().clearColorFilter();
        f2Button.getBackground().clearColorFilter();
        f3Button.getBackground().clearColorFilter();
        f4Button.getBackground().clearColorFilter();

        v1Button.getBackground().clearColorFilter();
        v2Button.getBackground().clearColorFilter();
        v3Button.getBackground().clearColorFilter();
        v4Button.getBackground().clearColorFilter();

        c1Button.getBackground().clearColorFilter();
        c2Button.getBackground().clearColorFilter();
        c3Button.getBackground().clearColorFilter();
        c4Button.getBackground().clearColorFilter();



        contButton.getBackground().clearColorFilter();
        repButton.getBackground().clearColorFilter();

        for(int i=0;i<buttonMatrix.size();i++){
            ArrayList<Integer> row=buttonMatrix.get(i);
            for(Integer id:row){
                Button currentButton=(Button)getActivity().findViewById(id);
                currentButton.setTag(0);
            }
        }

        options=new int[7];
    }
    /*@Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        char ch = newCharacter(s, previousText);
        if (ch == 0) {
            return;
        }
        MainActivity.sendMessageToServer("TYPE_CHARACTER");
        MainActivity.sendMessageToServer(Character.toString(ch));
        previousText = s.toString();
    }
    @Override
    public void afterTextChanged(Editable s) {
    }*/

    /*private char newCharacter(CharSequence currentText, CharSequence previousText) {
        char ch = 0;
        int currentTextLength = currentText.length();
        int previousTextLength = previousText.length();
        int difference = currentTextLength - previousTextLength;
        if (currentTextLength > previousTextLength) {
            if (1 == difference) {
                ch = currentText.charAt(previousTextLength);
            }
        } else if (currentTextLength < previousTextLength) {
            if (-1 == difference) {
                ch = '\b';
            } else {
                ch = ' ';
            }
        }
        return ch;
    }*/

}

/**
 * ctrl: 17
 * alt: 18
 * shift: 16
 * enter: 10
 * tab: 9
 * esc: 27
 * prntScr: 154
 * backspace: 524
 * delete: 127
 * backspace: 8
 */
/**
 * N: 78
 * T: 84
 * W: 87
 * R: 82
 * F: 70
 * Z: 90
 * C: 67
 * X: 88
 * V: 86
 * A: 65
 * O: 79
 * S: 83

 */
