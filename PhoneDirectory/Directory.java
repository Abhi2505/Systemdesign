package com.SystemDesign.PhoneDirectory;

import java.util.Map;

public class Directory {
    private final TrieNode root;
    public Directory(){
        root=new TrieNode();
    }
    //search insert and displayContact
    public String search(String phonenumber){
        TrieNode curr=root;
        for(char digit:phonenumber.toCharArray()){
            curr=curr.hm.get(digit);
            if(curr==null){
                return "Phone number not found";
            }
        }
        return curr.isPhoneNumberEnd?curr.contactname:"Phone number not found";
    }

    public void insert(String phonenumber,String contactname){
        TrieNode curr=root;
        for(char c:phonenumber.toCharArray()){
            curr.hm.putIfAbsent(c,new TrieNode());
            curr=curr.hm.get(c);
        }
        curr.isPhoneNumberEnd=true;
        curr.contactname=contactname;
    }

    public void displayContacts(){
        displayHelper(root,new StringBuilder());
    }

    public static void displayHelper(TrieNode root,StringBuilder phonenum){
        if(root.isPhoneNumberEnd){
            System.out.println("phone num is "+phonenum+" and the contact name is "+root.contactname);
            return ;
        }
        for(Map.Entry<Character,TrieNode>e: root.hm.entrySet()){
            phonenum.append(e.getKey());
            displayHelper(e.getValue(),phonenum);
            phonenum.deleteCharAt(phonenum.length()-1);
        }
    }
}

