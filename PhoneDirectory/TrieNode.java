package com.SystemDesign.PhoneDirectory;

import java.util.HashMap;

public class TrieNode {

    boolean isPhoneNumberEnd;
    String contactname;
    HashMap<Character,TrieNode>hm;

    public TrieNode() {
        hm=new HashMap<>();
        isPhoneNumberEnd=false;
        contactname=null;
    }
}
