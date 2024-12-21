package org.example.mobile;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, ArrayList<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = (contacts != null) ? contacts : new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact){
        if(!myContacts.contains(contact)){
            myContacts.add(contact);
            printContact();
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact updatedContact){
        if(myContacts.contains(oldContact)){
            int indexOfOldContact = myContacts.indexOf(oldContact);
            myContacts.set(indexOfOldContact, updatedContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        if (myContacts.contains(contact)){
            myContacts.remove(contact);
            printContact();
            return true;
        }
        return false;
    }

    public int findContact(Contact contact){
        if (myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }
        return -1;
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName) {
        for (Contact contact : myContacts) {
            if (contact.getName().equals(contactName)) {
                return contact;
            }
        }
        return null;
    }

    public void printContact(){
        for (int i = 0; i<myContacts.size(); i++){
            System.out.println((i+1) + "." + myContacts.get(i).getName() + "->" + myContacts.get(i).getPhoneNumber());
        }
    }
}
