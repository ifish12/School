package com.cs616.defects.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by ian on 15-10-03.
 */
public class Defect {


    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * Create a list of Defect objects from a JSONArray
     * @param root
     * @return Created users
     */
    public static List<Defect> fromJson(JSONArray root) throws ParseException, JSONException {
        List<Defect> defects = new ArrayList<>();
        for(int i = 0; i < root.length(); i++)
            defects.add(fromJson(root.getJSONObject(i)));
        return defects;
    }

    /**
     * Create a Defect object from a JSONObject
     * @param root
     * @return Created defect
     */
    public static Defect fromJson(JSONObject root) throws ParseException, JSONException {
        Date newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(root.getString("created"));
        Date modDate = null;
        if(root.has("modified")) {
            if(root.get("modified") instanceof String)
                modDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(root.getString("modified"));
        }
        Defect temp = new Defect();
        temp.setCreated(newDate);
        temp.setUrl(root.getJSONObject("_links").getJSONObject("self").getString("href"));
        temp.setModified(modDate);
        temp.setSummary(root.getString("summary"));
        temp.setStatus(Status.valueOf(root.getString("status")));
        temp.setSeverity(Severity.valueOf(root.getString("severity")));
        return temp;
    }

    /* Fields */

    private String url;
    private Date created;
    private Date modified;
    private String summary;
    private Status status;
    private String assignedToUrl;
    private String createdByUrl;
    private Severity severity;


    /* Getters and Setters */

    public String getUrl() {
        return url;
    }

    public Defect setUrl(String url) {
        this.url = url;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Defect setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public Defect setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Defect setSummary(String summary) {
        this.summary = summary;
        return this;

    }

    public Status getStatus() {
        return status;
    }

    public Defect setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getAssignedToUrl() {
        return assignedToUrl;
    }

    public Defect setAssignedToUrl(String assignedToUrl) {
        this.assignedToUrl = assignedToUrl;
        return this;
    }

    public String getCreatedByUrl() {
        return createdByUrl;
    }

    public Defect setCreatedByUrl(String createdByUrl) {
        this.createdByUrl = createdByUrl;
        return this;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Defect setSeverity(Severity severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Return the JSON representation of the defect.
     * @return JSON representation of the defect
     */
    public String toJson() {
        String created = null;
        String modified = null;
        String summary = null;
        String status = null;
        String severity = null;
        String assignedTo = null;
        String createdBy = null;
        String jsonFinal = "{";

        if(this.getCreated() != null) {
            String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getCreated());
            created = "\"created\" : \"" + newstring + "\"";
            jsonFinal+=created;
        }
        if(this.getModified() != null) {
            String newstring = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.getModified());
            modified = ", \"modified\" : \"" + newstring + "\"";
            jsonFinal+=modified;
        }
        if(this.getSummary() != null){
            summary = ", \"summary\" : \"" + this.getSummary() + "\"";
            jsonFinal+=summary;
        }
        if(this.getStatus() != null) {
            status = ", \"status\" : \"" + this.getStatus().toString() + "\"";
            jsonFinal+=status;
        }
        if(this.getSeverity() != null){
            severity = ", \"severity\" : \"" + this.getSeverity().toString() + "\"";
            jsonFinal+=severity;
        }
        if(this.getAssignedToUrl() != null){
            assignedTo = ", \"assignedTo\" : \"" + this.getAssignedToUrl() + "\"";
            jsonFinal+=assignedTo;
        }
        if(this.getCreatedByUrl() != null) {
            createdBy = ", \"createdBy\" : \"" + this.getCreatedByUrl() + "\"";
            jsonFinal+=createdBy;
        }
        jsonFinal+="}";

        // System.out.println(jsonFinal);
        return jsonFinal;



    }

    /* helper for .equals() */
    private static boolean nullOrEqual(Object o1, Object o2) {
        try {
            // was (o1 == null && o2 == null) || (o1.equals(o2));
            // returns true if: o1 == null and o2 == null,
            // shortcut: if o1 == o2 then o1.equals(o2) by property of equality.
            return (o1 == o2) || (o1.equals(o2));
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object rhsObj) {
        Defect rhs = (Defect) rhsObj;

        List<Boolean> tests = new LinkedList<>();
        tests.add( nullOrEqual(this.created,    rhs.created) );
        tests.add( nullOrEqual(this.status,     rhs.status) );
        tests.add( nullOrEqual(this.summary,    rhs.summary) );
        tests.add( nullOrEqual(this.modified,   rhs.modified) );
        tests.add( nullOrEqual(this.url,        rhs.url));
        tests.add( nullOrEqual(this.createdByUrl,  rhs.createdByUrl) );
        tests.add( nullOrEqual(this.assignedToUrl, rhs.assignedToUrl));

        return !tests.contains(false);
    }

}
